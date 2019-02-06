package user_interface;

import java.io.IOException;
import java.util.HashMap;

import data_layer.CardAttribute;
import data_layer.CardTextures;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AttributeIconUI extends ImageView{
	
	
	
	public AttributeIconUI(CardAttribute attribute)
	{

		// load fxml file
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AttributeIconUI.fxml"));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		// load and setup pane
		try
		{
			fxmlLoader.load();
			assignAttributeImage(attribute);

		} catch (IOException exception)
		{
			throw new RuntimeException(exception);
		}
	}
	
	private void assignAttributeImage(CardAttribute attribute) {
		HashMap<CardTextures, Image> attributeTextures = attribute.getTextures();

		Image icon_foto = attributeTextures.get(CardTextures.ATTRIBUTE_ICON);
		this.setImage(icon_foto);
	}
	
}
