package hust.soict.globalict.aims;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import hust.soict.globalict.aims.store.Store;
import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.exception.LimitExceededException;
import javax.swing.JOptionPane;
import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Add some dummy data to the store
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 0, 24.95f)); // DVD with 0 length
        store.addMedia(new DigitalVideoDisc("Aladdin", "Animation", 18.99f));

        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    seeCurrentCart();
                    break;
                case 0:
                    System.out.println("Exiting AIMS. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
        
        scanner.close();
    }

    public static void showMenu() {
        System.out.println("\nAIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void viewStore() {
        System.out.println("\n--- Store Inventory ---");
        for (Media m : store.getItemsInStore()) {
            System.out.println(m.toString());
        }

        int choice;
        do {
            storeMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    seeMediaDetails();
                    break;
                case 2:
                    addMediaToCart();
                    break;
                case 3:
                    playMedia();
                    break;
                case 4:
                    seeCurrentCart();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    public static void storeMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    public static void seeMediaDetails() {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media media = findMediaByTitle(title, store.getItemsInStore());
        if (media != null) {
            System.out.println(media.toString());
            mediaDetailsMenu(media);
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void mediaDetailsMenu(Media media) {
        int choice;
        do {
            System.out.println("\nOptions: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add to cart");
            if (media instanceof Playable) {
                System.out.println("2. Play");
            }
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    try {
                        cart.addMedia(media);
                    } catch (LimitExceededException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Limit Exceeded", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 2:
                    if (media instanceof Playable) {
                        try {
                            ((Playable) media).play();
                        } catch (PlayerException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Player Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        System.out.println("This media is not playable.");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    public static void addMediaToCart() {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media media = findMediaByTitle(title, store.getItemsInStore());
        if (media != null) {
            try {
                cart.addMedia(media);
            } catch (LimitExceededException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Limit Exceeded", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void playMedia() {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media media = findMediaByTitle(title, store.getItemsInStore());
        if (media != null && media instanceof Playable) {
            try {
                ((Playable) media).play();
            } catch (PlayerException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Player Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            System.out.println("Media not found or not playable.");
        }
    }

    public static void updateStore() {
        System.out.println("\nUpdate Store logic here...");
    }

    public static void seeCurrentCart() {
        cart.displayCart();
        int choice;
        do {
            cartMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter filter: ");
                    String filter = scanner.nextLine();
                    cart.searchByTitle(filter);
                    break;
                case 2:
                    System.out.println("1. Sort by Title Cost\n2. Sort by Cost Title");
                    int sortChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (sortChoice == 1) cart.sortByTitleCost();
                    else cart.sortByCostTitle();
                    cart.displayCart();
                    break;
                case 3:
                    System.out.print("Enter title to remove: ");
                    String title = scanner.nextLine();
                    Media media = findMediaByTitle(title, cart.getItemsOrdered());
                    if (media != null) cart.removeMedia(media);
                    else System.out.println("Not in cart.");
                    break;
                case 4:
                    System.out.print("Enter title to play: ");
                    String playTitle = scanner.nextLine();
                    Media playMedia = findMediaByTitle(playTitle, cart.getItemsOrdered());
                    if (playMedia != null && playMedia instanceof Playable) {
                        try {
                            ((Playable) playMedia).play();
                        } catch (PlayerException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Player Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        System.out.println("Not found or not playable.");
                    }
                    break;
                case 5:
                    System.out.println("Order placed!");
                    cart.getItemsOrdered().clear();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    public static void cartMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
    }

    private static Media findMediaByTitle(String title, java.util.List<Media> list) {
        for (Media m : list) {
            if (m.getTitle().equalsIgnoreCase(title)) return m;
        }
        return null;
    }
}
