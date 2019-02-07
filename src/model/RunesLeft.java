package model;

import javafx.scene.image.Image;

public enum RunesLeft {
	FIVE {
		@Override
		public Image getFilledRunesImage()
		{
			return new Image("/resources/playertower/profile_rune_border_5.jpg");
		}
	},
	FOUR {
		@Override
		public Image getFilledRunesImage()
		{
			return new Image("/resources/playertower/profile_rune_border_4.jpg");
		}
	},
	THREE {
		@Override
		public Image getFilledRunesImage()
		{
			return new Image("/resources/playertower/profile_rune_border_3.jpg");
		}
	},
	TWO {
		@Override
		public Image getFilledRunesImage()
		{
			return new Image("/resources/playertower/profile_rune_border_2.jpg");
		}
	},
	ONE {
		@Override
		public Image getFilledRunesImage()
		{
			return new Image("/resources/playertower/profile_rune_border_1.jpg");
		}
	},
	ZERO {
		@Override
		public Image getFilledRunesImage()
		{
			return new Image("/resources/playertower/profile_rune_border_0.jpg");
		}
	};

	public abstract Image getFilledRunesImage();
}
