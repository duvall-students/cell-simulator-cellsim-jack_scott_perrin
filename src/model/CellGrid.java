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

	public void generateGrid(int width, int height) 
	{
		// TODO Auto-generated method stub
		
	}

	public Collection<AutomataCell> getChangedCells() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	public void updateBoard() 
	{
		//update board using handler
		/*
		 * for each cell in the grid
		 * that cell = handler.compareCellToNeighbors(cell, neighborCells[])
		 * the handler applies rules and returns the state of the given cell
		 */
		
	}
}
