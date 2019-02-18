package controller.actions.core;

import controller.action_framework.IAction;
import model.IState;
import model.game.CurrentEventManager;
import model.game.Event;
import model.game.EventType;
import model.player.MagickaData;
import model.player.Player;

public class GainMaxMagicka extends IAction {

	private static final EventType TRIGGER = null;
	private static final boolean REPETITIVE = false;

	private int amount;

	public GainMaxMagicka(Event source, int amount)
	{
		super(source, REPETITIVE, TRIGGER);
		this.amount = amount;
	}

	@Override
	public void execute(IState state) throws Exception
	{
		Player target = (Player) state;
		MagickaData magicka = target.getMagicka();

		int newMax = magicka.getMaxMagicka();
		newMax += amount;
		System.out.println(newMax);

		magicka.setMaxMagicka(newMax);

		Event performedEvent = new Event(EventType.GAIN_MAX_MAGICKA, super.getSource(), target);
		CurrentEventManager.setCurrentEvent(performedEvent);

	}

}
