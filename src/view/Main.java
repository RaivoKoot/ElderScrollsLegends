package view;
	
import javafx.application.Application;
import javafx.stage.Stage;
import model.Card;
import model.CardAttribute;
import model.Keyword;
import javafx.scene.Scene;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			//GameSessionMasterUI root = new GameSessionMasterUI();
			
			Card card = new Card();

			card.setAttribute(CardAttribute.ENDURANCE);
			card.addKeyword(Keyword.DRAIN);
			card.addKeyword(Keyword.GUARD);
			card.addKeyword(Keyword.BREAKTHROUGH);
			card.addKeyword(Keyword.LETHAL);
			CardUI root = new CardUI(card);
			//root.showDetailView();
			root.showLegendaryBorder();
			
			
			Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage.setFullScreen(true);
			primaryStage.setMaximized(true);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
