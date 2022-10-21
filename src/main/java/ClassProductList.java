import java.util.ArrayList;

public class ClassProductList extends ArrayList<Product> {

	private Product product;

	private ReminderVisitor reminderVisitor;

	private ProductIterator productIterator;


	ClassProductList(){

	}

	public void accept(NodeVisitor visitor) {
		System.out.println("Product List Reminder ...");
		visitor.visitProduct(this.product);

	}

}
