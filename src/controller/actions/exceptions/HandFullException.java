package controller.actions.exceptions;

import model.player.Player;

public class HandFullException extends Exception {
	private Player player;

	public HandFullException(Player player)
	{
		this.player = player;
	}

	public Player getPlayer()
	{
		return player;
	}


}
