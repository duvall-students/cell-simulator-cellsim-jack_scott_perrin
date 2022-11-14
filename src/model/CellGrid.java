package model;

import java.util.ArrayList;
import java.util.Collection;

import controller.RPSHandler;
import javafx.scene.control.Cell;

public class CellGrid 
{
	private static final int THRESHOLD = 3;

	public CellGrid(RPSHandler handler) 
	{
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Generate initial grid with default arrangement of cells
	 * @param width
	 * @param height
	 */
	public void generateGrid(int width, int height) 
	{
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * return all cells changed since last update
	 * @return
	 */
	public Collection<AutomataCell> getChangedCells() 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Perform one iteration of cell logic on the board
	 */
	public void updateBoard() 
	{
		//check for changes in board
		/*
		 * for each cell in the grid
		 * that cell = handler.compareCellToNeighbors(cell, neighborCells[])
		 * the handler applies rules and returns the state of the given cell
		 * if the cell is changed store it for later
		 * 
		 */
		
		//update board with changes
		/*
		 * for each changed cell
		 * set cellgrid at cell.getCoordinates = changed cell
		 */
	}
}
