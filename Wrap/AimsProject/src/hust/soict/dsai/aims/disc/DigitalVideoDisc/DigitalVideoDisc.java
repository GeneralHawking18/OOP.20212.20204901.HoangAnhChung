package hust.soict.dsai.aims.disc.DigitalVideoDisc;

import java.time.LocalDate;

import hust.soict.dsai.aims.media.Media;

public class DigitalVideoDisc extends Media{
	private String director;
	private int length;
	private LocalDate dateAdded;
	
	private static int nbDigitalVideoDiscs = 0;
	
	public DigitalVideoDisc(String title) {
		super(); //Actually it can be omitted in this block.
		this.title = title;
		this.dateAdded = LocalDate.now();
		
		IncreTag();
	}
	
	
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.dateAdded = LocalDate.now();
		
		IncreTag();
	}


	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		this.dateAdded = LocalDate.now();
		
		IncreTag();
	}

	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		
		IncreTag();
	}
	
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost, LocalDate dateAdded) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		this.dateAdded = dateAdded;
		
		IncreTag();
	}
	
	public void IncreTag() {
		nbDigitalVideoDiscs ++;
		id = nbDigitalVideoDiscs;
	}

	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	
	public LocalDate getDateAdded() {
		return dateAdded;
	}
	public void setDirector(String director) {
		this.director = director;
	}


	public void setLength(int length) {
		this.length = length;
	}


	public String toString() {
		return String.format("DVD - %s - %s - %s - %d - %f", title, category, director, length, cost);
	}
	
	public boolean isMatch(String title) {
		String[] other_words = title.split(" ", 0);
		String[] these_words = this.title.split(" ", 0);
		
		for (String word1: these_words) {
			for (String word2: other_words) {
				if (word1.compareToIgnoreCase(word2) == 0) {
					return true;
				}
			}
		}
		return false;
	}
	
}
