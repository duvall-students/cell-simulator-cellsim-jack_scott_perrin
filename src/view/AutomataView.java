package view;

import java.awt.Point;

import controller.AutomataController;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;

public class AutomataView extends Application
{
	// SET HEIGHT AND WIDTH PARAMETERS
	public static final int grid_width = 600; 
	public static final int grid_height = 400; 
	
	
	
	private final int EXTRA_VERTICAL = 100; 	// GUI area allowance when making the scene width
	private final int EXTRA_HORIZONTAL = 150; 	// GUI area allowance when making the scene width
	
	private Scene myScene; 
	private Button pauseButton;
	
	AutomataController ac;
	
	@Override
	public void start(Stage primaryStage)
	{
		ac = new AutomataController(this);
		
		myScene = generateInitialView();
		
		primaryStage.setScene(myScene);
		primaryStage.setTitle("");
		primaryStage.show();
		
		ac.initialize();
		generateInitialView();
	}
	

	private Scene generateInitialView()
	{
		//Group mazeDrawing = setupMaze();
		HBox buttons = setupButtons();
		//HBox controls = setupControlButtons();

		VBox root = new VBox();
		root.setAlignment(Pos.TOP_CENTER);
		root.setSpacing(10);
		root.setPadding(new Insets(10, 10, 10, 10));
		root.getChildren().addAll(buttons);
		
		Scene scene = new Scene(root, grid_width, grid_height, Color.ANTIQUEWHITE);
		
		return scene; 
		
		//create initial view with empty grid container
			/*
			 * numeric text fields for grid width/height bound to automataController properties (see comments at bottom)
			 * generate button for automata initialization (bind to Controller.generateNewAutomata();)
			 * generate pause/unpause and step buttons and disable them OR just generate them later
			 */
	}
	
	public void generateGridView(int width, int height)
	{
		
		/*
		 * Modify the empty grid container made earlier and create a grid of cells by width and height
		 * Color cells based on starting conditions (see project document "Initialization & Variables)
		 * enable pause/play and step buttons OR generate them here
		 */
	}
	
	// CREATE Width, Height, and initialize buttons 
	public HBox setupButtons() {
		HBox controls = new HBox();
		controls.setAlignment(Pos.BASELINE_CENTER);
		controls.setSpacing(10);
		
		// CREATE PAUSE BUTTON (placeholder)
		pauseButton = new Button("Pause");
		pauseButton.setOnAction(value ->  {
			ac.handlePause();
		});
		controls.getChildren().add(pauseButton);
		
		return controls; 
	}
	
	public void colorCell(Color cellColor, Point cellCoordinate)
	{
		//set cell at point in grid cellCoordinate to cellColor
	}

	public void updatePauseButton(boolean paused) 
	{
		// change pause/play button text based on paused state
		
	}
	
	public static void main(String args[]){ 	
		  launch(args);
	}
}





/*
 * https://stackoverflow.com/questions/53213928/bind-textfield-in-javafx
 * 
 * NumericTextField gridWidth = new NumericTextField();
 * StringConverter<? extends Number> converter = new IntegerStringConverter();
 * Bindings.bindBidirectional(gridWidth.textProperty(), automataController.gridWidth, (StringConverter<Number>) converter);
 */
