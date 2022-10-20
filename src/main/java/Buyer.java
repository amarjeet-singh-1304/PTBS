
public class Buyer extends Person {


	Buyer()
	{
		super(theProductMenu);

	}
	Buyer( ProductMenu theProductMenu){
		super(theProductMenu);
	}


	public void showMenu(ProductMenu theProductMenu, String userName, int userType) {

		theProductMenu.showMenu();

	}

	public ProductMenu CreateProductMenu() {
		String productMenutype = "";
		return null;
	}


}
