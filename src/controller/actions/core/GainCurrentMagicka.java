package controller.actions.core;

import controller.action_framework.IAction;
import model.IState;
import model.game.CurrentEventManager;
import model.game.Event;
import model.game.EventType;
import model.player.MagickaData;

public class GainCurrentMagicka extends IAction {
	private static final EventType TRIGGER = null;
	private static final boolean REPETITIVE = false;

	private int amount;

	public GainCurrentMagicka(Event source, int amount)
	{
		super(source, REPETITIVE, TRIGGER);
		this.amount = amount;
	}

	@Override
	public void execute(IState state) throws Exception
	{
		MagickaData magicka = (MagickaData) state;

		magicka.setCurrentMagicka(magicka.getCurrentMagicka() + amount);

		Event performedEvent = new Event(EventType.GAIN_CURRENT_MAGICKA, super.getSource(), magicka);
		CurrentEventManager.setCurrentEvent(performedEvent);

	}

}
