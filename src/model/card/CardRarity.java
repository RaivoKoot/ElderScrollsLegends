package model.card;

import javafx.scene.image.Image;

public enum CardRarity {
	COMMON, RARE, EPIC, LEGENDARY;

	public Image getIcon()
	{
		String image_url = "/resources/card/rarity_icon_INSERTRARITY.png";

		String name = this.name();
		image_url = image_url.replace("INSERTRARITY", name.toLowerCase());

		return new Image(image_url);
	}
}
