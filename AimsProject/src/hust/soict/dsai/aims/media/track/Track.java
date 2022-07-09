package hust.soict.dsai.aims.media.track;


import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.playable.Playable;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.ButtonBar.ButtonData;

public class Track implements Playable {
	private String title;
	private int length;
	
	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getLength() {
		return length;
	}
	
	public static String preprocessLabel(String text) {
		text = "<html>" + text + "</html>";
		return text.replace("\n", "<br>");
	}
	
	public void play() throws PlayerException {
		if (this.getLength() > 0) {
			String playedThing = "Playing track: " + this.getTitle() + "\n" 
					+ "Track length: " + this.getLength();
			playedThing = preprocessLabel(playedThing);
			
			JOptionPane.showMessageDialog(null, playedThing, "Playing..." , JOptionPane.INFORMATION_MESSAGE);
			
			//System.out.println(playedThing);
		} else {
			throw new PlayerException("ERROR: Track length is non-positive!");
		}
	}
	
	@Override 
	public boolean equals(Object o) {
		if (!(o instanceof Track)) {
			return false;
		}
		else {
			Track trackObj = (Track) o;
			return (trackObj.getTitle() == this.getTitle()) && trackObj.getLength() == this.getLength();
		}
	}
}
