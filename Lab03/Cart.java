
public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	private int sumCost = 0;
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered == MAX_NUMBERS_ORDERED) {
			System.out.println("This cart is almost full");
		} else {
			qtyOrdered  ++;
			itemsOrdered[qtyOrdered] = disc;
			System.out.println("This disc has been added");
			sumCost += disc.getCost(); // plus the cost of the new added item
		}
	}
	
	
	public int TotalCost() {
		return sumCost;
	}
	
	
}
