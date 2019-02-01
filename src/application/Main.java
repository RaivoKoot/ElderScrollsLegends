package application;
	
import data_layer.Card;
import data_layer.CardAttribute;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			GameBoardUI root = new GameBoardUI();
			root.fillHandTest();
			/*
			VBox root = new VBox();
			root.setSpacing(200.0);
			HBox row1 = new HBox();
			HBox row2 = new HBox();
			
			row1.setSpacing(200.0);
			row2.setSpacing(200.0);
			
			Card card_1 = new Card();
			Card card_2 = new Card();
			Card card_3 = new Card();
			Card card_4 = new Card();
			Card card_5 = new Card();
			Card card_6 = new Card();
			
			card_1.setAttribute(CardAttribute.STRENGTH);
			card_2.setAttribute(CardAttribute.INTELLIGENCE);
			card_3.setAttribute(CardAttribute.WILLPOWER);
			card_4.setAttribute(CardAttribute.AGILITY);
			card_5.setAttribute(CardAttribute.ENDURANCE);
			card_6.setAttribute(CardAttribute.NEUTRAL);
			
			CardUI cardUI_1 = new CardUI(card_1);
			CardUI cardUI_2 = new CardUI(card_2);
			CardUI cardUI_3 = new CardUI(card_3);
			CardUI cardUI_4 = new CardUI(card_4);
			CardUI cardUI_5 = new CardUI(card_5);
			CardUI cardUI_6 = new CardUI(card_6);
			
			cardUI_1.showGuardBorder();
			cardUI_2.showGuardBorder();
			cardUI_2.showLegendaryBorder();
			cardUI_5.showDetailView();
			cardUI_5.showLegendaryBorder();
			cardUI_6.showDetailView();
			cardUI_3.showLegendaryBorder();
			
			row1.getChildren().addAll(cardUI_1,cardUI_2,cardUI_3);
			row2.getChildren().addAll(cardUI_4,cardUI_5,cardUI_6);
			root.getChildren().addAll(row1,row2);
			*/
			
			
			Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage.setFullScreen(true);
			//primaryStage.setMaximized(true);
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
