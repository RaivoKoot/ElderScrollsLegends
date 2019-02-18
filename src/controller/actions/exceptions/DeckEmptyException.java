package controller.actions.exceptions;

import model.player.Player;

public class DeckEmptyException extends Exception{
	
	private Player player;

	public DeckEmptyException(Player player)
	{
		this.player = player;
	}

	public Player getPlayer()
	{
		return player;
	}

}
