package hust.soict.globalict.aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() { 
        return title; 
    }
    
    public int getLength() { 
        return length; 
    }

    @Override
    public void play() {
        if (this.getLength() > 0) {
            System.out.println("Playing track: " + this.getTitle());
            System.out.println("Track length: " + this.getLength());
        } else {
            System.out.println("Track '" + this.getTitle() + "' cannot be played because its length is invalid (0 or less).");
        }
    }

    // Override equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Track)) {
            return false;
        }
        Track other = (Track) obj;
        return this.length == other.getLength() && this.title != null && this.title.equals(other.getTitle());
    }
}