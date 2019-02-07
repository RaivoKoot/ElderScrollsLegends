package view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

public class GameSessionMasterUI extends BorderPane{
	
	@FXML private CentralArenaUI centralArenaUI;

	public GameSessionMasterUI()
	{

		// load fxml file
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GameSessionMasterUI.fxml"));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		// load and setup pane
		try
		{
			fxmlLoader.load();
			
		} catch (IOException exception)
		{
			throw new RuntimeException(exception);
		}
	}
	
}
