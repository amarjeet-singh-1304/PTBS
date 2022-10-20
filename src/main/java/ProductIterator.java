import java.util.Iterator;
import java.util.List;

public class ProductIterator implements  ListIterator{

	private ClassProductList classProductList;
	private List<Product> productList;
	private int position;

	public boolean hasNext(Iterator iter) {
		if(iter.next() != null)
			return iter.hasNext();
		else
			return false;
	}

	public Product Next(Iterator iter) {
		if(this.hasNext(iter))
		{
			return (Product) iter.next();
		}
		else return null;
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
