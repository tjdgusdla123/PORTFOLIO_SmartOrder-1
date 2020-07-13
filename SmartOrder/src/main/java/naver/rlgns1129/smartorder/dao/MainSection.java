package naver.rlgns1129.smartorder.dao;

public class MainSection {
	private String main;
	private String alcohol;
	private String drink;
	
	public String getMain() {
		return main;
	}
	public void setMain(String main) {
		this.main = main;
	}
	public String getAlcohol() {
		return alcohol;
	}
	public void setAlcohol(String alcohol) {
		this.alcohol = alcohol;
	}
	public String getDrink() {
		return drink;
	}
	public void setDrink(String drink) {
		this.drink = drink;
	}
	
	@Override
	public String toString() {
		return "MainSection [main=" + main + ", alcohol=" + alcohol + ", drink=" + drink + "]";
	}
	
	
}
