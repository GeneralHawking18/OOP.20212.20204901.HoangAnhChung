package hust.soict.dsai.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;
//import hust.soict.dsai.aims.screen.manager.AddBookToStoreScreen;
//import hust.soict.dsai.aims.screen.manager.StoreManagerScreen;


public abstract class AddItemToStoreScreen extends Container {
	private Store store;
	private Media media;
	private Container mainCp;
	JTextField titleTF;
	JTextField categoryTF;
	JTextField costTF; 
	
	
	public AddItemToStoreScreen(Store store, Container cp) {
		this.store = store;
		this.mainCp = cp;
		super.setLayout(new BorderLayout());
		
		super.add(createNorth(), BorderLayout.NORTH);
		
		super.add(createCenter(), BorderLayout.CENTER);
		
		super.add(createSouth(), BorderLayout.SOUTH);
		
		/* setTitle("Store");
		setSize(1024, 768);
		setLocationRelativeTo(null);
		setVisible(true); */
		
	}
	
	public abstract JPanel createCenter();
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		
		return north;
	}
	
	public JPanel createSouth() {
		JPanel south = new JPanel();
		south.setLayout(new FlowLayout());
	
		
		JButton submitButton = new JButton("Submit");
		submitButton.setSize(10, 10);
	
		submitButton.addActionListener(new ButtonListener());
		south.add(submitButton);
		return south;
	}
	
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		MenuItem viewStoreItem = new MenuItem("View store");
		viewStoreItem.addTo(menu, mainCp.getClass());
		//viewStore(menu);
		
		
		JMenu smUpdateStore = new JMenu("Update Store");
		MenuItem addBookItem = new MenuItem("Add Book");
		addBookItem.addTo(smUpdateStore, AddBookToStoreScreen.class);
	
		
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
	
	class MediaEntry {
		public JPanel createTitle() {
			JPanel jp = new JPanel();
			jp.setLayout(new FlowLayout());
		
			jp.add(new JLabel("Enter the title of book: "));
		
			titleTF = new JTextField(10);
			jp.add(titleTF);
		
			return jp;
	}
	
		public JPanel createCategory() {
			JPanel jp = new JPanel();
			jp.setLayout(new FlowLayout());
		
			jp.add(new JLabel("Enter the category of book: "));
		
			categoryTF = new JTextField(10);
			jp.add(categoryTF);
		
			return jp;
	}
	
	
		public JPanel createCost() {
			JPanel jp = new JPanel();
			jp.setLayout(new FlowLayout());
		
			jp.add(new JLabel("Enter the cost of book: "));
		
			costTF = new JTextField(6);
			jp.add(costTF);
			jp.add(new JLabel("$"));
		
			return jp;
		}
		
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
					//dispose();
					try {
						screenClass.getConstructor(Store.class, Container.class).newInstance(store, mainCp);
					} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException | InvocationTargetException e1) {
						try {
							screenClass.getConstructor().newInstance();
						} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e2) {
							e1.printStackTrace();
						}
					};				
				}
			});
		}
		
		/* public void addTo(JMenu menu, Container container) {
			menu.add(this);
			this.addActionListener(new ActionListener() {
				@SuppressWarnings("unchecked")
				@Override
				public void actionPerformed(ActionEvent e) {
					//dispose();
					try {
						screenClass.getConstructor(Store.class).newInstance(store);
					} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e1) {
						e1.printStackTrace();
					}
;				}
			});
		}*/
	};
	

	private class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			AddItemToStoreScreen.this.createMedia();
			store.addMedia(media);
			
		}
	}
	public void setMedia(Media media) {
		this.media = media; 
	}
	
	public abstract void createMedia();
}