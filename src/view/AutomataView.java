package view;

import java.awt.Point;

import controller.AutomataController;
import javafx.application.Application;
import javafx.beans.binding.Bindings;

import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;

public class AutomataView extends Application
{
	AutomataController automataController;
	@Override
	public void start(Stage primaryStage)
	{
			automataController = new AutomataController(this);
			
			primaryStage.setTitle("");

			primaryStage.show();
			
			automataController.initialize();
	}
	

	public void generateInitialView()
	{
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
