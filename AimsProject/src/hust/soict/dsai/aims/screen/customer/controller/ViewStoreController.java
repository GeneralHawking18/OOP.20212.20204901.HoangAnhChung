package hust.soict.dsai.aims.screen.customer.controller;

import java.io.IOException;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;


public class ViewStoreController {
	private Store store;
	private Cart cart;
	
	protected static ItemController[] itemControllers = new ItemController[Store.MAX_SIZE];
	
	private Scene savingScene;
	
    @FXML
    private GridPane gridPane;
    
	public ViewStoreController(Store store, Cart cart) {
		this.store = store;
		this.cart = cart;
		for (int i = 0; i < store.getItemsInStore().size(); i++) {
			itemControllers[i] = new ItemController(store, cart);
		}
		
	}
	
	public void setSavingScene(Scene scene) {
		this.savingScene = scene;
	}
	
	public Scene getSavingScene() {
		return this.savingScene;
	}
	
	public void initialize() {
		final String ITEM_FXML_FILE_PATH = "/hust/soict/dsai/aims/screen/customer/view/Item.fxml";
		int column = 0;
		int row = 1;
		
		for (int i = 0; i < store.getItemsInStore().size(); i ++) {
			try {
				FXMLLoader fxmlLoader = new FXMLLoader();
				fxmlLoader.setLocation(getClass().getResource(ITEM_FXML_FILE_PATH));;
				int index = store.getItemsInStore().get(i).getId() - 1;
				fxmlLoader.setController(itemControllers[index]);
			
				AnchorPane anchorPane = new AnchorPane();
				anchorPane = fxmlLoader.load();
				itemControllers[index].setData(store.getItemsInStore().get(i));
				
				if (column == 3) {
					column = 0;
					row ++;
				}
				
				column ++;
				gridPane.add(anchorPane, column, row);
				GridPane.setMargin(anchorPane, new Insets(20, 10, 10, 10));
				
			} catch (IOException e){
				e.printStackTrace();
			};
		}
		
	}

    @FXML
    void btnViewCartPressed(ActionEvent event) {
    	try {
    		final String CART_FXML_FILE_PATH = "/hust/soict/dsai/aims/screen/customer/view/Cart.fxml";
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
    		CartController cartController = new CartController(store, cart, this);
    		
    		fxmlLoader.setController(cartController);
    		
    		Parent parent = fxmlLoader.load();
    		
    		this.setSavingScene(((Node) event.getSource()).getScene());
    		
    		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    		
    		stage.setScene(new Scene(parent));
    	
    		stage.setTitle("Cart");
    		stage.show();
    		
    	} catch (IOException e){
    		e.printStackTrace();
    	}
    }
    
    

}

