import java.util.ArrayList;

public class Product {
	public String productName;
	public ArrayList<Trading> tradingList=new ArrayList<Trading>();
	public int userType;
	public Product(String productname,int type)
	{
		this.productName=productname;
		this.userType=type;
	}

	public void addTrading(Trading trade)
	{
		tradingList.add(trade);
	}

}
