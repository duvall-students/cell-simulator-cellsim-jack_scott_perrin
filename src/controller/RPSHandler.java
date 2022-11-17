package controller;


import java.util.Hashtable;

import model.AutomataCell;

public class RPSHandler 
{
	Hashtable<String, String> stateWinsVersus = new Hashtable<>();
	Hashtable<String, String> stateLosesVersus = new Hashtable<>();
	
	public RPSHandler()
	{
		stateWinsVersus.put("R", "S");
		stateWinsVersus.put("P", "R");
		stateWinsVersus.put("S", "P");
		
		stateLosesVersus.put("R", "P");
		stateLosesVersus.put("P", "S");
		stateLosesVersus.put("S", "R");
	}
	
	public String compareCellToNeighbors(AutomataCell curCell, AutomataCell[] neighborCells)
	{
		String curState = curCell.getState();
		return null;
	}
	
	private boolean checkIfCellWins(String primaryCellState, String compareCellState)
	{

		if(stateWinsVersus.get(primaryCellState).equals(compareCellState))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
