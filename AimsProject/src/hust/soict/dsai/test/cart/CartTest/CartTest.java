package hust.soict.dsai.test.cart.CartTest;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.disc.CompactDisc;
import hust.soict.dsai.aims.media.disc.DigitalVideoDisc;


public class CartTest {
	public static void main(String [] args) {
		Cart cart = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
													"Animation",
													"Roger Allers",
													87,
													19.95f);
		cart.addMedia(dvd1);
		
		CompactDisc cd1 = new CompactDisc("Star Wars", 
													"Science Fiction",
													"George Lucas",
													87,
													24.95f); 
		cart.addMedia(cd1);
		
		Book book = new Book("Aladin", 
							"Animation",
							18.99f); 
		
		cart.addMedia(book);
		book.addAuthor("123");
		book.addAuthor("1234");
		book.removeAuthor("12");
		cart.printByCostTitleOrder();
	}
}
