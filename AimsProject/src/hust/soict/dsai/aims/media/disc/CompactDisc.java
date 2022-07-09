package hust.soict.dsai.aims.media.disc;

import java.util.ArrayList;

import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.track.Track;
import hust.soict.dsai.aims.playable.Playable;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.ButtonBar.ButtonData;

public class CompactDisc extends Disc implements Playable{
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	
	public CompactDisc(String title) {
		super(title);
	}
	public CompactDisc(String title, String artist) {
		super(title);
		this.artist = artist;
	}

	public CompactDisc(String title, String category, String artist, float cost) {
		super(title, category, cost);
		this.artist = artist;
	}


	public CompactDisc(String title, String category, String director, String artist, float cost) {
		super(title, category, director, cost);
		this.artist = artist;
	}

	
	public CompactDisc(String title, String category, String director, String artist, int length, float cost) {
		super(title, category, director, length, cost);
		this.artist = artist;
	}
	
	
	
	public String getArtist() {
		return artist;
	}
	
	public void addTrack(Track track) {
		if (tracks.contains(track) == false) {
			tracks.add(track);
		}
	}
	
	public void removeTrack(Track track) {
		if (tracks.contains(track) == true) {
			tracks.remove(track);
		}
	}
	
	@Override
	public int getLength() {
		int sum = 0;
		for (Track track: tracks) {
			sum += track.getLength();
		}
		return sum;
	}
	
	@Override
	public void play() throws PlayerException{
		if (this.getLength() > 0) {
			java.util.Iterator<Track> iter = tracks.iterator();
			Track nextTrack;
			while (iter.hasNext()) {
				nextTrack = (Track) iter.next();
				try {
					nextTrack.play();
				}
				catch(PlayerException e) {
					throw e;
				}
			}
			/*String playedThing = "Author by artist: " + artist + "\n" 
					+ "Total length: :" + this.getLength() + "\n";
			11System.out.println(playedThing);*/
			
		} else {
			System.err.println();
			throw new PlayerException("ERROR: CD length is non-positive!");
		}
		// return playedThing;
		
	}
	@Override 
	public String toString() {
		return String.format("CD - %s - %s - %s - %s - %f", super.getTitle(), super.getCategory(), super.getDirector(), this.getLength(), super.getCost());
	}
}
