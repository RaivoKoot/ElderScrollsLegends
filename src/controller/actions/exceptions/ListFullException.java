package controller.actions.exceptions;

import model.cardlists.CardList;

public class ListFullException extends Exception{
	
	private CardList list;
	
	public ListFullException(CardList list) {
		this.list = list;
	}
}
