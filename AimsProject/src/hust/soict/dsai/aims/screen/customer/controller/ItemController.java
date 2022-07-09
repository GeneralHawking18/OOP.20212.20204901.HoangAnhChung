package hust.soict.dsai.aims.screen.customer.controller;

import javax.naming.LimitExceededException;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.playable.Playable;
import hust.soict.dsai.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;

import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;


public class ItemController {
	private Cart cart;
	private Media media;
	   
	@FXML
	private GridPane gridPane;
	
    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblCost;

    @FXML
    private Label lblTitle;
    
  
    public ItemController(Store store, Cart cart) {
    	this.cart = cart;
    	
    }
    
    public void setData(Media media) {
    	this.media = media;
    	lblTitle.setText(media.getTitle());
    	lblCost.setText(media.getCost() + " $");
    	if (media instanceof Playable) {
    		btnPlay.setVisible(true);
    		
    	} else {
    		btnPlay.setVisible(false);
    		HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60));
    	}
    }

    @FXML
    void btnAddToCartClicked(ActionEvent event) throws LimitExceededException {
    	cart.addMedia(media);
    	//btnAddToCart.setVisible(false);
    	btnAddToCart.setText("Undo add to cart");
    	btnAddToCart.setOnAction(this::btnUndoAddToCartClicked);
    	
    }
    
    @FXML
    void btnUndoAddToCartClicked(ActionEvent event) {
    	cart.removeMedia(media);
    	btnAddToCart.setText("Add to cart");
    	btnAddToCart.setOnAction(evt -> {
			try {
				btnAddToCartClicked(evt);
			} catch (LimitExceededException e) {
				e.printStackTrace();
			}
		});
 
    }

    @FXML
    void btnPlayClicked(ActionEvent event) throws PlayerException {
    	((Playable) media).play();
    }
	public void setBtnAddToCart(Button btnAddToCart) {
		this.btnAddToCart = btnAddToCart;
	}

}

