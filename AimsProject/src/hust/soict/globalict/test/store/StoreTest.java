package hust.soict.globalict.test.store;

import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        // Create new Media objects
        DigitalVideoDisc media1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc media2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc media3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);

        System.out.println("--- Testing addMedia ---");
        store.addMedia(media1);
        store.addMedia(media2);
        store.addMedia(media3);

        System.out.println("\n--- Testing removeMedia ---");
        // Remove an existing Media
        store.removeMedia(media2);
        
        // Attempt to remove a Media that is no longer in the store
        store.removeMedia(media2);
    }
}