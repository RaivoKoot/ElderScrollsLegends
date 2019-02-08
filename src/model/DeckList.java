package model;

import java.util.ArrayList;

public class DeckList {
	
	private ArrayList<CardAttribute> attributes;
	
	// TESTING
	public DeckList() {
		attributes = new ArrayList<CardAttribute>();
		addAttribute(CardAttribute.ENDURANCE);
		addAttribute(CardAttribute.INTELLIGENCE);
	}

	public ArrayList<CardAttribute> getAttributes()
	{
		return attributes;
	}

	public void addAttribute(CardAttribute attribute)
	{
		this.attributes.add(attribute);
	}

}
