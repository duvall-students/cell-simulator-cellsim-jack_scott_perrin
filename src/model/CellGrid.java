package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;

import controller.RPSHandler;
import javafx.scene.control.Cell;

public class CellGrid {
	public static final int THRESHOLD = 3;
	
	private RPSHandler rpsRules;
	
	private AutomataCell[][] myGrid;
	
	private ArrayList<AutomataCell> changed = new ArrayList<AutomataCell>();

	public CellGrid(RPSHandler handler) {
		// No one is telling me how big the grid is.  I guess I have to make it up?
		rpsRules = handler;
	}
	
	/**
	 * Generate initial grid with default arrangement of cells
	 * @param width
	 * @param height
	 */
	
	// Does width and height count the edge cells?  I'm going with NO.
	public void generateGrid(int width, int height) {
		generatePyramidGrid(width, height);
	}
	
	// Initialize the grid in a pyramid fashion.
	private void generatePyramidGrid(int width, int height) {
		myGrid = new AutomataCell[height][width];
		// For all rows and left half of columns, put rock
		fillPart(0, height, 0, width/2, "R");
		// For all rows and right half of columns put scissors
		fillPart(0, height, width/2, width, "S");
		// I want the pyramid growth to stop about a quarter from the bottom.
		int quarterHeight = height/4;
		
		// I need to get from a row length of 4 to a row length of width in quarterHeight steps.
		// This computes how much to add to each row.
		int widthGrowth =  (width-4)/quarterHeight;
		final int START_WIDTH = 4;
		int rowWidth = START_WIDTH;
		int row = height/2;
		while(rowWidth < width) {
			for (int col = width/2 - rowWidth/2; col < width/2 + rowWidth/2; col++) {
				myGrid[row][col] = new AutomataCell("P", new Point(row, col));
			}
			rowWidth = rowWidth + widthGrowth;
			row++;
		}
		// Fill in the bottom rest of grid with paper
		fillPart(row, height, 0, width, "P");
	}
	
	
	private void fillPart(int startRow, int endRow, int startCol, int endCol, String type) {
		for (int r = startRow; r <endRow; r++) {
			for (int c = startCol; c < endCol; c++) {
				myGrid[r][c] = new AutomataCell(type, new Point(r,c));
			}
		}
	}
	
	// I'm printing to console for testing
	private void printGrid() {
		for(int i = 0; i < myGrid.length; i++) {
			for(int j = 0; j < myGrid[0].length; j++) {
				System.out.print(myGrid[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	private void testGridInitialization(int width, int height) {
		generateGrid(width, height);
		printGrid();
	}
	
	public static void main(String[] args) {
		CellGrid grid = new CellGrid(null);
		grid.testGridInitialization(20,20);
	}
	
	/**
	 * return all cells changed since last update
	 * @return
	 */
	public Collection<AutomataCell> getChangedCells() {
		ArrayList<AutomataCell> toReturn = new ArrayList<AutomataCell>();
		for(AutomataCell c: changed) {
			toReturn.add(c);
		}
		changed = new ArrayList<AutomataCell>();
		return toReturn;
	}
	
	private boolean inBounds(int r, int c) {
		return  (r >= 0 && r < myGrid.length && c >= 0 && c < myGrid[0].length);
	}
	
	// If there are not 9 neighbors, do you want me to include nulls in the list so
	// the array is always of size 9?
	private AutomataCell[] getNeighbors(int row, int col) {
		ArrayList<AutomataCell> neighbors = new ArrayList<AutomataCell>();
		for(int r = row-1; r <= row+1; r++) {
			for(int c = col - 1; c <= col + 1; c++) {
				if (inBounds(r, c)) {
					neighbors.add(myGrid[r][c]);
				}
			}
		}
		return (AutomataCell[]) neighbors.toArray();
	}
	
	
	/**
	 * Perform one iteration of cell logic on the board
	 */
	public void updateBoard() {
		//check for changes in board
		/*
		 * for each cell in the grid
		 * that cell = handler.compareCellToNeighbors(cell, neighborCells[])
		 * the handler applies rules and returns the state of the given cell
		 * if the cell is changed store it for later
		 * 
		 */
		for(int r = 0; r < myGrid.length; r++) {
			for(int c = 0; c < myGrid[r].length; c++) {
				AutomataCell[] neighbors = getNeighbors(r, c);
				String state = rpsRules.compareCellToNeighbors(myGrid[r][c], neighbors);
				if (!state.equals(myGrid[r][c].getState())){
					changed.add(myGrid[r][c]);
					myGrid[r][c].setState(state);
				}
			}
		}
		
		//update board with changes
		/*
		 * for each changed cell
		 * set cellgrid at cell.getCoordinates = changed cell
		 */
	}
}
