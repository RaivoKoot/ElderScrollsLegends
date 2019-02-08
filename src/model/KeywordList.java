package model;

import java.util.ArrayList;

import view.IconUI;

public class KeywordList extends ArrayList<Keyword> {

	public ArrayList<IconUI> getIconUIs()
	{
		ArrayList<IconUI> icon_UIs = new ArrayList<IconUI>();

		for (Keyword keyword : this)
		{
			switch (keyword) {

			case WARD:
			case GUARD:
				break;
			default:
				IconUI keywordUI = new IconUI(keyword);
				icon_UIs.add(keywordUI);
				break;
			}
		}

		return icon_UIs;
	}

	@Override
	public String toString()
	{
		String list = "";

		for (int i = 0; i < this.size(); i++)
		{
			list += this.get(i);

			if (i != this.size())
				list += ",";

		}

		return list;

	}

	public boolean hasGuard()
	{
		return this.contains(Keyword.GUARD);
	}

	public boolean hasWard()
	{
		return this.contains(Keyword.WARD);
	}

}
