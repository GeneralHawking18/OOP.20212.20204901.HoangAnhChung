package hust.soict.dsai.aims.screen.customer.controller;

import java.io.IOException;
import java.util.function.Predicate;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.playable.Playable;
import hust.soict.dsai.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CartController {
	private Cart cart;
	private Store store;
	
	private ViewStoreController viewStoreController;
	
	@FXML
	private FilteredList<Media> filterCart;
	
    @FXML
    private Button btnPlay;
    @FXML
    private Button btnRemove;
    @FXML
    private Button btnPlaceOrder;
    
    @FXML
    private TableView<Media> tblMedia;
    @FXML
    private TableColumn<Media, Integer> colMediaId;
    @FXML
    private TableColumn<Media, String> colMediaTitle;
    @FXML
    private TableColumn<Media, String> colMediaCategory;
    @FXML
    private TableColumn<Media, Float> colMediaCost;


    @FXML
    private Label costLabel;
    
    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TextField tfFilter;
    
    @FXML
    private RadioButton radioBtnFilterId;
    
    @FXML
    private RadioButton radioBtnFilterTitle;
    
    public CartController(Store store, Cart cart, ViewStoreController viewStoreController) {
    	this.store = store;
    	this.cart = cart;
    	this.viewStoreController = viewStoreController;
    }
    
   
    @FXML
    public void initialize() {
    	updateTotalPrice();
    	colMediaId.setCellValueFactory(new PropertyValueFactory<Media, Integer>("id"));
    	colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
    	colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
    	colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
    	
    	if (cart.getItemsOrdered() != null) {
    		tblMedia.setItems(cart.getItemsOrdered());
    		//tblMedia.getSortOrder().add(colMediaId);
    	}
    	btnPlay.setVisible(false);
    	btnRemove.setVisible(false);
    	
    	
    	tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
    		@Override
    		public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
    			updateButtonBar(newValue);
    		}
    	});
    	
    	tfFilter.textProperty().addListener(new ChangeListener<String>() {
    		@Override
    		public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
    			showFilterMedia(newValue);
    		}
    	});
    }
    
    void showFilterMedia(String string) {
    	filterCart = new FilteredList<Media>(cart.getItemsOrdered());
    	filterCart.setPredicate(new Predicate<Media>() {
    		@Override
			public boolean test(Media media) {
				//return media.getTitle().contains(string);
    			return media.isMatch(string);
    		}
		});
    	tblMedia.setItems(filterCart);
    }
    
    
    void updateButtonBar(Media media) {
    	if (media == null) {
    		btnPlay.setVisible(false);
    		btnRemove.setVisible(false);
    	} else {
    		btnRemove.setVisible(true);
    		if (media instanceof Playable) btnPlay.setVisible(true);
    		else btnPlay.setVisible(false);
    	}
    }

    @FXML
    void btnPlayPressed(ActionEvent event) throws PlayerException {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	((Playable) media).play();

    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	cart.removeMedia(media);
    	updateTotalPrice();
    	ViewStoreController.itemControllers[media.getId() - 1].btnUndoAddToCartClicked(event);
    }
    
    void updateTotalPrice() {
    	String value = String.valueOf(cart.totalCost());
    	costLabel.setText(value + " $");
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
    	// Get the current window
    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    		
    	// Get the scene of viewStore which was saved before.
    	stage.setScene(viewStoreController.getSavingScene());
    	stage.setTitle("Store");
    }
    
   
	@FXML
    void placeOrderPressed(ActionEvent event) {
    	for (Media media: cart.getItemsOrdered()) {
    		store.removeMedia(media);
    	}
    	cart.getItemsOrdered().clear();
    	updateTotalPrice();
    	
    	try {
    		final String CART_FXML_FILE_PATH = "/hust/soict/dsai/aims/screen/customer/view/Store.fxml";
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
    		
    		fxmlLoader.setController(this.viewStoreController);
    		
    		Parent root = fxmlLoader.load(); 
    		viewStoreController.setSavingScene(new Scene(root));
    	}
    	catch (IOException e){
    		e.printStackTrace();
		}
    }

    
}
