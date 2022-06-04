package hust.soict.dsai.aims.Aims;
import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store.Store;
import hust.soict.dsai.aims.utils.DVDUtils.DVDUtils;

import java.util.Scanner;

public class Aims {
	private static Store store = new Store();
	private static Cart cart = new Cart();
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Cart anOrder = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", 
													"Animation", 
													"Roger Allers", 
													87, 
													19.95f);
		anOrder.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", 
													"Science Fiction",
													"George Lucas", 
													87, 
													24.95f);
		anOrder.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", 
													"Animation", 
													18.99f);
		anOrder.addDigitalVideoDisc(dvd3);
		anOrder.addDigitalVideoDisc(dvd1);
		DigitalVideoDisc[] temp = {dvd1, dvd1};
		anOrder.addDigitalVideoDisc(temp);
		anOrder.addDigitalVideoDisc(dvd1, dvd2);
		
		//anOrder.removeDigitalVideoDisc(dvd1);
		//anOrder.removeDigitalVideoDisc(dvd2);
		//anOrder.removeDigitalVideoDisc(dvd3);
		
		cart = anOrder;
		//cart.print();
		
		System.out.printf("Total cost is: \n%f\n", anOrder.TotalCost());
		store.addDVD(dvd1);
		store.addDVD(dvd2);
		store.addDVD(dvd3);
		showMenu();
	}
	
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
		
		int Entry = sc.nextInt();
		switch (Entry) {
			case 0:
				System.exit(0);
			case 1:
				storeMenu();
				break;
			case 2: 
				updateStoreMenu();
				break;
			case 3:
				cart.print();
				cartMenu();
				break;
		}		
	}	
		
	public static void updateStoreMenu() {
		System.out.println("One of three store-update options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add a new dvd into store");
		System.out.println("2. Remove a dvd from store");
		System.out.println("0. Back to main menu");
		System.out.println("Please choose a number: 0-1-2");
		
		int Entry = sc.nextInt();
		String title;
		switch (Entry) {
			case 0:
				showMenu();
				return;
				
			case 1:
				System.out.print("Enter the title of dvd: ");
				title = sc.next();
				if (title == "") title = null;
				
				System.out.print("Enter the category of dvd: ");
				String category = sc.next();
				if (category == "") title = null;
				
				
				System.out.print("Enter the director of dvd: ");
				String director = sc.next();
				if (director == "") title = null;
				
				
				System.out.print("Enter the length of dvd: ");
				int length = sc.nextInt();
				if (!(length > 0)) title = null;
				
				
				System.out.print("Enter the cost of dvd: ");
				float cost = sc.nextFloat();
				if (!(cost > 0)) title = null;
				
				
				store.addDVD(new DigitalVideoDisc(title, category, director, length, cost));
				System.out.println("Successfully added!");
				break;
				
			case 2:
				System.out.print("Enter desired title to remove from the store: ");
				sc = new Scanner(System.in);
				title = sc.nextLine();

				DigitalVideoDisc[] recycleBin = new DigitalVideoDisc[Cart.MAX_NUMBERS_ORDERED];
				int qtyTrashItems = 0;
		
				for (int i = 0; i < store.getQtyAvailable(); i++) {
					if (store.getItemsInStore()[i].getTitle().compareToIgnoreCase(title) == 0) {
						recycleBin[qtyTrashItems] = store.getItemsInStore()[i];
						qtyTrashItems ++;
					}
				}
				
				for (int i = 0; i < qtyTrashItems; i++) {
					store.removeDVD(recycleBin[i]);
				}
				if (qtyTrashItems > 0) {
					System.out.println("Successfully removed!");
				}
				else {
					System.out.println("Nothing is removed!");
				}
				break;
		}
		pressAnyKeyToContinue(new Thread(Aims::updateStoreMenu));
	}
	public static void storeMenu() {
		for (int i = 0; i < store.getQtyAvailable(); i++) {
			System.out.printf("%d. ", (i + 1));
			System.out.println(store.getItemsInStore()[i]);
		}
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a DVD’s details");
		System.out.println("2. Add a DVD to cart");
		System.out.println("3. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
		
		int Entry = sc.nextInt();
		String title;
		
		switch (Entry) {
			case 0:
				showMenu();
				break;
			case 1: 
				System.out.print("Enter a desired title to search: ");
				sc = new Scanner(System.in);
				title = sc.nextLine();
				cart.searchByTitle(title);
				break;
			case 2:
				System.out.print("Enter your desired title to add into your cart: ");
				sc = new Scanner(System.in);
				title = sc.nextLine();
				int qtyOrderedBackup = cart.getQtyOrdered();
				
				for (int i = 0; i < store.getQtyAvailable(); i++) {
					if (title.compareToIgnoreCase(store.getItemsInStore()[i].getTitle()) == 0) {
						cart.addDigitalVideoDisc(store.getItemsInStore()[i]);
					}
				}
				if (qtyOrderedBackup == cart.getQtyOrdered()) {
					System.out.println("No matched title is found! Nothing added");
				}
				System.out.println("The number of items ordered: " + cart.getQtyOrdered());
				pressAnyKeyToContinue(new Thread(Aims::storeMenu));
				break;
				
				
			case 3:
				cart.print();
				cartMenu();
				break;
		}
	}
	public static void cartMenu() {
		Thread cartMenuRefer = new Thread(Aims::cartMenu);
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter DVDs in cart");
		System.out.println("2. Sort DVDs in cart");
		System.out.println("3. Remove DVD from cart");
		System.out.println("4. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
		
		int Entry = sc.nextInt();
		switch (Entry) {
		case 0:
			showMenu();
			return;
		case 1: 
			System.out.println("One of 2 filter options: ");
			System.out.println("--------------------------------");
			System.out.println("1. Filter by Id");
			System.out.println("2. Filter by title");
			System.out.println("0. Back");
			
			Entry = sc.nextInt();
			switch (Entry) {
				case 1: 
					System.out.println("Enter the id to filter: ");
					int id = sc.nextInt();
					cart.searchById(id);
					pressAnyKeyToContinue(cartMenuRefer);
					break;
				case 2: 
					System.out.println("Enter the title to filter: ");
					sc = new Scanner(System.in);
					String title = sc.nextLine();
					cart.searchByTitle(title);
					pressAnyKeyToContinue(cartMenuRefer);
					break;
				case 0: 
					cartMenu();
					break;
			}
			
			break;
		case 2:
			System.out.println("One of two sorting options: ");
			System.out.println("1. Sort by title");
			System.out.println("2. Sort by cost");
			System.out.println("0. Back");
			System.out.println("Please choose a number: 0-1-2");
			Entry = sc.nextInt();
			switch (Entry) {
				case 0:
					cartMenu();
				case 1:
					cart.printByCostTitleOrder();
					break;
				case 2:
					cart.printByTitleCostOrder();
					break;
			}
			pressAnyKeyToContinue(cartMenuRefer);
			break;
			
		case 3:
			System.out.print("Enter your desired title to remove from your cart: ");
			sc = new Scanner(System.in);
			String title = sc.nextLine();
			DigitalVideoDisc[] recycleBin = new DigitalVideoDisc[Cart.MAX_NUMBERS_ORDERED];
			int qtyTrashItems = 0;
	
			for (int i = 0; i < cart.getQtyOrdered(); i++) {
				if (cart.getItemsOrdered()[i].getTitle().compareToIgnoreCase(title) == 0) {
					recycleBin[qtyTrashItems] = cart.getItemsOrdered()[i];
					qtyTrashItems ++;
				}
			}
			
			for (int i = 0; i < qtyTrashItems; i++) {
				cart.removeDigitalVideoDisc(recycleBin[i]);
			}
			/* for (int i = 0; i < qtyTrashItems; i++) {
				System.out.println(recycleBin[i]);
			}
			
			for (int i = 0; i < cart.getQtyOrdered(); i++) {
				System.out.println(cart.getItemsOrdered()[i]);
				}
			*/
			
			System.out.println("The number of remaining items ordered is: " + cart.getQtyOrdered());
			break;
		case 4:
			System.out.println("Your order has been created!");
			for (int i = 0; i < cart.getQtyOrdered(); i++) {
				cart.getItemsOrdered()[i] = null;
			}
			pressAnyKeyToMain();
			break;
		}
	}
	private static void pressAnyKeyToContinue(Thread method){ 
		System.out.println("Press any key to continue...");
		try {
			System.in.read();
			method.start();
		}
		catch(Exception e) {
		}
	}
	private static void pressAnyKeyToMain(){ 
		System.out.println("Press any key to main menu...");
		try {
			System.in.read();
			showMenu();
		}
		catch(Exception e) {
		}
	}
}
