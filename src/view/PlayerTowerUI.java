package view;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import model.Observer;
import model.Subject;
import model.player.DeckList;
import model.player.HealthData;
import model.player.MagickaData;
import model.player.PlayerBaseData;

public class PlayerTowerUI extends StackPane implements Observer {
	@FXML private ImageView imageView_runes;
	@FXML private ImageView imageView_foto;
	@FXML private Label label_health;

	private Subject subject;

	public PlayerTowerUI()
	{

		// load fxml file
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PlayerTowerUI.fxml"));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		// load and setup pane
		try
		{
			fxmlLoader.load();

		} catch (IOException exception)
		{
			throw new RuntimeException(exception);
		}
	}

	public void assignUISources(HealthData health, PlayerBaseData playerdata)
	{
		setProfileFoto(playerdata.getFoto());
		setSubject(health);
	}

	public void setProfileFoto(Image profile_foto)
	{
		imageView_foto.setImage(profile_foto);
	}

	@Override
	public void update()
	{
		HealthData update = (HealthData) this.subject.getUpdate(this);

		imageView_runes.setImage(update.getRuneImage()); // update rune amount
		label_health.setText(String.valueOf(update.getHealth())); // update health

	}

	@Override
	public void setSubject(Subject sub)
	{
		this.subject = sub;
		subject.register(this);
	}

}
