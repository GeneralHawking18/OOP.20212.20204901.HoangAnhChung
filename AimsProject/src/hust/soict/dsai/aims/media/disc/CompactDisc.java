package hust.soict.dsai.aims.media.disc;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.track.Track;
import hust.soict.dsai.aims.playable.Playable.Playable;

public class CompactDisc extends Disc implements Playable{
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	
	public CompactDisc(String title) {
		super(title);
	}

	public CompactDisc(String title, String category, float cost) {
		super(title, category, cost);
	}


	public CompactDisc(String title, String category, String director, float cost) {
		super(title, category, director, cost);
	}

	
	public CompactDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
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
	
	public void play() {
		System.out.println("Author by artist :" + artist);
		System.out.println("Total length: :" + this.getLength());
		for (Track track: tracks) {
			track.play();
		}
	}
	@Override 
	public String toString() {
		return String.format("CD - %s - %s - %s - %s - %f", super.getTitle(), super.getCategory(), super.getDirector(), this.getLength(), super.getCost());
	}
}
