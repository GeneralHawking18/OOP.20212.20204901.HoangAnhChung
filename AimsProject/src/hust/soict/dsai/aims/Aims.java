package hust.soict.dsai.aims;
import hust.soict.dsai.MemoryDaemon.MemoryDaemon;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.playable.Playable;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.naming.LimitExceededException;
import javax.swing.JOptionPane;

public class Aims {
	private static Store store = new Store();
	private static Cart cart = new Cart();
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		try {
			Cart anOrder = new Cart();
			
			DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", 
														"Animation", 
														"Roger Allers", 
														87, 
														19.95f);
			anOrder.addMedia(dvd1);
			
			Book dvd2 = new Book("Star Wars", 
														"Science Fiction",
														87);
			anOrder.addMedia(dvd2);
			DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", 
														"Animation", 
														18.99f);
			anOrder.addMedia(dvd3);
			anOrder.addMedia(dvd1);
			DigitalVideoDisc[] temp = {dvd1, dvd1};
			anOrder.addMedia(temp);
			anOrder.addMedia(dvd1, dvd2);
			
			//anOrder.removeDigitalVideoDisc(dvd1);
			//anOrder.removeDigitalVideoDisc(dvd2);
			//anOrder.removeDigitalVideoDisc(dvd3);
			
			cart = anOrder;
			//cart.print();
			
			System.out.printf("Total cost is: \n%f\n", anOrder.totalCost());
			store.addMedia(dvd1);
			store.addMedia(dvd2);
			store.addMedia(dvd3);
			
			showMenu();
			
		} catch (LimitExceededException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Exceeded items" , JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error!" , JOptionPane.ERROR_MESSAGE);
		}
		;
		MemoryDaemon memDae = new MemoryDaemon();
		Thread thread = new Thread(memDae);
		thread.setDaemon(true);
		thread.start();
		
		
	}
	
	public static void showErrorPopup(Exception e, String title) {
		e.printStackTrace();
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Title");
		alert.setHeaderText(e.toString());
		alert.setHeaderText(e.getMessage());
	}
	
	public static void showMenu() throws LimitExceededException, IOException {
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
		
	public static void updateStoreMenu() throws IOException, LimitExceededException {
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
				
				
				store.addMedia(new DigitalVideoDisc(title, category, director, length, cost));
				System.out.println("A new item has been successfully added into Store!");
				break;
				
			case 2:
				System.out.print("Enter desired title to remove from the store: ");
				sc = new Scanner(System.in);
				title = sc.nextLine();

				ArrayList<Media> recycleBin = new ArrayList<Media>();
				int qtyTrashItems = 0;
				
				for (Media media: store.getItemsInStore()) {
					if (media.getTitle().compareToIgnoreCase(title) == 0) {
						recycleBin.add(media);
						qtyTrashItems ++;
					}
				}
				
				for (Media media: recycleBin) {
					store.removeMedia(media);
				}
				if (qtyTrashItems > 0) {
					System.out.println("Successfully removed!");
				}
				else {
					System.out.println("Nothing is removed!");
				}
				break;
		}
		pressAnyKeyToContinue();
		updateStoreMenu();
		//pressAnyKeyToContinue(new Thread(Aims::updateStoreMenu));
	}
	public static void storeMenu() throws LimitExceededException, IOException{
		//Thread methodReference = new Thread(Aims::storeMenu);
		for (int i = 0; i < store.getItemsInStore().size(); i++) {
			System.out.printf("%d. ", (i + 1));
			System.out.println(store.getItemsInStore().get(i));
		}
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a DVD's details");
		System.out.println("2. Add a DVD to cart");
		System.out.println("3. See current cart");
		System.out.println("4. Play a DVD or CD item");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
		
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
				pressAnyKeyToContinue();
				cartMenu();
				break;
			case 2:
				System.out.print("Enter your desired title to add into your cart: ");
				sc = new Scanner(System.in);
				title = sc.nextLine();
				int qtyOrderedBackup = cart.getItemsOrdered().size();
				
				try {
					for (int i = 0; i < store.getItemsInStore().size(); i++) {
						if (title.compareToIgnoreCase(store.getItemsInStore().get(i).getTitle()) == 0) {
							cart.addMedia(store.getItemsInStore().get(i));
						}
					}
				} catch(LimitExceededException e){
					JOptionPane.showMessageDialog(null, e.getMessage(), "Exceeded items" , JOptionPane.ERROR_MESSAGE);
					
				}
				
				if (qtyOrderedBackup == cart.getItemsOrdered().size()) {
					System.out.println("No matched title is found! Nothing added");
				}
				System.out.println("The number of items ordered: " + cart.getItemsOrdered().size());
				//pressAnyKeyToContinue(methodReference);
				pressAnyKeyToContinue();
				storeMenu();
				break;
				
				
			case 3:
				cart.print();
				cartMenu();
				break;
				
			case 4:
				System.out.println("Enter the index of item you want to play: ");
				sc = new Scanner(System.in);
				Entry = sc.nextInt();
				Media ChosenItem = store.getItemsInStore().get(Entry - 1);
				
				if (ChosenItem instanceof Playable) {
					try { 
						((Playable)ChosenItem).play();
					} catch(PlayerException e) {
						String typeMedia;
						if (ChosenItem instanceof DigitalVideoDisc) {
							typeMedia = "DVD";
						} else {
							typeMedia = "CD";
						}
						JOptionPane.showMessageDialog(null, e.getMessage(), "Illegal " + typeMedia + " length" , JOptionPane.ERROR_MESSAGE);
						
					}
				}
				//	throw new PlayerException(typeMedia);}
				//pressAnyKeyToContinue(methodReference);
				pressAnyKeyToContinue();
				storeMenu();
				break;
		}
	}
	
	public static void cartMenu() throws IOException, LimitExceededException {
		//Thread cartMenuRefer = new Thread(Aims::cartMenu);
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
			System.out.println("Please choose a number: 0-1-2");
			
			Entry = sc.nextInt();
			switch (Entry) {
				case 1: 
					System.out.println("Enter the id to filter: ");
					int id = sc.nextInt();
					System.out.println(cart.searchById(id));
					//pressAnyKeyToContinue(cartMenuRefer);
					pressAnyKeyToContinue();
					cartMenu();
					break;
				case 2: 
					System.out.println("Enter the title to filter: ");
					sc = new Scanner(System.in);
					String title = sc.nextLine();
					cart.searchByTitle(title);
					
					System.out.println("Press any key to continue...");
					System.in.read();
					cartMenu();
					//pressAnyKeyToContinue(cartMenuRefer);
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
			pressAnyKeyToContinue();
			cartMenu();
			//pressAnyKeyToContinue(cartMenuRefer);
			break;
			
		case 3:
			System.out.print("Enter your desired title to remove from your cart: ");
			sc = new Scanner(System.in);
			String title = sc.nextLine();
			
			ArrayList<Media> recycleBin = new ArrayList<Media>();
			
			for (Media media: cart.getItemsOrdered()) {
				if (media.getTitle().compareToIgnoreCase(title) == 0) {
					recycleBin.add(media);
				}
			}
		
			for (Media media: recycleBin) {
				cart.removeMedia(media);
				
			}
			System.out.println(recycleBin);
			if (recycleBin.size() > 0) {
				System.out.println("Successfully removed!");
			}
			else {
				System.out.println("Nothing is removed!");
			}
			
			System.out.println("The number of remaining items ordered is: " + cart.getItemsOrdered().size());
			//pressAnyKeyToContinue(cartMenuRefer);
			pressAnyKeyToContinue();
			cartMenu();
			
			break;
		case 4:
			System.out.println("Your order has been created!");
			Media luckyItem = cart.getALuckyItem();
			System.out.println("Your lucky item is: ");
			System.out.println(luckyItem);
			cart.removeMedia(luckyItem);
			System.out.println("The price you need to pay is: " + cart.totalCost());
			cart.getItemsOrdered().clear();
			pressAnyKeyToMain();
			break;
		}
	}
	private static void pressAnyKeyToContinue() throws IOException { 
		System.out.println("Press any key to continue...");
		System.in.read();
		
	}
	private static void pressAnyKeyToMain() throws IOException, LimitExceededException { 
		System.out.println("Press any key to main menu...");
		System.in.read();
		showMenu();
	}
	

}
