package hust.soict.dsai.aims.media.disc;

import java.time.LocalDate;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.playable.Playable;

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
	
	public String play() {
		String playedThing = "Playing DVD: " + this.getTitle() + "\n"
							+ "DVD length: " + this.getLength();
		System.out.println(playedThing);
		return playedThing;
	}
}
