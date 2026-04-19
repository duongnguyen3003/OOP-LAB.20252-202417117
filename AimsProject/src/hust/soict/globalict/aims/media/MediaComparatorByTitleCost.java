package hust.soict.globalict.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        // Compare by title alphabetically
        int titleCompare = m1.getTitle().compareTo(m2.getTitle());

        if (titleCompare != 0) {
            return titleCompare; 
        }
        // If titles are the same, compare by cost
        return Float.compare(m2.getCost(), m1.getCost()); 
    }
}