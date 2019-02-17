package model.game;

public class CurrentEventManager {
	private static GameState game;
	
	public static Event getCurrentEvent()
	{
		return game.getCurrentEvent();
	}
	
	public static void setCurrentEvent(Event currentEvent)
	{
		game.setCurrentEvent(currentEvent);
	}
	
	public static GameState getGame()
	{
		return game;
	}
	public static void setGame(GameState game)
	{
		CurrentEventManager.game = game;
	}
	
	
}
