package hust.soict.globalict.test.store;

import hust.soict.globalict.aims.disc.DigitalVideoDisc;
import hust.soict.globalict.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        // Create new DVD objects
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);

        System.out.println("--- Testing addDVD ---");
        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd3);

        System.out.println("\n--- Testing removeDVD ---");
        // Remove an existing DVD
        store.removeDVD(dvd2);
        
        // Attempt to remove a DVD that is no longer in the store
        store.removeDVD(dvd2);
    }
}