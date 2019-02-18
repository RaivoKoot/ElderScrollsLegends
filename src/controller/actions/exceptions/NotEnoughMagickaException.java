package controller.actions.exceptions;

import model.card.Card;
import model.player.Player;

public class NotEnoughMagickaException extends Exception{
	
	private Player player;
	private Card card;

	public NotEnoughMagickaException(Player player, Card card) {
		this.player = player;
		this.card = card;
	}
	
	@Override
	public String getMessage() {
		int playersMagicka = player.getMagicka().getCurrentMagicka();
		int cardCost = card.getMagicka_cost();
		
		return "Trying to play card with magicka cost " + cardCost + " but player only has " + playersMagicka + " magicka";
	}
}
