package model.player;

import javafx.scene.image.Image;

public enum RunesLeft {
	FIVE(5) {
		@Override
		public Image getFilledRunesImage()
		{
			return new Image("/resources/playertower/profile_rune_border_5.png");
		}
	},
	FOUR(4) {
		@Override
		public Image getFilledRunesImage()
		{
			return new Image("/resources/playertower/profile_rune_border_4.png");
		}
	},
	THREE(3) {
		@Override
		public Image getFilledRunesImage()
		{
			return new Image("/resources/playertower/profile_rune_border_3.png");
		}
	},
	TWO(2) {
		@Override
		public Image getFilledRunesImage()
		{
			return new Image("/resources/playertower/profile_rune_border_2.png");
		}
	},
	ONE(1) {
		@Override
		public Image getFilledRunesImage()
		{
			return new Image("/resources/playertower/profile_rune_border_1.png");
		}
	},
	ZERO(0) {
		@Override
		public Image getFilledRunesImage()
		{
			return new Image("/resources/playertower/profile_rune_border_0.png");
		}
	};
	
	private int amount;
	
	private RunesLeft(int amount) {
		this.amount = amount;
	}
	
	
	public static RunesLeft fromValue(int amount) {
		
		switch(amount) {
		case 5: return RunesLeft.FIVE;
		case 4: return RunesLeft.FOUR;
		case 3: return RunesLeft.THREE;
		case 2: return RunesLeft.TWO;
		case 1: return RunesLeft.ONE;
		case 0: return RunesLeft.ZERO;
		default: return RunesLeft.ZERO;
		}
	}
	
	public int getAmount() {
		return this.amount;
	}

	public abstract Image getFilledRunesImage();
}
