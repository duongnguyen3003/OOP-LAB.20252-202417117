package hust.soict.globalict.aims.screen.manager;

import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.store.Store;
import java.awt.*;
import javax.swing.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfDirector = new JTextField();
    private JTextField tfLength = new JTextField();

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store, "DVD");
    }

    @Override
    protected JPanel createCenter() {
        JPanel center = new JPanel(new GridLayout(6, 2, 10, 10));
        center.add(new JLabel("Title: ")); center.add(tfTitle);
        center.add(new JLabel("Category: ")); center.add(tfCategory);
        center.add(new JLabel("Cost: ")); center.add(tfCost);
        center.add(new JLabel("Director: ")); center.add(tfDirector);
        center.add(new JLabel("Length (mins): ")); center.add(tfLength);

        JButton btnAdd = new JButton("Add DVD");
        btnAdd.addActionListener(e -> {
            try {
                store.addMedia(new DigitalVideoDisc(tfTitle.getText(), tfCategory.getText(), 
                        tfDirector.getText(), Integer.parseInt(tfLength.getText()), Float.parseFloat(tfCost.getText())));
                JOptionPane.showMessageDialog(this, "DVD Added Successfully!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numbers for Cost and Length.");
            }
        });
        center.add(new JLabel()); center.add(btnAdd);
        return center;
    }
}