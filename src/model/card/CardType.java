package model.card;

import java.util.Arrays;
import java.util.List;

public enum CardType {
	CREATURE, ITEM, ACTION, SUPPORT, ARGONIAN, BRETON, IMPERIAL, KHAJIT, DARKELF, HIGHELF, WOODELF, NORD, ORC, REDGUARD,
	GOD, DRAGON, VAMPIRE, BEAST, FISH, MAMMOTH, MUDCRAB, NETCH, REPTILE, SPIDER, SKEEVER, WOLF, MUMMY, SKELETON, SPIRIT,
	ASHCREATURE, AUTOMATON, CENTAUR, CHAURUS, DAEDRA, DEFENSE, DREUGH, DWEMER, FALMER, FABRICANT, FACTOTUM, GARGOYLE,
	GIANT, GOBLIN, HARPY, IMP, INSECT, KWAMA, LURCHER, MANTIKORA, MINOTAUR, NEREID, OGRE, PASTRY, REACHMAN, SPRIGGAN,
	TROLL, WAMASU, WEREWOLF, WRAITH;

	private static final List<CardType> UNDEAD = Arrays.asList(CardType.MUMMY, CardType.SKELETON, CardType.SPIRIT,
			CardType.VAMPIRE);

	private static final List<CardType> ANIMALS = Arrays.asList(CardType.BEAST, CardType.FISH, CardType.MAMMOTH,
			CardType.MUDCRAB, CardType.NETCH, CardType.REPTILE, CardType.SPIDER, CardType.SKEEVER, CardType.WOLF);

	public static boolean isCreatureOrItem(Card card)
	{
		if (card.getType() == CardType.CREATURE || card.getType() == CardType.ITEM)
			return true;

		return false;
	}

	public static boolean isUndead(CardType type)
	{
		if (UNDEAD.contains(type))
			return true;

		return false;
	}

	public static boolean isAnimal(CardType type)
	{
		if (ANIMALS.contains(type))
			return true;

		return false;
	}

}
