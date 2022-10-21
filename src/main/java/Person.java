public abstract class Person {

	protected static ProductMenu theProductMenu;
	public ClassProductList productList;

	public String userName ="";

	Person(){}

	Person(ProductMenu theProductMenu){
		this.theProductMenu = theProductMenu;
	}

	public abstract void showMenu( ProductMenu pm, String userName, int productType);

	public ClassProductList getProductList(){
		return productList;
	}

	public abstract ProductMenu CreateProductMenu();

	public void addProduct(Product theProduct)
	{
		productList.add(theProduct);
	}

}
