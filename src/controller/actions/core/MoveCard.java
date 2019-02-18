package controller.actions.core;

import controller.action_framework.IAction;
import controller.actions.exceptions.ListFullException;
import model.IState;
import model.card.Card;
import model.cardlists.CardList;
import model.game.Event;
import model.game.EventType;

public class MoveCard extends IAction{
	
	private CardList sourceList;
	private CardList targetList;

	
	public MoveCard(Event source, boolean repetitive, EventType trigger, CardList sourceList, CardList targetList)
	{
		super(source, repetitive, trigger);
		
		this.sourceList = sourceList;
		this.targetList = targetList;
	}

	@Override
	public void execute(IState state) throws ListFullException
	{
		Card card = (Card)state;
		
		if (!targetList.hasSpace())
			throw new ListFullException(targetList);
		
		sourceList.remove(card);
		targetList.add((Card)state);
	}
	
	public boolean isValid(IState state) {
		return targetList.hasSpace();
	}
	
	

}
