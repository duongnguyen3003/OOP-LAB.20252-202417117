package hust.soict.globalict.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
    private static int nbDigitalVideoDiscs = 0;

    // By title
    public DigitalVideoDisc(String title) {
        super(title, null, 0.0f, 0, null);
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
    }

    // By category, title and cost
    public DigitalVideoDisc(String category, String title, float cost) {
        super(title, category, cost, 0, null);
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
    }

    // By director, category, title and cost
    public DigitalVideoDisc(String director, String category, String title, float cost) {
        super(title, category, cost, 0, director);
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
    }

    // By all attributes
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, cost, length, director);
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
    }

    public boolean isMatch(String title) {
        if (this.getTitle() == null) return false;
        return this.getTitle().toLowerCase().contains(title.toLowerCase());
    }

    @Override
    public String toString() {
        return "DVD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + " mins: " + getCost() + " $";
    }

    // play() method
    @Override
    public void play() {
        if (this.getLength() > 0) {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        } else {
            System.out.println("DVD '" + this.getTitle() + "' cannot be played because its length is invalid (0 or less).");
        }
    }
}