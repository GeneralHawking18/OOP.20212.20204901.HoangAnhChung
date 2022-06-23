package hust.soict.dsai.aims.media.disc;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.track.Track;
import hust.soict.dsai.aims.playable.Playable;

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
	public String play() {
		String playedThing = "Author by artist: " + artist + "\n" 
						+ "Total length: :" + this.getLength() + "\n";
			
		
		System.out.println(playedThing);
		
		for (Track track: tracks) {
			playedThing += "\n" + track.play();
			
			System.out.println(track.play());
			
			
		}
		return playedThing;
		
	}
	@Override 
	public String toString() {
		return String.format("CD - %s - %s - %s - %s - %f", super.getTitle(), super.getCategory(), super.getDirector(), this.getLength(), super.getCost());
	}
}
