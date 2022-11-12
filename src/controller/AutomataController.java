package controller;

import java.util.ArrayList;
import java.util.Collection;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Cell;
import javafx.util.Duration;
import model.*;
import view.AutomataView;

public class AutomataController 
{
	private final int MILLISECOND_DELAY = 15;
	public IntegerProperty gridWidth = new SimpleIntegerProperty();
	public IntegerProperty gridHeight = new SimpleIntegerProperty();
	private boolean paused = true;
	
	CellGrid cellGrid;
	AutomataView automataView;
	boolean automataInitialized = false;

	public AutomataController(AutomataView automataView)
	{
		this.automataView = automataView;
	}
	
	/**
	 * Generate dependencies for automata controller functionality
	 */
	public void initialize()
	{		
		//create handler that will determine rules for the automata
		RPSHandler handler = new RPSHandler();
		cellGrid = new CellGrid(handler);
	
		automataView.generateInitialView();
		
		//initialize the automata step method to update
		KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY), e -> step(MILLISECOND_DELAY));
		Timeline animation = new Timeline();
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.getKeyFrames().add(frame);
		animation.play();	
	}
	
	private void step(double timeElapsed)
	{
		if(!paused)
		{
			doOneStep(timeElapsed);
		}
	}
	
	private void colorCells(Collection<AutomataCell> changedCells)
	{

		for(AutomataCell changedCell : changedCells)
		{
			automataView.colorCell(changedCell.getColor(), changedCell.getCoordinates());
		}
	}
	
	/**
	 * Create new automata grid/view
	 */
	public void generateNewAutomata()
	{
		int width = gridWidth.getValue();
		int height = gridWidth.getValue();
		
		if(width > 0 && height > 0)
		{
			automataView.generateGridView(width, height);
			cellGrid.generateGrid(width, height);
		}
	}
	
	/**
	 * perform a single iteration of the automata
	 * @param timeElapsed
	 */
	public void doOneStep(double timeElapsed)
	{
		cellGrid.updateBoard();
		
		colorCells(cellGrid.getChangedCells());
	}


	/**
	 * handler for pause/play button
	 */
	public void handlePause()
	{
		paused = !paused;
		automataView.updatePauseButton(paused);
	}
	
	
}
