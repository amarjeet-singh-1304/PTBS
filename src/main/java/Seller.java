public class Seller extends Person {

	/**
	 *  
	 */

	Seller( ProductMenu pm){
		super(pm);
	}
	public void showMenu() {
		System.out.println("Showing Menu:");
		theProductMenu.showMenu();

	}

	@Override
	public ProductMenu CreateProductMenu() {
		return null;
	}

	public ProductMenu createProductMenu() {
		return null;
	}

}
