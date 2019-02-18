package controller.actions.core;

import controller.action_framework.IAction;
import model.IState;
import model.game.Event;
import model.game.EventType;
import model.player.MagickaData;

public class RefreshCurrentMagicka extends IAction {
	private static final EventType TRIGGER = null;
	private static final boolean REPETITIVE = false;

	public RefreshCurrentMagicka(Event source)
	{
		super(source, REPETITIVE, TRIGGER);
	}

	@Override
	public void execute(IState state) throws Exception
	{
		MagickaData magicka = (MagickaData) state;
		int maxMagicka = magicka.getMaxMagicka();
		int currentMagicka = magicka.getCurrentMagicka();

		int toFillUp = maxMagicka - currentMagicka;

		GainCurrentMagicka refreshMagicka = new GainCurrentMagicka(super.getSource(), toFillUp);
		magicka.apply(refreshMagicka);

	}

}
