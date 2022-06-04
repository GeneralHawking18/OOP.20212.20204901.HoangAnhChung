package hust.soict.dsai.aims.cart.Cart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.BiFunction;

import hust.soict.dsai.aims.disc.DigitalVideoDisc.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.utils.DVDUtils.DVDUtils; 

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private float TotalCost = 0;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	
	public void addMedia(Media media) {
		
	}
	
	public void removeMedia(Media media) {
		
	}
	
	
	public float totalCost() {
		float sum = 0;
		for (Media media: itemsOrdered) {
			sum += media.getCost();
		}
		return sum;
		//return TotalCost;
	}
	
	public void printByCostOrder() {
		DigitalVideoDisc[] temp = Arrays.copyOf(itemsOrdered, qtyOrdered);
		temp = DVDUtils.sortByCost(temp);
		for (int i = 0; i < qtyOrdered; i++) {
			System.out.printf("%d. ", (i + 1));
			System.out.println(temp[i]);
		}
	}
	
	public void print() {
		BiFunction <DigitalVideoDisc, DigitalVideoDisc, Byte> comparer = DVDUtils::compareInPrint;
		DigitalVideoDisc[] temp = Arrays.copyOf(itemsOrdered, qtyOrdered);
		DVDUtils.quickSortASC(temp, 0, qtyOrdered - 1, comparer);
		
		for (int i = 0; i < qtyOrdered; i++) {
			System.out.printf("%d. ", (i + 1));
			System.out.println(temp[i]);
		}
		System.out.println("Total cost: " + totalCost);
		
 	}
	
	public void printByTitleCostOrder() {
		DigitalVideoDisc[] temp = Arrays.copyOf(itemsOrdered, qtyOrdered);
		temp = DVDUtils.sort(temp, DVDUtils::compareByTitleCost);
		
		for (int i = 0; i < qtyOrdered; i++) {
			System.out.printf("%d. ", (i + 1));
			System.out.println(temp[i]);
		}
	}
	
	public void printByCostTitleOrder() {
		DigitalVideoDisc[] temp = Arrays.copyOf(itemsOrdered, qtyOrdered);
		temp = DVDUtils.sort(temp, DVDUtils::compareByCostTitle);
		
		for (int i = 0; i < qtyOrdered; i++) {
			System.out.printf("%d. ", (i + 1));
			System.out.println(temp[i]);
		}
	}
	
	public DigitalVideoDisc[] searchByTitle(String title) {
		int count = 0;
		DigitalVideoDisc[] foundItems = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
		
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].isMatch(title)) {
				count ++;
				System.out.printf("%d. ", (count));
				System.out.println(itemsOrdered[i]);
				foundItems[count] = itemsOrdered[i];
			}
		}
		
		if (count > 0) return Arrays.copyOf(foundItems, count);
		else {
			System.out.println("No match is found!");
			return new DigitalVideoDisc[0];
		}
	}
	
	public DigitalVideoDisc searchById(int id) {
		for (DigitalVideoDisc dvd: itemsOrdered) {
			if (dvd.getId() == id) {
				System.out.println(dvd);
				return dvd;
			}
		}
		return null;
	}

}
