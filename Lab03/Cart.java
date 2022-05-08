
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
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].getTitle() == disc.getTitle()) {
				totalCost -= itemsOrdered[i].getCost(); // subtract the cost of the removed item
				itemsOrdered[i] = null;
				qtyOrdered --;
				int j = i;
				
				while (j < qtyOrdered - 1) {
					itemsOrdered[j] = itemsOrdered[j + 1];
					itemsOrdered[j + 1] = null;
					j++;
				
				}
			}
		}
	}
	
	public float TotalCost() {
		return totalCost;
	}
	

}
