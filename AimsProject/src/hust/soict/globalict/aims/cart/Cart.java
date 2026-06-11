package hust.soict.globalict.aims.cart;

import java.util.Collections;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import hust.soict.globalict.aims.media.Media;

public class Cart {
    // Changed to ObservableList for JavaFX
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public static final int MAX_NUMBERS_ORDERED = 20;

    // Add a Media to the cart
    public void addMedia(Media media) throws hust.soict.globalict.aims.exception.LimitExceededException {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            if (!itemsOrdered.contains(media)) {
                itemsOrdered.add(media);
                System.out.println(media.getTitle() + " has been added to the cart.");
            } else {
                System.out.println(media.getTitle() + " is already in the cart.");
            }
        } else {
            throw new hust.soict.globalict.aims.exception.LimitExceededException("ERROR: The number of media has reached its limit (" + MAX_NUMBERS_ORDERED + ")");
        }
    }

    // Remove a Media from the cart
    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println(media.getTitle() + " has been removed from the cart.");
        } else {
            System.out.println(media.getTitle() + " is not in the cart.");
        }
    }

    // Calculate total cost
    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    // Print all items in the cart
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

    // Search for a Media by its ID
    public void searchById(int id) {
        boolean matchFound = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Match found: " + media.toString());
                matchFound = true;
                break; 
            }
        }
        if (!matchFound) {
            System.out.println("No match found for ID: " + id);
        }
    }

    // Search for a Media by its Title
    public void searchByTitle(String title) {
        boolean matchFound = false;
        for (Media media : itemsOrdered) {
            if (media.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println("Match found: " + media.toString());
                matchFound = true;
            }
        }
        if (!matchFound) {
            System.out.println("No match found for title: " + title);
        }
    }

    public void displayCart() {
        System.out.println("=======================CART=======================");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).getTitle() + " - " + itemsOrdered.get(i).getCost() + " $");
        }
        System.out.println("Total Cost: " + totalCost() + " $");
        System.out.println("===================================================");
    }

    public void sortByTitleCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("The cart has been sorted by Title, then Cost.");
    }

    public void sortByCostTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("The cart has been sorted by Cost, then Title.");
    }
}