package model.card;

import java.util.HashMap;

import javafx.scene.image.Image;
import model.GivesTextures;

public enum CardAttribute implements GivesTextures{
	STRENGTH {
		@Override
		public HashMap<CardTextures, Image> getTextures()
		{
			return createHashMap("/resources/card/red_texture.png", "/resources/card/strength_icon.png");
		}
	}, INTELLIGENCE {
		@Override
		public HashMap<CardTextures, Image> getTextures()
		{
			return createHashMap("/resources/card/blue_texture.jpg", "/resources/card/intelligence_icon.png");
		}
	}, WILLPOWER {
		@Override
		public HashMap<CardTextures, Image> getTextures()
		{
			return createHashMap("/resources/card/yellow_texture.png", "/resources/card/willpower_icon.png");
		}
	}, AGILITY {
		@Override
		public HashMap<CardTextures, Image> getTextures()
		{
			return createHashMap("/resources/card/green_texture.png", "/resources/card/agility_icon.png");
		}
	}, ENDURANCE {
		@Override
		public HashMap<CardTextures, Image> getTextures()
		{
			return createHashMap("/resources/card/purple_texture.jpg", "/resources/card/endurance_icon.png");
		}
	}, NEUTRAL {
		@Override
		public HashMap<CardTextures, Image> getTextures()
		{
			return createHashMap("/resources/card/gray_texture.png", "/resources/card/neutral_icon.png");
		}
	};
	
	private static HashMap<CardTextures, Image> createHashMap(String source_background, String source_icon){
		Image background_texture = new Image(source_background);
		Image icon_foto = new Image(source_icon);
		
		HashMap<CardTextures, Image> images = new HashMap<CardTextures, Image>();
		images.put(CardTextures.TEXT_BACKGROUND, background_texture);
		images.put(CardTextures.ATTRIBUTE_ICON, icon_foto);
		
		return images;
	}
}
