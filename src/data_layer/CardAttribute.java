package data_layer;

import java.util.HashMap;

import javafx.scene.image.Image;

public enum CardAttribute {
	STRENGTH {
		@Override
		public HashMap<CardTextures, Image> getTextures()
		{
			return createHashMap("/resources_cardui/red_texture.png", "/resources_cardui/strength_icon.png");
		}
	}, INTELLIGENCE {
		@Override
		public HashMap<CardTextures, Image> getTextures()
		{
			return createHashMap("/resources_cardui/blue_texture.jpg", "/resources_cardui/intelligence_icon.png");
		}
	}, WILLPOWER {
		@Override
		public HashMap<CardTextures, Image> getTextures()
		{
			return createHashMap("/resources_cardui/yellow_texture.png", "/resources_cardui/willpower_icon.png");
		}
	}, AGILITY {
		@Override
		public HashMap<CardTextures, Image> getTextures()
		{
			return createHashMap("/resources_cardui/green_texture.png", "/resources_cardui/agility_icon.png");
		}
	}, ENDURANCE {
		@Override
		public HashMap<CardTextures, Image> getTextures()
		{
			return createHashMap("/resources_cardui/purple_texture.jpg", "/resources_cardui/endurance_icon.png");
		}
	}, NEUTRAL {
		@Override
		public HashMap<CardTextures, Image> getTextures()
		{
			return createHashMap("/resources_cardui/gray_texture.png", "/resources_cardui/neutral_icon.png");
		}
	};

	
	public abstract HashMap<CardTextures, Image> getTextures();
	
	private static HashMap<CardTextures, Image> createHashMap(String source_background, String source_icon){
		Image background_texture = new Image(source_background);
		Image icon_foto = new Image(source_icon);
		
		HashMap<CardTextures, Image> images = new HashMap<CardTextures, Image>();
		images.put(CardTextures.TEXT_BACKGROUND, background_texture);
		images.put(CardTextures.ATTRIBUTE_ICON, icon_foto);
		
		return images;
	}
}
