package view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.transform.Scale;
import model.Observer;
import model.Subject;
import model.card.BattleCard;
import model.card.Card;
import model.card.CardAttribute;
import model.card.CardRarity;
import model.card.CardTextures;
import model.card.CardType;
import model.card.Keyword;
import model.card.KeywordList;
import model.player.MagickaData;

/**
 * @author Raivo Koot
 *
 */
public class CardUI extends AnchorPane implements Observer {

	private final double BIG_SCALE_SIZE = 1.40;
	private final double SMALL_SCALE_SIZE = 0.8;

	/* Description ui container */
	@FXML private StackPane pane_magickaAndBanner;
	@FXML private StackPane pane_attributeBig;
	@FXML private AnchorPane pane_detailview;

	/* Minimalistic ui containers */
	@FXML private StackPane pane_attributeSmall;
	@FXML private HBox hbox_keywords;

	/* card dependant static ui elements */

	// attribute background textures
	@FXML private ImageView imageView_descriptionBackground;
	@FXML private ImageView imageView_nameBackground;

	// power and health
	@FXML private Pane pane_power;
	@FXML private Pane pane_health;

	// name and description
	@FXML private Label label_name;
	@FXML private Label label_description;

	// attribute icons and rarity icon and border
	@FXML private ImageView imageView_attribute;
	@FXML private ImageView imageView_attributeSmall;
	@FXML private ImageView imageView_legendaryborder;
	@FXML private ImageView imageView_rarity;

	/* card state specific dynamic ui elements */

	// guard border and ward bubble
	@FXML private ImageView imageView_guardborder;
	@FXML private ImageView imageView_wardBubble;

	// number labels
	@FXML private Label label_keywords;
	@FXML private Text text_damage;
	@FXML private Text text_health;
	@FXML private Text text_magicka;

	private Subject subject;

	/**
	 * constructor that fills a new cardUI from a card object
	 * 
	 * @param card The card object to fill the cardUI with.
	 */
	public CardUI(Card card)
	{

		// load fxml file
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CardUI.fxml"));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		// load and setup pane
		try
		{
			fxmlLoader.load();
			setSubject(card);
			assignUISources(card);

			if (CardType.isCreatureOrItem(card))
				makeCreatureUI(card);

		} catch (IOException exception)
		{
			throw new RuntimeException(exception);
		}
	}

	@Override
	public void update()
	{
		// card is either support, action, creature or item
		Card update = (Card) this.subject.getUpdate(this);

		// update magicka label
		text_magicka.setText(String.valueOf(update.getMagicka_cost()));

		// if card is creature or item
		if (CardType.isCreatureOrItem(update))
		{
			BattleCard update_more = (BattleCard) update;

			// update keywords, health and power;
			updateKeywordIcons(update_more.getKeywords());
			text_damage.setText(String.valueOf(update_more.getPower()));
			text_health.setText(String.valueOf(update_more.getHealth()));

		}
	}

	@Override
	public void setSubject(Subject sub)
	{
		this.subject = sub;
		subject.register(this);
	}

	/**
	 * sets a card as the source object from which this ui will be frequently
	 * updated and sets the ui's initial values from it
	 * 
	 * @param card of which the values will be taken to customize this ui
	 */
	private void assignUISources(Card card)
	{
		update();

		// one time settings
		label_name.setText(card.getName());
		label_description.setText(card.getDescription());
		toggleLegendaryBorder(card.getRarity());
		assignTextures(card);
		setRarityIcon(card);

	}

	/**
	 * make the power and health elements of the ui visible
	 * 
	 * @param card
	 */
	private void makeCreatureUI(Card card)
	{
		card = (BattleCard) card;
		pane_power.setVisible(true);
		pane_health.setVisible(true);

	}

	/**
	 * shrinks the cards size from the current amount
	 */
	public void makeSmaller()
	{
		this.getTransforms().add(new Scale(SMALL_SCALE_SIZE, SMALL_SCALE_SIZE));
	}

	/**
	 * grows the cards size from the current amount
	 */
	public void makeBigger()
	{
		this.getTransforms().add(new Scale(BIG_SCALE_SIZE, BIG_SCALE_SIZE));
	}

	/**
	 * makes the ui of the card show the minimal elements or more detailed elements
	 */
	public void toggleMinimalisticView(boolean minimalistic)
	{
		// change visibility of controls
		pane_detailview.setVisible(!minimalistic);
		pane_magickaAndBanner.setVisible(!minimalistic);
		pane_attributeBig.setVisible(!minimalistic);
		pane_attributeSmall.setVisible(minimalistic);
		hbox_keywords.setVisible(minimalistic);
	}

	/**
	 * makes sure that the correct (or none) icons of keywords are displayed at the
	 * bottom of the card
	 * 
	 * @param keywords
	 */
	private void updateKeywordIcons(KeywordList keywords)
	{

		hbox_keywords.getChildren().clear();

		hbox_keywords.getChildren().addAll(keywords.getIconUIs());

		toggleGuardBorder(keywords.hasGuard());
		toggleWardBubble(keywords.hasWard());

	}

	/**
	 * shows or hides the guard border
	 * 
	 * @param guard boolean indicating guard status of card
	 */
	private void toggleGuardBorder(boolean guard)
	{
		imageView_guardborder.setVisible(guard);
	}

	/**
	 * shows or hides the legendary card border
	 * 
	 * @param rarity indicator of cards rarity type
	 */
	private void toggleLegendaryBorder(CardRarity rarity)
	{
		if (rarity == CardRarity.LEGENDARY)
			imageView_legendaryborder.setVisible(true);
	}

	/**
	 * makes the ward animation visible or not on the card
	 * 
	 * @param ward indication of ward status of card
	 */
	private void toggleWardBubble(boolean ward)
	{
		imageView_wardBubble.setVisible(ward);
	}

	/**
	 * Sets the background of the cardUI to the correctly colored textures based on
	 * the cards attribute type
	 * 
	 * @param card card used to determine the color of the ui
	 */
	private void assignTextures(Card card)
	{
		// assign attribute textures
		CardAttribute attribute = card.getAttribute();
		HashMap<CardTextures, Image> textures = attribute.getTextures();

		Image background_texture = textures.get(CardTextures.TEXT_BACKGROUND);
		Image icon_foto = textures.get(CardTextures.ATTRIBUTE_ICON);

		imageView_nameBackground.setImage(background_texture);
		imageView_descriptionBackground.setImage(background_texture);
		imageView_attribute.setImage(icon_foto);
		imageView_attributeSmall.setImage(icon_foto);
	}

	private void setRarityIcon(Card card)
	{
		imageView_rarity.setImage(card.getRarity().getIcon());
	}

	public Card getCard()
	{
		return (Card) subject;
	}

}