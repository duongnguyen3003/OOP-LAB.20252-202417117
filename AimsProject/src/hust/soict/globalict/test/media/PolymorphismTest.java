package hust.soict.globalict.test.media;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import java.util.ArrayList;
import java.util.List;

public class PolymorphismTest {
    public static void main(String[] args) {
        List<Media> mediaE = new ArrayList<Media>();

        // Create some media objects
        CompactDisc cd = new CompactDisc("So Wrong, It's Right", "Rock", 15.99f, 38, "Don Gilmore", "All Time Low");
        DigitalVideoDisc dvd = new DigitalVideoDisc("The Matrix", "Sci-Fi", "John Wick", 136, 19.99f);
        Book book = new Book("Clean Code", "Programming", 29.99f);

        // Add them to the list
        mediaE.add(cd);
        mediaE.add(dvd);
        mediaE.add(book);

        for (Media m : mediaE) {
            System.out.println(m.toString());
        }
    }
}