package hust.soict.dsai.aims.media;

import java.time.LocalDate;
import java.util.Comparator;

import hust.soict.dsai.aims.comparator.MediaComparatorByCostTitle;
import hust.soict.dsai.aims.comparator.MediaComparatorByTitleCost;


public abstract class Media implements Comparable<Object>{
	protected int id;
	protected String title;
	protected String category;
	protected float cost;
	
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	
	protected static int nbMedia = 0;
	
	protected LocalDate dateAdded;

	public void increId() {
		nbMedia ++;
		this.id = nbMedia;
		
	}
	
	public Media(String title) {
		this.title = title;
		increId();
		this.dateAdded = LocalDate.now();
		
	}
	
	public Media(String title, String category, float cost) {
		this.title = title;
		this.category = category;
		this.cost = cost;
		increId();
		this.dateAdded = LocalDate.now();
	}
	
	
	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}


	public String getCategory() {
		return category;
	}


	public float getCost() {
		return cost;
	}


	public LocalDate getDateAdded() {
		return dateAdded;
	}
	
	@Override
	public int compareTo(Object o){
		try {
			Media media = (Media) o;
			int titleVal = this.title.compareToIgnoreCase(media.getTitle());
			float costVal = this.getCost() - media.getCost();
			
			if (!(titleVal == 0)) {
				titleVal = titleVal / Math.abs(titleVal);
				return titleVal;
			} 
		
			if (!(costVal == 0)) {
				costVal =  costVal / Math.abs(costVal);
				return (int) costVal;
			}
			
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (ClassCastException e) {
			e.printStackTrace();
		}
		
		return 0;
		
		
	}
	
	
	public boolean isMatch(String title) {
		return this.getTitle().toLowerCase().contains(title.toLowerCase());
	}
	
	
	@Override
	public boolean equals(Object o) {
		
		try {
			if (((Media) o).getTitle() == this.getTitle() && ((Media) o).getCost() == this.getCost()) {
				return true;
			}
		} catch (NullPointerException e) {
			return false;
		} catch (ClassCastException e) {
			return false;
		}
		return false;
		
	
	}
}
