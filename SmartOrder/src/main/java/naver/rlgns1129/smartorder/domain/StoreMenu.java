package naver.rlgns1129.smartorder.domain;

public class StoreMenu {
	private String menuCode;
	private String menuName;
	private String menuInfo;
	private Integer menuPrice;
	private String menuPhoto;
	private String menuSection;
	private String storeNickname;

	public StoreMenu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StoreMenu(String menuCode, String menuName, String menuInfo, Integer menuPrice, String menuPhoto,
			String menuSection, String storeNickname) {
		super();
		this.menuCode = menuCode;
		this.menuName = menuName;
		this.menuInfo = menuInfo;
		this.menuPrice = menuPrice;
		this.menuPhoto = menuPhoto;
		this.menuSection = menuSection;
		this.storeNickname = storeNickname;
	}

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuInfo() {
		return menuInfo;
	}

	public void setMenuInfo(String menuInfo) {
		this.menuInfo = menuInfo;
	}

	public Integer getMenuPrice() {
		return menuPrice;
	}

	public void setMenuPrice(Integer menuPrice) {
		this.menuPrice = menuPrice;
	}

	public String getMenuPhoto() {
		return menuPhoto;
	}

	public void setMenuPhoto(String menuPhoto) {
		this.menuPhoto = menuPhoto;
	}

	public String getMenuSection() {
		return menuSection;
	}

	public void setMenuSection(String menuSection) {
		this.menuSection = menuSection;
	}

	public String getStoreNickname() {
		return storeNickname;
	}

	public void setStoreNickname(String storeNickname) {
		this.storeNickname = storeNickname;
	}

	@Override
	public String toString() {
		return "StoreMenu [menuCode=" + menuCode + ", menuName=" + menuName + ", menuInfo=" + menuInfo + ", menuPrice="
				+ menuPrice + ", menuPhoto=" + menuPhoto + ", menuSection=" + menuSection + ", storeNickname="
				+ storeNickname + "]";
	}

}	