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
	
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
}
