public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    // Original add method (from previous section)
    public void addDigitalVideoDisc(DigitalVideoDisc disc) 
    {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added: " + disc.getTitle());
            if (qtyOrdered == MAX_NUMBERS_ORDERED) {
                System.out.println("The cart is almost full.");
            }
        } else {
            System.out.println("The cart is full. Cannot add: " + disc.getTitle());
        }
    }

    // Overloaded add method 1: Passing an array of DVDs
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) 
    {
        for (int i = 0; i < dvdList.length; i++) {
            if (qtyOrdered < MAX_NUMBERS_ORDERED) {
                itemsOrdered[qtyOrdered] = dvdList[i];
                qtyOrdered++;
                System.out.println("The disc has been added: " + dvdList[i].getTitle());
            } else {
                System.out.println("The cart is full. Cannot add remaining discs.");
                break;
            }
        }
    }

    // Overloaded add method 2: Passing a variable number of parameters
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }

    // Remove method (from previous section)
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) { 
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                // Shift remaining elements to the left
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null; // Clear last element
                qtyOrdered--;
                System.out.println("The disc has been removed: " + disc.getTitle());
                return;
            }
        }
        System.out.println("Disc not found in the cart.");
    }

    // Calculate total cost (from previous section)
    public float totalCost() { //
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost(); //
        }
        return total;
    }

    // Display cart items method (from previous section)
    public void displayCart() { //
        System.out.println("=======================CART=======================");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i + 1) + ". " + itemsOrdered[i].getTitle() + " - " + itemsOrdered[i].getCost());
        }
        System.out.println("Total Cost: " + totalCost());
        System.out.println("===================================================");
    }
}