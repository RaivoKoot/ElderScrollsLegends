package controller.actions.core;

import controller.action_framework.IAction;
import model.IState;
import model.card.Card;
import model.cardlists.CardList;
import model.cardlists.DeckEmptyException;
import model.cardlists.DeckList;
import model.cardlists.HandFullException;
import model.game.CurrentEventManager;
import model.game.Event;
import model.game.EventType;
import model.player.Player;

public class DrawCard extends IAction {

	private static final EventType TRIGGER = null;
	private static final boolean REPETITIVE = false;

	public DrawCard(Event source)
	{
		super(source, REPETITIVE, TRIGGER);
	}

	@Override
	public void execute(IState state) throws DeckEmptyException, HandFullException
	{
		Player player = (Player) state;

		// must have at least one card left in deck
		DeckList deck = player.getDeck();
		if (deck.size() == 0)
			throw new DeckEmptyException(player);

		// take the card from the deck
		Card drawnCard = deck.remove(0);

		// hand must not be full
		CardList hand = player.getHand();
		if (!hand.hasSpace())
			throw new HandFullException(player);

		hand.add(drawnCard);

		Event drawCardEvent = new Event(EventType.DRAW_CARD, player, drawnCard);
		CurrentEventManager.setCurrentEvent(drawCardEvent);
	}

}
