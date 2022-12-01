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
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;

public class AutomataView extends Application
{
	// SET HEIGHT AND WIDTH PARAMETERS
	public static final int grid_width = 700; 
	public static final int grid_height = 500; 
	
	private static final int extra_horizontal = 100; 	// GUI area allowance when making the scene width
	private static final int extra_vertical = 100; 	// GUI area allowance when making the scene width
	private static final int block_size = 4;
	
	public static int width = (grid_width-extra_horizontal)/4; 
	public static int height = (grid_height-extra_vertical)/4; 
	
	private Scene myScene; 
	
	private Rectangle[][] cellGrid;	// the Rectangle objects that will get updated and drawn.  
	
	// Button Variables
	private Button pauseButton;
	
	// AutomataController Instance Variable 
	AutomataController ac;
	
	//START (Constructor)
	
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
		Group cellGrid = generateGridView(width, height);
		HBox buttons = setupButtons();
		//HBox controls = setupControlButtons();

		VBox root = new VBox();
		root.setAlignment(Pos.TOP_CENTER);
		root.setSpacing(10);
		root.setPadding(new Insets(10, 10, 10, 10));
		root.getChildren().addAll(buttons, cellGrid);
		
		Scene scene = new Scene(root, grid_width, grid_height, Color.ANTIQUEWHITE);
		
		return scene; 
		
		//create initial view with empty grid container
			/*
			 * numeric text fields for grid width/height bound to automataController properties (see comments at bottom)
			 * generate button for automata initialization (bind to Controller.generateNewAutomata();)
			 * generate pause/unpause and step buttons and disable them OR just generate them later
			 */
	}
	
	public Group generateGridView(int num_rows, int num_cols)
	{
		/*
		 * Modify the empty grid container made earlier and create a grid of cells by width and height
		 * Color cells based on starting conditions (see project document "Initialization & Variables)
		 * enable pause/play and step buttons OR generate them here
		 */
		Group drawing = new Group();
		
		cellGrid = new Rectangle[num_cols][num_rows];
		for(int i = 0; i< num_cols; i++){
			for(int j =0; j < num_rows; j++){
				Rectangle rect = new Rectangle(j*block_size, i*block_size, block_size, block_size);
				//rect.setFill(color[mc.getCellState(new Point(i,j))]);
				
				//rect.setFill(Color.AQUA);
				cellGrid[i][j] = rect;
				
				Point fillPoint = new Point(i, j);

				
				if (i % 2 == 0 && j % 2 == 0) {
					colorCell(Color.SKYBLUE, fillPoint);
				}
				else {
					colorCell(Color.WHITE, fillPoint);
				}
				
				drawing.getChildren().add(rect);
			}	
		}
		return drawing;
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
		
		int x = cellCoordinate.x;
		int y = cellCoordinate.y;
		
		cellGrid[x][y].setFill(cellColor);
	}

	/*
	 * Toggle the pause button
	 */
	public void updatePauseButton(boolean paused){
		if(paused){
			pauseButton.setText("Resume");
		}
		else{
			pauseButton.setText("Pause");
		}
	}
	
	// public void setText - SIMPLIFIES UPDATEPAUSEBUTTON method - instead of 2 if statements
	
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
