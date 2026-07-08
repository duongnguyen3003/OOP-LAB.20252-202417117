package hust.soict.globalict.aims.screen.manager;

import hust.soict.globalict.aims.store.Store;
import java.awt.*;
import javax.swing.*;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;
    protected String itemType;
    protected JTextField tfTitle = new JTextField();
    protected JTextField tfCategory = new JTextField();
    protected JTextField tfCost = new JTextField();

    public AddItemToStoreScreen(Store store, String itemType) {
        this.store = store;
        this.itemType = itemType;
        
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Add " + itemType + " to Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    protected JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    protected JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        JMenuItem viewStoreMenu = new JMenuItem("View store");
        
        viewStoreMenu.addActionListener(e -> { new StoreManagerScreen(store); dispose(); });
        
        menu.add(viewStoreMenu);
        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }

    protected JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel title = new JLabel("Add " + itemType);
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 40));
        title.setForeground(Color.CYAN);
        header.add(title);
        return header;
    }

    protected abstract JPanel createCenter();
}