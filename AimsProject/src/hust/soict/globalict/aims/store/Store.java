package hust.soict.globalict.aims.store;

import hust.soict.globalict.aims.disc.DigitalVideoDisc;

public class Store {
    // Defining a maximum capacity for the store's array
    public static final int MAX_ITEMS_IN_STORE = 100;
    
    private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[MAX_ITEMS_IN_STORE];
    private int qtyInStore = 0;

    // Method to add a DVD to the store
    public void addDVD(DigitalVideoDisc dvd) {
        if (qtyInStore < MAX_ITEMS_IN_STORE) {
            itemsInStore[qtyInStore] = dvd;
            qtyInStore++;
            System.out.println("The DVD '" + dvd.getTitle() + "' has been added to the store.");
        } else {
            System.out.println("The store is full. Cannot add more DVDs.");
        }
    }

    // Method to remove a DVD from the store
    public void removeDVD(DigitalVideoDisc dvd) {
        boolean found = false;
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i] == dvd) {
                found = true;
                for (int j = i; j < qtyInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[qtyInStore - 1] = null; // Clear the last duplicated element
                qtyInStore--;
                System.out.println("The DVD '" + dvd.getTitle() + "' has been removed from the store.");
                break;
            }
        }
        if (!found) {
            System.out.println("The DVD '" + dvd.getTitle() + "' was not found in the store.");
        }
    }
}