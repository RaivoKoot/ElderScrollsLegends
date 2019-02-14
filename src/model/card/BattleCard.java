package model.card;

import model.Observer;
import model.Subject;

public class BattleCard extends Card implements Observer{

	private KeywordList keywords;

	private int initialPower;
	private int initialHealth;
	private StatAlterationList statAlterations;
	
	/**
	 * observes its own StatAlterationList to notify CardUI of change
	 */
	private Subject subject;

	public BattleCard()
	{
		super();
		keywords = new KeywordList();
		statAlterations = new StatAlterationList();
		setSubject(statAlterations);
	}
	
	@Override
	public void update()
	{
		notifyObservers();
	}

	@Override
	public void setSubject(Subject sub)
	{
		this.subject = sub;
		subject.register(this);
	}

	public int getPower()
	{
		return initialPower + statAlterations.sumPower();
	}

	public int getHealth()
	{
		return initialHealth + statAlterations.sumHealth();
	}

	public KeywordList getKeywords()
	{
		return keywords;
	}

	public void setKeywords(KeywordList keywords)
	{
		this.keywords = keywords;
		notifyObservers();
	}

	public int getInitialPower()
	{
		return initialPower;
	}

	public void setInitialPower(int initialPower)
	{
		this.initialPower = initialPower;
	}

	public int getInitialHealth()
	{
		return initialHealth;
	}

	public void setInitialHealth(int initialHealth)
	{
		this.initialHealth = initialHealth;
	}

	public StatAlterationList getStatAlterations()
	{
		return statAlterations;
	}

	public void setStatAlterations(StatAlterationList statAlterations)
	{
		this.statAlterations = statAlterations;
	}
}
