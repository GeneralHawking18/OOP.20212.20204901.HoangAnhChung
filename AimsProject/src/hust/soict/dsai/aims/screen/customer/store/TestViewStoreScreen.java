package hust.soict.dsai.aims.screen.customer.store;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.disc.CompactDisc;
import hust.soict.dsai.aims.media.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.screen.customer.controller.ViewStoreController;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application {
	private static Store store = new Store();
	private static Cart cart = new Cart();
	//private static Cart cart;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		final String STORE_FXML_FILE_PATH = "/hust/soict/dsai/aims/screen/customer/view/Store.fxml";
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
		ViewStoreController viewStoreController = new ViewStoreController(store, cart);
		fxmlLoader.setController(viewStoreController);
		Parent root = fxmlLoader.load();
		
		primaryStage.setTitle("Store");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		//store = new Store();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation",
				"Roger Allers",
				87,
				19.95f);
		
		store.addMedia(dvd1);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", 
				"Science Fiction",
				"George Lucas",
				87,
				24.95f); 
		store.addMedia(dvd2);

		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", 
				"Animation",
				18.99f); 
		store.addMedia(dvd3);
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("AAAA", "aaaa", "aaaa", 1, 5.6f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("BBBB", "aaaa", "aaaa", 2, 5.3f);
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("CCCC", "aaaa", "aaaa", 3, 5f);
		DigitalVideoDisc dvd7 = new DigitalVideoDisc("DDDD", "aaaa", "aaaa", 4, 7.1f);
		DigitalVideoDisc dvd8 = new DigitalVideoDisc("EEEE", "aaaa", "aaaa", 5, 3.3f);
		store.addMedia(dvd4); 
		store.addMedia(dvd5); 
		store.addMedia(dvd6); 
		store.addMedia(dvd7); 
		store.addMedia(dvd8); 
		
		DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", 
				"Animation", 
				"Roger Allers", 
				19.95f);


		Book book = new Book("Star Wars", 
				"Science Fiction",
				87);

		CompactDisc cd = new CompactDisc("Aladin", 
				"Animation");
		
		
		store.addMedia(dvd);
		store.addMedia(book);
		store.addMedia(cd);
	
		launch(args);
	}
}
