package application;

import java.io.IOException;
import java.util.HashMap;

import data_layer.Card;
import data_layer.CardAttribute;
import data_layer.CardTextures;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.transform.Scale;

/**
 * @author Raivo Koot
 *
 */
public class CardUI extends AnchorPane {
	
	private final double BIG_SCALE_SIZE = 1.35;
	private final double SMALL_SCALE_SIZE = 1;

	@FXML private StackPane pane_magickaAndBanner;
	@FXML private StackPane pane_attributeBig;
	@FXML private StackPane pane_attributeSmall;
	@FXML private HBox hbox_effects;

	@FXML private AnchorPane pane_detailview;

	@FXML private ImageView imageView_descriptionBackground;
	@FXML private ImageView imageView_nameBackground;
	@FXML private ImageView imageView_attribute;
	@FXML private ImageView imageView_attributeSmall;
	@FXML private ImageView imageView_guardborder;
	@FXML private ImageView imageView_legendaryborder;
	@FXML private ImageView imageView_wardBubble;
	
	@FXML private Label label_name;
	@FXML private Label label_description;
	@FXML private Label label_keywords;
	@FXML private Text text_damage;
	@FXML private Text text_health;
	

	private Card card;

	/**
	 * constructor that fills a new cardUI from a card object
	 * @param card The card object to fill the cardUI with.
	 */
	public CardUI(Card card)
	{
		this.card = card;

		// load fxml file
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CardUI.fxml"));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		// load and setup pane
		try
		{
			fxmlLoader.load();

			// assign correct texture colors
			assignTextures();

		} catch (IOException exception)
		{
			throw new RuntimeException(exception);
		}
	}

	/**
	 * shows all detail panes and increases size of cardUI
	 */
	public void showDetailView()
	{
		// change visibility of controls
		pane_detailview.setVisible(true);
		pane_magickaAndBanner.setVisible(true);
		pane_attributeBig.setVisible(true);
		pane_attributeSmall.setVisible(false);
		hbox_effects.setVisible(false);
		// set correct pane size
		//this.getTransforms().add(new Scale(BIG_SCALE_SIZE, BIG_SCALE_SIZE));
	}

	/**
	 * hides detail panes and decreases size of cardUI
	 */
	public void hideDetailView()
	{
		// change visibility of controls
		pane_detailview.setVisible(false);
		pane_magickaAndBanner.setVisible(false);
		pane_attributeBig.setVisible(false);
		pane_attributeSmall.setVisible(true);
		hbox_effects.setVisible(true);
		// set correct pane size
		this.getTransforms().add(new Scale(SMALL_SCALE_SIZE, SMALL_SCALE_SIZE));
	}

	/**
	 * Sets the background imageViews of the cardUI to
	 * the correctly colored textures
	 * @param card 
	 */
	private void assignTextures()
	{
		CardAttribute attribute = this.card.getAttribute();
		HashMap<CardTextures, Image> textures = attribute.getTextures();

		Image background_texture = textures.get(CardTextures.TEXT_BACKGROUND);
		Image icon_foto = textures.get(CardTextures.ATTRIBUTE_ICON);

		imageView_nameBackground.setImage(background_texture);
		imageView_descriptionBackground.setImage(background_texture);
		imageView_attribute.setImage(icon_foto);
		imageView_attributeSmall.setImage(icon_foto);
	}
	
	public void showGuardBorder() {
		imageView_guardborder.setVisible(true);
	}
	
	public void showLegendaryBorder() {
		imageView_legendaryborder.setVisible(true);
	}
	
	public void showWardBubble() {
		imageView_wardBubble.setVisible(true);
	}

}