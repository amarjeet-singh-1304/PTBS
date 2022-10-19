public class Buyer extends Person {


	Buyer()
	{
		super(theProductMenu);

	}
	Buyer( ProductMenu theProductMenu){
		super(theProductMenu);
	}

	@Override
	public void showMenu() {

		theProductMenu.showMenu();

	}

	public ProductMenu CreateProductMenu() {
		String productMenutype = "";
		return null;
	}

}
