package hust.soict.dsai.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.MenuListener;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreManagerScreen extends JFrame{
	protected Store store;
	protected Container cp;
	
	public StoreManagerScreen(Store store) {
		this.cp = getContentPane();
		this.store = store;
		
		this.cp = getContentPane();
		this.cp.setLayout(new BorderLayout());
		this.cp.add(createNorth(), BorderLayout.NORTH);
		this.cp.add(createCenter(), BorderLayout.CENTER);

		
		setTitle("Store");
		setSize(1024, 768);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	public void clrscr() {
		cp.removeAll();
		cp.revalidate();
		cp.repaint();
	}
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JPanel createSouth() {
		JPanel jp = new JPanel();
		
		return jp;
	}
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		
		JMenuItem addViewStoreItem = new JMenuItem("View store");
		menu.add(addViewStoreItem);
		addViewStoreItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//dispose();
				//new StoreManagerScreen(store);
				cp = getContentPane();
			}
		});
		menu.add(addViewStoreItem);
		
		
		JMenu smUpdateStore = new JMenu("Update Store");
		
		JMenuItem addBookMenuItem = new JMenuItem("Add Book");
		
		smUpdateStore.add(addBookMenuItem);
		addBookMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StoreManagerScreen.this.clrscr();
				//dispose();
				StoreManagerScreen.this.setContentPane(new AddBookToStoreScreen(store, cp));
				//;
				
				
			}
		});
		
		
		smUpdateStore.add(new JMenuItem("Add CD"));
		smUpdateStore.add(new JMenuItem("Add DVD"));
		
		menu.add(smUpdateStore);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		return header;
	}
	
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 2, 2));
		
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		
		//for(int i = 0; i < 9; i ++) {
		for (int i = 0; i < mediaInStore.size(); i ++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i));
			center.add(cell);
		}
		return center;
 	}
	
	public Store getStore() {
		return store;
	}
	
	
	public static void main(String... args) {
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", 
				"Animation", 
				"Roger Allers", 
				87, 
				19.95f);

		Book dvd2 = new Book("Star Wars", 
				"Science Fiction",
				87);

		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", 
				"Animation", 
				18.99f);
		
		Store store = new Store();
		store.addMedia(dvd1);
		store.addMedia(dvd2);
		store.addMedia(dvd3);
		new StoreManagerScreen(store);
	}
	
	
	
}
