package hust.soict.dsai.aims.cart.Cart;

import java.util.Arrays;
import java.util.function.BiFunction;


import hust.soict.dsai.aims.disc.DigitalVideoDisc.DigitalVideoDisc;
import hust.soict.dsai.aims.utils.DVDUtils.DVDUtils; 


public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	private float totalCost = 0;
	
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered == MAX_NUMBERS_ORDERED) {
			System.out.println("This cart is almost full");
		} else {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered++;
			System.out.println("This disc has been added");
			totalCost += disc.getCost(); // plus the cost of the new added item
		}
	}
	
	
	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdlist) {
		for (int i = 0; i < dvdlist.length; i++) {
			addDigitalVideoDisc(dvdlist[i]);
			if (qtyOrdered == MAX_NUMBERS_ORDERED) {
				addDigitalVideoDisc(dvdlist[i]); // Just print the message 'Full'
				break;
			}
		}	
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc, int amount) {
		for (int i = 0; i < amount; i++) {
			addDigitalVideoDisc(disc);
			if (qtyOrdered == MAX_NUMBERS_ORDERED) {
				addDigitalVideoDisc(disc); // Just print the message 'Full'
				break;
			}
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
		DigitalVideoDisc[] temp = {disc1, disc2};
		addDigitalVideoDisc(temp);
	}
	
	public int removeDigitalVideoDisc(DigitalVideoDisc disc) {
		int qtyOrderedBackup = qtyOrdered;
		
		DigitalVideoDisc[] Temp_itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
		for (int i = 0; i < qtyOrderedBackup; i++) {
			Temp_itemsOrdered[i] = itemsOrdered[i];
		}
			
		
		for (int i = 0; i < qtyOrderedBackup; i++) {
			if (itemsOrdered[i] != null && itemsOrdered[i].getTitle() == disc.getTitle()) {
				totalCost -= itemsOrdered[i].getCost(); // subtract the cost of the removed item
				Temp_itemsOrdered[i] = null;
				qtyOrdered --;
				
			}
			itemsOrdered[i] = null; // be empty all slots in itemsOrdered
		}
		int j = 0;
		
		for (int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
			if (Temp_itemsOrdered[i] != null) {
				itemsOrdered[j] = Temp_itemsOrdered[i]; // Refill the undeleted items
				j ++;
			}
		}
		
		return qtyOrdered - qtyOrderedBackup;
	}
	
	public float TotalCost() {
		return totalCost;
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
	public int getQtyOrdered() {
		return qtyOrdered;
	}
	
	public DigitalVideoDisc[] getItemsOrdered() {
		return itemsOrdered;
	}

}
