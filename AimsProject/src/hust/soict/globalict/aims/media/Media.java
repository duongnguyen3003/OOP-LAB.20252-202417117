package hust.soict.globalict.aims.media;

import java.util.Comparator;

public abstract class Media implements Comparable<Media> {
    
    private int id;
    private String title;
    private String category;
    private float cost;

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    public Media() {
    }

    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    // Override equals method
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Object to compare is null");
        }
        if (!(obj instanceof Media)) {
            throw new ClassCastException("Object to compare is not a Media");
        }
        Media other = (Media) obj;
        return this.title != null && this.title.equals(other.getTitle()) && this.cost == other.getCost();
    }

    @Override
    public int compareTo(Media other) {
        if (other == null) {
            throw new NullPointerException("Media to compare is null");
        }
        int titleCompare = this.title.compareTo(other.getTitle());
        if (titleCompare != 0) {
            return titleCompare;
        }
        return Float.compare(this.cost, other.getCost());
    }
    }