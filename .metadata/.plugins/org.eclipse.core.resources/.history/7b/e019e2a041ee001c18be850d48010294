package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;

public class Store {
	public static final int MAX_SIZE = 100;
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	
	public void addMedia(Media media) {
		if (itemsInStore.size() < MAX_SIZE) {
			itemsInStore.add(media);
			System.out.println("A new media has been successfully added into Store!");
		} else {
			System.out.println("The storage of Store has been already full.");
		}
	}
	
	
	public void removeMedia(Media media) {
		itemsInStore.remove(media);
	}
	
	public void addMedia(Media media, int amount) {
		for (int i = 0; i < amount; i++) {
			if (itemsInStore.size() + 1 > MAX_SIZE) {
				System.out.println("The cart is already full, some of items are not added into cart.");
				return;
			} else {
				itemsInStore.add(media);
			}
		}
		System.out.println("Some items has been successfully added!");
	}
	
	
	public void addMedia(Media... args) {
		for (Media media: args) {
			if (itemsInStore.size() > MAX_SIZE - 1) {
				System.out.println("The cart is already full, some of items are not added into cart.");
				return;
			} else {
				itemsInStore.add(media);
			}
		}
		System.out.println("Successfully added!");
	}
	
	public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}
}
