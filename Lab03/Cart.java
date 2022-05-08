
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
			qtyOrdered ++;
			System.out.println("This disc has been added");
			totalCost += disc.getCost(); // plus the cost of the new added item
		}
	}

	public int removeDigitalVideoDisc(DigitalVideoDisc disc) {
		int qtyOrderedBackup = qtyOrdered;
		DigitalVideoDisc[] Temp_itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

		for (int i = 0; i < qtyOrderedBackup; i++) {
			Temp_itemsOrdered[i] = itemsOrdered[i]; // Clone itemsOrdered array
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
	
	public float TotalCost() {
		return totalCost;
	}
	

}
