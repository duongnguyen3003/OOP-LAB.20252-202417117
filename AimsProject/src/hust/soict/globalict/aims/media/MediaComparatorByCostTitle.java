package hust.soict.globalict.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        // Compare by cost descending
        int costCompare = Float.compare(m2.getCost(), m1.getCost());
        if (costCompare != 0) {
            return costCompare; 
        }
        // If costs are the same, compare by title alphabetically
        return m1.getTitle().compareToIgnoreCase(m2.getTitle()); 
    }
}