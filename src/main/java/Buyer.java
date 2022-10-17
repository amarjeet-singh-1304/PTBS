public class Buyer extends Person {

	Buyer( ProductMenu pm){
		super(pm);
	}

	public void showMenu() {
		System.out.println("Showing Menu:");
		theProductMenu.showMenu();

	}

	public ProductMenu CreateProductMenu() {
		return null;
	}

}
