package hust.soict.globalict.aims.media;

public class Disc extends Media {
    private int length;
    private String director;

    public Disc() {
        super();
    }

    public Disc(String title) {
        super(title, null, 0.0f); 
    }

    public Disc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public Disc(String title, String category, float cost, int length, String director) {
        super(title, category, cost);
        this.length = length;
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }
}