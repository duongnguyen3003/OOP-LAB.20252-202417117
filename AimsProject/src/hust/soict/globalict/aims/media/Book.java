package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private int id;
    private String title;
    private String category;
    private float cost;
    private List<String> authors = new ArrayList<String>();

    public Book() {
    }

    // Getters and Setters
    public float getCost() {
        return cost;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    // Method to add an author
    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println("The author " + authorName + " has been added.");
        } else {
            System.out.println("The author " + authorName + " is already in the list!");
        }
    }

    // Method to remove an author
    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("The author " + authorName + " has been removed.");
        } else {
            System.out.println("The author " + authorName + " was not found in the list.");
        }
    }
}