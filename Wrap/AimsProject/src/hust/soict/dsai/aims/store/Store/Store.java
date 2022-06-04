package hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.disc.DigitalVideoDisc.DigitalVideoDisc;
import java.util.Arrays;

public class Store {
	public static final int MAX_SIZE = 100;
	private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[MAX_SIZE];
	private int qtyAvailable = 0;
	
	
	public void addDVD(DigitalVideoDisc dvd) {
		itemsInStore[qtyAvailable] = dvd;
		qtyAvailable ++;
	}
	
	public int removeDVD(DigitalVideoDisc dvd) {
		int qtyAvailableBackup = qtyAvailable;
		
		DigitalVideoDisc[] Temp_itemsInStore = Arrays.copyOf(itemsInStore, qtyAvailable);
		
		for (int i = 0; i < qtyAvailableBackup; i++) {
			if (itemsInStore[i] != null && itemsInStore[i].getTitle() == dvd.getTitle()) {
				Temp_itemsInStore[i] = null;
				qtyAvailable --;
				
			}
			itemsInStore[i] = null; // be empty all slots in itemsInStore
		}
		
		int j = 0;
		for (int i = 0; i < qtyAvailableBackup; i++) {
			if (Temp_itemsInStore[i] != null) {
				itemsInStore[j] = Temp_itemsInStore[i]; // Refill the undeleted items
				j ++;
			}
		}
		
		return qtyAvailable - qtyAvailableBackup;
	}
	
	public DigitalVideoDisc[] getItemsInStore() {
		return itemsInStore;
	}
	
	public int getQtyAvailable() {
		return qtyAvailable;
	}
}
