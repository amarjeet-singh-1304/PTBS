public abstract class Person {

	protected ProductMenu theProductMenu;

	Person(ProductMenu pm){
		this.theProductMenu = pm;
	}


	public abstract void showMenu();

	public abstract ProductMenu CreateProductMenu();

}
