import java.util.Iterator;
import java.util.List;

public class ProductIterator implements  ListIterator{

	private ClassProductList classProductList;
	private List<Product> productList;
	private int position;

	int productnumber=-1;

	public ProductIterator(ClassProductList productList){
		this.classProductList = productList;
	}

	public boolean hasNext() {
		if(productnumber>=productList.size()-1)
		{
			return false;
		}
		return true;
	}

	public Object Next() {
		if (hasNext()==true)
		{
			productnumber++;
			return productList.get(productnumber);
		}
		return null;
		// TODO Auto-generated method stub
	}

	public Object next(String productName) {
		Product product;
		product=(Product)Next();
		while(product!=null)
		{
			if(productName.compareTo(product.toString())==0)
			{
				return product;
			}
			product=(Product)Next();
		}
		return null;
	}

	@Override
	public boolean hasNext(Iterator iter) {
		return false;
	}

	@Override
	public Object Next(Iterator iter) {
		return null;
	}

	public void MoveToHead(Iterator iter) {

	}

	public void Remove(Iterator iter) {
		if (this.hasNext(iter)) {
			iter.next();
		}


	}

	@Override
	public boolean HasNext(Iterator iterator) {
		return false;
	}

}
