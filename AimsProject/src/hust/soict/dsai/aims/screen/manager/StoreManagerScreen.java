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
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.MenuListener;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.disc.CompactDisc;
import hust.soict.dsai.aims.media.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.media.track.Track;
import hust.soict.dsai.aims.store.Store;

public class StoreManagerScreen extends JFrame{
	protected Store store;
	
	public StoreManagerScreen(Store store) {
		Container cp = getContentPane();
	
		this.store = store;
		
		cp.setLayout(new BorderLayout());
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);

		
		setTitle("Store");
		setSize(1024, 768);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	
	JPanel createCenter() {
		
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 2, 2));
		
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for (int i = 0; i < mediaInStore.size(); i ++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i));
			center.add(cell);
		}
		return center;
	}
	
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		MenuItem viewStoreItem = new MenuItem("View store");
		viewStoreItem.addTo(menu, StoreManagerScreen.class);
		//viewStore(menu);
		
		
		JMenu smUpdateStore = new JMenu("Update Store");
		
		
		MenuItem addBookItem = new MenuItem("Add Book");
		addBookItem.addTo(smUpdateStore, AddBookToStoreScreen.class);
	
		MenuItem addCDItem = new MenuItem("Add CD");
		addCDItem.addTo(smUpdateStore, AddCompactDiscToStoreScreen.class);
		
		MenuItem addDVDItem = new MenuItem("Add DVD");
		addDVDItem.addTo(smUpdateStore, AddDigitalVideoDiscToStoreScreen.class);
		
		
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
	
	public Store getStore() {
		return store;
	}
	
	private class MenuItem extends JMenuItem {
		public MenuItem(String text) {
			super(text);
		}
		public void addTo(JMenu menu, Class screenClass) {
			menu.add(this);
			this.addActionListener(new ActionListener() {
				@SuppressWarnings("unchecked")
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
					try {
						screenClass.getConstructor(Store.class).newInstance(store);
					} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e1) {
						e1.printStackTrace();
					};
				}
			});
		}
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

		CompactDisc dvd3 = new CompactDisc("Aladin", 
				"Animation", 
				"Test", 18.99f);
		dvd3.addTrack(new Track("123", 123));
		dvd3.addTrack(new Track("1234", 123));
		
		Store store = new Store();
		store.addMedia(dvd1);
		store.addMedia(dvd2);
		store.addMedia(dvd3);
		new StoreManagerScreen(store);
	}

}
