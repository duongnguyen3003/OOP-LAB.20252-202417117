package hust.soict.globalict.aims.screen.manager;

import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.store.Store;
import java.awt.*;
import javax.swing.*;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfDirector;
    private JTextField tfLength;
    private JTextField tfArtist;

    public AddCompactDiscToStoreScreen(Store store) {
        super(store, "CD");
    }

    @Override
    protected JPanel createCenter() {
        // Initialize variables here
        tfDirector = new JTextField();
        tfLength = new JTextField();
        tfArtist = new JTextField();

        JPanel center = new JPanel(new GridLayout(7, 2, 10, 10));
        center.add(new JLabel("Title: ")); center.add(tfTitle);
        center.add(new JLabel("Category: ")); center.add(tfCategory);
        center.add(new JLabel("Cost: ")); center.add(tfCost);
        center.add(new JLabel("Director: ")); center.add(tfDirector);
        center.add(new JLabel("Length (mins): ")); center.add(tfLength);
        center.add(new JLabel("Artist: ")); center.add(tfArtist);

        JButton btnAdd = new JButton("Add CD");
        btnAdd.addActionListener(e -> {
            try {
                store.addMedia(new CompactDisc(tfTitle.getText(), tfCategory.getText(), Float.parseFloat(tfCost.getText()),
                        Integer.parseInt(tfLength.getText()), tfDirector.getText(), tfArtist.getText()));
                JOptionPane.showMessageDialog(this, "CD Added Successfully!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numbers for Cost and Length.");
            }
        });
        center.add(new JLabel()); center.add(btnAdd);
        return center;
    }
}