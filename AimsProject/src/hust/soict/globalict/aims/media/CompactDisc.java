package hust.soict.globalict.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    public CompactDisc(String title, String category, float cost, int length, String director, String artist) {
        super(title, category, cost, length, director);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Track '" + track.getTitle() + "' has been added to the CD.");
        } else {
            System.out.println("Track '" + track.getTitle() + "' already exists in the CD.");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track '" + track.getTitle() + "' has been removed from the CD.");
        } else {
            System.out.println("Track '" + track.getTitle() + "' was not found in the CD.");
        }
    }

    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    // play() method
    @Override
    public void play() {
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("CD Artist: " + this.getArtist());
        System.out.println("Total CD length: " + this.getLength());

        if (this.getLength() > 0) {
            for (Track track : tracks) {
                track.play();
            }
        } else {
            System.out.println("The CD '" + this.getTitle() + "' cannot be played because its total length is 0 or less.");
        }
    }
}