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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;



public abstract class AddItemToStoreScreen extends StoreManagerScreen {
	private Media media;
	JTextField titleTF;
	JTextField categoryTF;
	JTextField costTF; 
	
	
	public AddItemToStoreScreen(Store store) {
		super(store);
		super.add(createSouth(), BorderLayout.SOUTH);
		
	}

	@Override 
	public JPanel createNorth() {
		JPanel jp = super.createNorth();
		JLabel label = new JLabel(this.getClass().getSimpleName()); 
		label.setAlignmentX(CENTER_ALIGNMENT);
		label.setFont(new Font(label.getFont().getName(), Font.CENTER_BASELINE, 15));
		jp.add(label);
		return jp;
	}
	
	public abstract JPanel createCenter();
	
	public JPanel createSouth() {
		JPanel south = new JPanel();
		south.setLayout(new FlowLayout());
	
		
		JButton submitButton = new JButton("Submit");
		submitButton.setSize(10, 10);
	
		submitButton.addActionListener(new ButtonListener());
		south.add(submitButton);
		return south;
	}
	
	
	class MediaEntry {
		public JPanel createTitle() {
			JPanel jp = new JPanel();
			jp.setLayout(new FlowLayout());
		
			jp.add(new JLabel("Enter the title: "));
		
			titleTF = new JTextField(10);
			jp.add(titleTF);
		
			return jp;
	}
	
		public JPanel createCategory() {
			JPanel jp = new JPanel();
			jp.setLayout(new FlowLayout());
		
			jp.add(new JLabel("Enter the category: "));
		
			categoryTF = new JTextField(10);
			jp.add(categoryTF);
		
			return jp;
	}
	
	
		public JPanel createCost() {
			JPanel jp = new JPanel();
			jp.setLayout(new FlowLayout());
		
			jp.add(new JLabel("Enter the cost: "));
		
			costTF = new JTextField(6);
			jp.add(costTF);
			jp.add(new JLabel("$"));
		
			return jp;
		}
		
	}
	

	private class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			AddItemToStoreScreen.this.createMedia();
			store.addMedia(media);
			
			JFrame frame = new JFrame();
	        JOptionPane.showMessageDialog(frame,
	                "Successfully added!",
	                "Notification",
	                JOptionPane.INFORMATION_MESSAGE);
	
		}
	}
	public void setMedia(Media media) {
		this.media = media; 
	}
	
	public abstract void createMedia();
}