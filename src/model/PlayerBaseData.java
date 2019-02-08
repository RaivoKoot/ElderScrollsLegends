package model;

import javafx.scene.image.Image;

public class PlayerBaseData {

	private String name;
	private Image foto;
	
	public PlayerBaseData() {
		this.name = "Default Bitch";
		this.foto = new Image("/resources/playertower/profile_foto_default.png");
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Image getFoto()
	{
		return foto;
	}

	public void setFoto(Image foto)
	{
		this.foto = foto;
	}
}
