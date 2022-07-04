package hust.soict.dsai.aims.cart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.utils.DVDUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList; 

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	//private ObservableList<Media> itemsOrdered = new ObservableList<Media>();
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
	///private ArrayList
	
	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}
	
	public void addMedia(Media media) {
		if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
			itemsOrdered.add(media);
			System.out.println("A new item has been successfully added into Cart!");
		} else {
			System.out.println("The cart has been already full.");
		}
	}
	


	public void setItemsOrdered(ObservableList<Media> itemsOrdered) {
		this.itemsOrdered = itemsOrdered;
	}

	public void addMedia(Media media, int amount) {
		for (int i = 0; i < amount; i++) {
			if (itemsOrdered.size() + 1 > MAX_NUMBERS_ORDERED) {
				System.out.println("The cart is already full, some of items are not added into cart.");
				return;
			} else {
				itemsOrdered.add(media);
			}
		}
		System.out.println("Some items has been successfully added into Cart!");
	}
	
	
	public void addMedia(Media... args) {
		for (Media media: args) {
			if (itemsOrdered.size() > MAX_NUMBERS_ORDERED - 1) {
				System.out.println("The cart is already full, some of items are not added into cart.");
				return;
			} else {
				itemsOrdered.add(media);
			}
		}
		System.out.println("Some items has been successfully added into Cart!");
	}
	
	public void removeMedia(Media media) {
		itemsOrdered.remove(media);
	}
	
	public float totalCost() {
		float sum = 0;
		for (Media media: itemsOrdered) {
			sum += media.getCost();
		}
		return sum;
		
	}
	
	public void printByCostTitleOrder() {
		@SuppressWarnings("unchecked")
		//ObservableList<Media> temp = (ObservableList<Media>) itemsOrdered.clone();
		ObservableList<Media> temp =  FXCollections.observableArrayList();
		Collections.copy(temp, itemsOrdered);
		
		Collections.sort(temp, DVDUtils.costTitleComparator);
		for (Media media: temp) {
			System.out.println(media);
		}
	}
	
	public void printByTitleCostOrder() {
		@SuppressWarnings("unchecked")
		ObservableList<Media> temp =  FXCollections.observableArrayList();
		Collections.copy(temp, itemsOrdered);
		
		Collections.sort(temp, DVDUtils.titleCostComparator);
		for (Media media: temp) {
			System.out.println(media);
		}
	}

	public void print() {
		int count = 0;
		for (Media media: itemsOrdered) {
			count ++;
			System.out.printf("%d. ", (count));
			System.out.println(media);
		}
		System.out.println("Total cost: " + this.totalCost());
		
 	}
	
	public ObservableList<Media> searchByTitle(String title) {
		ObservableList<Media> foundItems =  FXCollections.observableArrayList();//DigitalVideoDisc[MAX_NUMBERS_ORDERED];
		//List<Media> foundItems = new ArrayList<Media>();
		
		for (Media item: itemsOrdered) {
			if (item.isMatch(title)) {
				System.out.println(item);
				foundItems.add(item);
				//foundItems[count] = itemsOrdered.get(i);
			}
		}

		if (foundItems.size() > 0) 
			System.out.println("Found!");
		else {
			System.out.println("No match is found!");
		}
		
		return foundItems;
	}
	
	public Media searchById(int id) {
		try {
			System.out.println("Found!");
			return itemsOrdered.get(id - 1);
		} catch(IndexOutOfBoundsException e) {
			System.out.println("No match is found!");
			return null;
		}
	}
	
	public Media getALuckyItem() {
		int rand = -1;
		if (itemsOrdered.size() >= 5) {
			int min = 0;
			int max = itemsOrdered.size() - 1;
			int range = max - min + 1;
			
			rand = (int)(Math.random() * range) + min;
		}
		return itemsOrdered.get(rand);
	}
}
