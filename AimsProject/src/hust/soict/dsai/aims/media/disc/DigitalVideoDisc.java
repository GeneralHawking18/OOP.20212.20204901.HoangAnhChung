package hust.soict.dsai.aims.media.disc;

import java.time.LocalDate;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.track.Track;
import hust.soict.dsai.aims.playable.Playable;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.ButtonBar.ButtonData;

public class DigitalVideoDisc extends Media implements Playable{
	private String director;
	private int length;
	
	public DigitalVideoDisc(String title) {
		super(title);
		this.title = title;
		this.dateAdded = LocalDate.now();
	}
	
	
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
		this.title = title;
		this.category = category;
		this.cost = cost;
	}


	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title, category, cost);
		this.director = director;
	}

	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, cost);
		this.director = director;
		this.length = length;
	}

	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}

	public String toString() {
		return String.format("DVD - %s - %s - %s - %d - %f", title, category, director, length, cost);
	}
	
	public void play() throws PlayerException {
		if (this.getLength() > 0) {
			// Set the default look-and-feel of system
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
					| UnsupportedLookAndFeelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String playedThing = "Playing DVD: " + this.getTitle() + "\n"
					+ "DVD length: " + this.getLength();
			JOptionPane.showMessageDialog(null, playedThing, "Playing..." , JOptionPane.INFORMATION_MESSAGE);
			
		} else {
			System.err.println();
			throw new PlayerException("ERROR: DVD length is non-positive!");
		}
		
		
		//System.out.println(playedThing);
		//return playedThing;
	}
}
