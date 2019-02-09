package model;

import java.util.HashMap;

import javafx.scene.image.Image;
import model.card.CardTextures;

public interface GivesTextures {
	public abstract HashMap<CardTextures, Image> getTextures();
}
