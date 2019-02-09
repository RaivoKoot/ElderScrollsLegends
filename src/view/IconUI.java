package view;

import java.io.IOException;
import java.util.HashMap;

import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.GivesTextures;
import model.card.CardAttribute;
import model.card.CardTextures;

public class IconUI extends ImageView{
	
	public IconUI(GivesTextures icon_filler)
	{

		// load fxml file
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("IconUI.fxml"));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		// load and setup pane
		try
		{
			fxmlLoader.load();
			assignIconImage(icon_filler);

		} catch (IOException exception)
		{
			throw new RuntimeException(exception);
		}
	}
	
	private void assignIconImage(GivesTextures icon_filler) {
		HashMap<CardTextures, Image> attributeTextures = icon_filler.getTextures();

		// icon is for an attribute
		Image icon_foto = attributeTextures.get(CardTextures.ATTRIBUTE_ICON);
		
		// icon is for a keyword
		if(icon_foto == null) {
			icon_foto = attributeTextures.get(CardTextures.KEYWORD_ICON);
			this.setFitWidth(18);
			this.setFitHeight(18);
		}
		
		this.setImage(icon_foto);
	}
	
}
