package data_layer;

public enum CreatureType {
	ARGONIAN {
		public String toString()
		{
			return "Argonian";
		}
	},
	BRETON {
		public String toString()
		{
			return "Breton";
		}
	},
	IMPERIAL {
		public String toString()
		{
			return "Imperial";
		}
	},
	KHAJIT {
		public String toString()
		{
			return "Khajit";
		}
	},
	DARKELF {
		public String toString()
		{
			return "Dark Elf";
		}
	},
	HIGHELF {
		public String toString()
		{
			return "High Elf";
		}
	},
	WOODELF {
		public String toString()
		{
			return "Wood Elf";
		}
	},
	NORD {
		public String toString()
		{
			return "Nord";
		}
	},
	ORC {
		public String toString()
		{
			return "Orc";
		}
	},
	REDGUARD {
		public String toString()
		{
			return "Redguard";
		}
	},
	GOD {
		public String toString()
		{
			return "God";
		}
	};
}
