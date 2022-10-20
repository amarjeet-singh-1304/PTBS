public abstract class Person {

	protected static ProductMenu theProductMenu;

	Person(ProductMenu theProductMenu){
		this.theProductMenu = theProductMenu;
	}

	public abstract void showMenu( ProductMenu pm, String userName, int productType);

	public abstract ProductMenu CreateProductMenu();


}
