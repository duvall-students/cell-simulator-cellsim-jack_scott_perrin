package controller;



=======
import static org.junit.Assert.assertEquals;

import java.awt.Point;
import java.util.Hashtable;

import org.junit.Test;

import model.*;

public class RPSHandler 
{
	Hashtable<String, String> stateWinsVersus = new Hashtable<>();

	
	public RPSHandler()
	{
		stateWinsVersus.put("R", "S");
		stateWinsVersus.put("P", "R");
		stateWinsVersus.put("S", "P");

	}
	
	public String compareCellToNeighbors(AutomataCell curCell, AutomataCell[] neighborCells)
	{
		Hashtable<String, Integer> numWins = new Hashtable<>();
		numWins.put("R", 0);
		numWins.put("P", 0);
		numWins.put("S", 0);
		
		String curState = curCell.getState();
		
		for(AutomataCell neighbor : neighborCells)
		{
			String neighborState = neighbor.getState();
			if(checkIfCellWins(curState, neighborState))
			{
				numWins.put(neighborState, numWins.get(neighborState) + 1);
			}
		}
		
		for(String state : numWins.keySet())
		{
			int winVal = CellGrid.THRESHOLD;
			int numStateWins = numWins.get(state);
			
			if(numStateWins >= winVal)
			{
				curState = state;
				return curState;
			}
		}
		return curState;
	}
	
	private boolean checkIfCellWins(String primaryCellState, String compareCellState)
	{


		if(stateWinsVersus.get(compareCellState).equals(primaryCellState))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	
	//TEST CASES -- IGNORE
	@Test
	public void testCompareCell()
	{
		
		String startState = "R";
		String[] neighborCells = {"R", "S", "S", "R", "P", "S", "P", "R"};
		
		String finalState = compareCellStringTest(startState, neighborCells);
		assertEquals("R", finalState);
	}
	
	public String compareCellStringTest(String curState, String[] neighborCells)
	{
		Hashtable<String, Integer> numWins = new Hashtable<>();
		numWins.put("R", 0);
		numWins.put("P", 0);
		numWins.put("S", 0);
		
		//String curState = curCell.getState();
		
		for(String neighbor : neighborCells)
		{
			String neighborState = neighbor;
			if(checkIfCellWins(curState, neighborState))
			{
				numWins.put(neighborState, numWins.get(neighborState) + 1);
			}
		}
		
		for(String state : numWins.keySet())
		{
			int winVal = CellGrid.THRESHOLD;
			int numStateWins = numWins.get(state);
			
			if(numStateWins >= winVal)
			{
				curState = state;
				return curState;
			}
		}
		return curState;
	}
}
