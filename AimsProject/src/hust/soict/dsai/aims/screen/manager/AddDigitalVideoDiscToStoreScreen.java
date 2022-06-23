package hust.soict.dsai.aims.screen.manager;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JTextField;

import hust.soict.dsai.aims.media.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;


public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen{
	private JTextField directorTF;
	private JTextField lengthTF;
	
	public AddDigitalVideoDiscToStoreScreen(Store store) {
		super(store);
	}
	
	@Override
	public JPanel createCenter() {
		JPanel center = new JPanel();
		DVDEntry dvdEntry = new DVDEntry();
		center.setLayout(new BoxLayout(center, BoxLayout.PAGE_AXIS));
		center.add(dvdEntry.createTitle());
		center.add(dvdEntry.createCategory());
		center.add(dvdEntry.createDirector());
		center.add(dvdEntry.createLength());
		center.add(dvdEntry.createCost());
		
		return center;
	}
	
	
	@Override 
	public void createMedia() {
		String title = titleTF.getText();
		String category = categoryTF.getText();
		String director = directorTF.getText();
		int length = Integer.parseInt(lengthTF.getText());
		Float cost = Float.parseFloat(costTF.getText());
		
		DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
		super.setMedia(dvd);
	}
	
	private class DVDEntry extends MediaEntry {
		JPanel createDirector() {
			JPanel jp = new JPanel();
			jp.setLayout(new FlowLayout());
		
			jp.add(new JLabel("Enter the director: "));
		
			directorTF = new JTextField(25);
		
			jp.add(directorTF);
			return jp;
		}
		
		JPanel createLength() {
			JPanel jp = new JPanel();
			jp.setLayout(new FlowLayout());
		
			jp.add(new JLabel("Enter the length: "));
		
			lengthTF = new JTextField(3);
		
			jp.add(lengthTF);
			return jp;
		}
	}
	
	
	
}
