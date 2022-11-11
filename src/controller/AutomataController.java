package controller;

import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Cell;
import javafx.util.Duration;
import model.CellGrid;
import view.AutomataView;

public class AutomataController 
{
	private final int MILLISECOND_DELAY = 15;
	
	CellGrid cellGrid;
	private int gridWidth;
	private int gridHeight;

	public AutomataController(AutomataView automataView)
	{
		RPSHandler handler = new RPSHandler();
		cellGrid = new CellGrid(handler);
		
		//generate button 
		cellView.generateInitialView();
		
		KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY), e -> mazeController.step(MILLISECOND_DELAY));
		Timeline animation = new Timeline();
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.getKeyFrames().add(frame);
		animation.play();
	}
	
	private void step()
	{
		
		cellGrid.updateBoard();
		
		ArrayList<Cell> changedCells = cellGrid.getChangedCells();
		
		colorCells(changedCells);
		
		
	}
	

	private void colorCells(changedCells)
	{
		for(Cell changedCell : changedCells)
		{
			AutomataView.colorCell(changedCell.getColor, changedCell.getCoordinate)
		}
	}
	
	private void generateCellGrid()
	{
		if(gridWidth > 0 && gridHeight > 0)
		{
			automataView.initializeView(gridWidth, gridHeight);
			cellGrid.initializeGrid(gridWidth, gridHeight);
		}
		
	}
}
