package model.card;

import java.util.HashMap;

import javafx.scene.image.Image;
import model.GivesTextures;

public enum Keyword implements GivesTextures {
	DRAIN {
		@Override
		public HashMap<CardTextures, Image> getTextures()
		{
			return createHashMap("/resources/card/ability_drain_icon.png");
		}
	},
	LETHAL {
		@Override
		public HashMap<CardTextures, Image> getTextures()
		{
			return createHashMap("/resources/card/ability_lethal_icon.png");
		}
	},
	REGENERATE {
		@Override
		public HashMap<CardTextures, Image> getTextures()
		{
			return createHashMap("/resources/card/ability_regenerate_icon.png");
		}
	},
	WARD {
		@Override
		public HashMap<CardTextures, Image> getTextures()
		{
			return createHashMap("ward");
		}
	},
	BREAKTHROUGH {
		@Override
		public HashMap<CardTextures, Image> getTextures()
		{
			return createHashMap("/resources/card/ability_breakthrough_icon.png");
		}
	},
	RALLY {
		@Override
		public HashMap<CardTextures, Image> getTextures()
		{
			return createHashMap("/resources/card/ability_rally_icon.png");
		}
	},
	GUARD {
		@Override
		public HashMap<CardTextures, Image> getTextures()
		{
			return createHashMap("guard");
		}
	};

	private static HashMap<CardTextures, Image> createHashMap(String source_iconImg)
	{
		Image icon_foto;
		// ward presentation is different
		if (source_iconImg == "ward" || source_iconImg == "guard")
			icon_foto = null;
		else
			icon_foto = new Image(source_iconImg);

		HashMap<CardTextures, Image> images = new HashMap<CardTextures, Image>();
		images.put(CardTextures.KEYWORD_ICON, icon_foto);

		return images;
	}

}
