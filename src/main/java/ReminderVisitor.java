public class ReminderVisitor extends NodeVisitor {

	private Reminder m_Reminder;

	private ClassProductList classProductList;

	public ReminderVisitor(Reminder reminder)
	{
		m_Reminder=reminder;
	}

	public void visitProduct(Product product) {
		System.out.println("Visiting Product:");


	}
	/**
	 *  
	 */
	public void visitTrading(Trading trading) {
		System.out.println("Visiting Trade");

	}

	/**
	 *  
	 */
	public void visitFacade(Facade facade) {

	}

}
