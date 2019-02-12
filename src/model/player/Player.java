package model.player;

import model.cardlists.CardList;
import model.cardlists.DeckList;
import model.cardlists.MaximumSize;

public class Player {

	private HealthData health;
	private MagickaData magicka;
	private PlayerBaseData baseInfo;
	
	private DeckList deck;
	private CardList hand;
	private CardList discardPile;
	
	private CardList fieldLane;
	private CardList shadowLane;
	
	public Player() {
		health = new HealthData();
		magicka = new MagickaData();
		baseInfo = new PlayerBaseData();
		
		deck = new DeckList();
		hand = new CardList(MaximumSize.TEN);
		discardPile = new CardList(MaximumSize.HUNDRED);
		
		fieldLane = new CardList(MaximumSize.FOUR);
		shadowLane = new CardList(MaximumSize.FOUR);
		
	}

	public HealthData getHealth()
	{
		return health;
	}

	public void setHealth(HealthData health)
	{
		this.health = health;
	}

	public MagickaData getMagicka()
	{
		return magicka;
	}

	public void setMagicka(MagickaData magicka)
	{
		this.magicka = magicka;
	}

	public PlayerBaseData getBaseInfo()
	{
		return baseInfo;
	}

	public void setBaseInfo(PlayerBaseData baseInfo)
	{
		this.baseInfo = baseInfo;
	}

	public DeckList getDeck()
	{
		return deck;
	}

	public void setDeck(DeckList deck)
	{
		this.deck = deck;
	}

	public CardList getHand()
	{
		return hand;
	}

	public void setHand(CardList hand)
	{
		this.hand = hand;
	}

	public CardList getDiscardPile()
	{
		return discardPile;
	}

	public void setDiscardPile(CardList discardPile)
	{
		this.discardPile = discardPile;
	}

	public CardList getFieldLane()
	{
		return fieldLane;
	}

	public void setFieldLane(CardList fieldLane)
	{
		this.fieldLane = fieldLane;
	}

	public CardList getShadowLane()
	{
		return shadowLane;
	}

	public void setShadowLane(CardList shadowLane)
	{
		this.shadowLane = shadowLane;
	}
	
	
	
}
