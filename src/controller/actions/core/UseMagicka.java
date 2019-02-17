package controller.actions.core;

import controller.action_framework.IAction;
import model.IState;
import model.card.Card;
import model.game.Event;
import model.game.EventType;
import model.player.MagickaData;

public class UseMagicka extends IAction {

	private static final EventType TRIGGER = null;
	private static final boolean REPETITIVE = false;

	public UseMagicka(Event source)
	{
		super(source, REPETITIVE, TRIGGER);
	}

	@Override
	public void execute(IState state)
	{
		Card card = (Card) state;
		int magickaCost = card.getMagicka_cost();

		MagickaData player = card.getOwner().getMagicka();
		int currentMagicka = player.getCurrentMagicka();
		currentMagicka -= magickaCost;

		player.setCurrentMagicka(currentMagicka);

	}

	public boolean isValid(IState cardSource)
	{
		Card card = (Card) cardSource;
		MagickaData player = card.getOwner().getMagicka();
		int currentMagicka = player.getCurrentMagicka();

		return currentMagicka > card.getMagicka_cost();
	}

}
