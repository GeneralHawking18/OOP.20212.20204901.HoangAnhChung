package hust.soict.dsai.program.javafx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class PainterController {

	@FXML
    private ToggleGroup ToolsChoice;

    @FXML
    private Pane drawingAreaPane;

    private final EventHandler<MouseEvent> drawingHandler = new EventHandler<MouseEvent>() {
    	@Override
    	public void handle(MouseEvent event) {
    		Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
        	drawingAreaPane.getChildren().add(newCircle);
    	}
    };
    
    private final EventHandler<MouseEvent> erasingHandler = new EventHandler<MouseEvent>() {
    	@Override
    	public void handle(MouseEvent event) {
    		Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.WHITE);
        	drawingAreaPane.getChildren().add(newCircle);
    	}
    };
    
    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
    	drawingAreaPane.getChildren().add(newCircle);
    }
    
    @FXML
    void erasingAreaMouseDragged(MouseEvent event) {
    	Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.WHITE);
    	drawingAreaPane.getChildren().add(newCircle);
    }
    
    @FXML
    void penButtonSelected(ActionEvent event) {
    	drawingAreaPane.setOnMouseDragged(this::drawingAreaMouseDragged);
    	drawingAreaPane.setOnMouseClicked(this::drawingAreaMouseDragged);
    	//drawingAreaPane.setOnMouseDragged(drawingHandler);
    }	
    
    @FXML
    void eraserButtonSelected(ActionEvent event) {
    	drawingAreaPane.setOnMouseDragged(this::erasingAreaMouseDragged);
    	drawingAreaPane.setOnMouseClicked(null);
    	//drawingAreaPane.setOnMouseDragged(MouseEvent -> this.drawingAreaMouseDragged(MouseEvent));
    	//drawingAreaPane.setOnMouseDragged(erasingHandler);
    }
    
 
}
