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
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.transform.Scale;
import model.Card;
import model.CardAttribute;
import model.CardTextures;
import model.Keyword;
import model.KeywordList;
import model.MagickaData;
import model.Observer;
import model.Subject;

/**
 * @author Raivo Koot
 *
 */
public class CardUI extends AnchorPane implements Observer {

	private final double BIG_SCALE_SIZE = 1.25;
	private final double SMALL_SCALE_SIZE = 0.8;

	@FXML private StackPane pane_magickaAndBanner;
	@FXML private StackPane pane_attributeBig;
	@FXML private StackPane pane_attributeSmall;
	@FXML private HBox hbox_keywords;

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
			initializeUI(card);

		} catch (IOException exception)
		{
			throw new RuntimeException(exception);
		}
	}

	private void initializeUI(Card card)
	{
		update();

		// one time settings
		label_name.setText(card.getName());
		label_description.setText(card.getDescription());
		label_keywords.setText(card.getKeywords().toString());
		toggleLegendaryBorder(card.isLegendary());
		assignTextures(card);
	}

	public void makeSmaller()
	{
		this.getTransforms().add(new Scale(SMALL_SCALE_SIZE, SMALL_SCALE_SIZE));
	}

	public void makeBigger()
	{
		this.getTransforms().add(new Scale(BIG_SCALE_SIZE, BIG_SCALE_SIZE));
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
		hbox_keywords.setVisible(false);
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
		hbox_keywords.setVisible(true);
	}

	private void updateKeywordIcons(KeywordList keywords)
	{

		hbox_keywords.getChildren().clear();

		hbox_keywords.getChildren().addAll(keywords.getIconUIs());

		toggleGuardBorder(keywords.hasGuard());
		toggleWardBubble(keywords.hasWard());

	}

	@Override
	public void update()
	{
		Card update = (Card) this.subject.getUpdate(this);

		updateKeywordIcons(update.getKeywords());
		text_damage.setText(String.valueOf(update.getPower()));
		text_health.setText(String.valueOf(update.getHealth()));
	}

	@Override
	public void setSubject(Subject sub)
	{
		this.subject = sub;
		subject.register(this);
	}

	private void toggleGuardBorder(boolean guard)
	{
		imageView_guardborder.setVisible(guard);
	}

	private void toggleLegendaryBorder(boolean legendary)
	{
		imageView_legendaryborder.setVisible(legendary);
	}

	private void toggleWardBubble(boolean ward)
	{
		imageView_wardBubble.setVisible(ward);
	}

	/**
	 * Sets the background of the cardUI to the correctly colored textures
	 * 
	 * @param card
	 */
	private void assignTextures(Card card)
	{
		CardAttribute attribute = card.getAttribute();
		HashMap<CardTextures, Image> textures = attribute.getTextures();

		Image background_texture = textures.get(CardTextures.TEXT_BACKGROUND);
		Image icon_foto = textures.get(CardTextures.ATTRIBUTE_ICON);

		imageView_nameBackground.setImage(background_texture);
		imageView_descriptionBackground.setImage(background_texture);
		imageView_attribute.setImage(icon_foto);
		imageView_attributeSmall.setImage(icon_foto);
	}

}