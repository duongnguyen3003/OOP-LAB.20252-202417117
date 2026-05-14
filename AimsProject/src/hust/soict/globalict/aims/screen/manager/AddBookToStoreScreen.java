package hust.soict.globalict.aims.screen.manager;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.store.Store;
import java.awt.*;
import javax.swing.*;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfAuthors = new JTextField();

    public AddBookToStoreScreen(Store store) {
        super(store, "Book");
    }

    @Override
    protected JPanel createCenter() {
        JPanel center = new JPanel(new GridLayout(5, 2, 10, 10));
        center.add(new JLabel("Title: ")); center.add(tfTitle);
        center.add(new JLabel("Category: ")); center.add(tfCategory);
        center.add(new JLabel("Cost: ")); center.add(tfCost);
        center.add(new JLabel("Authors (comma-separated): ")); center.add(tfAuthors);

        JButton btnAdd = new JButton("Add Book");
        btnAdd.addActionListener(e -> {
            try {
                Book book = new Book(tfTitle.getText(), tfCategory.getText(), Float.parseFloat(tfCost.getText()));
                String[] authors = tfAuthors.getText().split(",");
                for (String author : authors) {
                    if (!author.trim().isEmpty()) book.addAuthor(author.trim());
                }
                store.addMedia(book);
                JOptionPane.showMessageDialog(this, "Book Added Successfully!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid number for Cost.");
            }
        });
        center.add(new JLabel()); center.add(btnAdd);
        return center;
    }
}