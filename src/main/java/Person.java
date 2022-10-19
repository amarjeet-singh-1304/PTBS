public abstract class Person {

	protected static ProductMenu theProductMenu;

	Person(ProductMenu theProductMenu){
		this.theProductMenu = theProductMenu;
	}

	public abstract void showMenu();

	public abstract ProductMenu CreateProductMenu();


}
