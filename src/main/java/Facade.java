import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Facade  {

	private int userType;

	private Product theSelectedProduct;

	private int nProductCategory;

	private ClassProductList theProductList;

	private Person thePerson;

	private String userName;

	private ArrayList<String> arrayList = new ArrayList<String>();
	public void startFacade() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to PTBS System:");
		System.out.println("\n Please select any of below Option: \n 1. Login \n 2. Create New User");
		int value = scanner.nextInt();
		if(value == 1) {
			System.out.println("\n Implementing  Facade pattern");
			userType = login(new Login());
			System.out.println(userType);
			System.out.println("\n Select from available Product Menu \n 1. Meat Product Menu \n 2. Produce Product Menu. " +
					"\n Enter 1 or 2 based on above selection");
			int selectProductType = scanner.nextInt();

			//Implementing Bridge and Factory Pattern. Based on selection by user from meat items and produce items, it will display the result
			System.out.println("\n Implementing Bridge and Factory Pattern");
			if (selectProductType == 1) {
				SelectProduct(new MeatProductMenu(), userType, userName, selectProductType);
			} else if (selectProductType == 2) {
				SelectProduct(new ProduceProductMenu(), userType, userName, selectProductType);
			} else {
				System.out.println("Please select from above given choices");
				System.exit(-1);
			}

			if(userType == 0) {
				//Reminder is used to show the previously items selected by buyer
				System.out.println("\n Implementing Visitor Pattern....");
				System.out.println("Just a Reminder about your Selected Products. Showing the Products Below:");
				thePerson = new Buyer();
				thePerson.userName = userName;
				remind();
			}
			System.out.println("\n Implementing Iterator pattern");;
			System.out.println("\n Do you want to see the current offered products: \n 1. Yes \n 2. No");
			int value1 = scanner.nextInt();
			if(value1 == 1)
			{
				OfferingList offeringList = new OfferingList();
				Iterator itr = offeringList.createIterator();
				OfferingIterator offeringIterator = new OfferingIterator();
				while(offeringIterator.hasNext(itr))
				{
					String k = offeringIterator.Next(itr);
					if(k == null)
						break;
					System.out.println(k);

				}

				if(userType == 0) {
					System.out.println("\n Enter the name of item you want to buy from above offered products:");
					String a = scanner.next();
					updateUserProduct(a, userName);


				}

			}
			else{
				System.out.println("Exiting the System");
			}


		}
		else if(value == 2)
		{
			System.out.println("Enter the type of User: \n 0. Buyer \n 1. Seller");
			userType = scanner.nextInt();
			System.out.println("Enter the UserName:");
			String userName = scanner.next();
			System.out.println("Enter Password:");
			String password = scanner.next();
			createUser( new UserInfoItem(userType, userName, password));
			System.exit(0);
		}
		else {
			System.out.println("Choose Appropriate Option from above. Exiting the App");
			System.exit(0);

		}
		scanner.close();
	}


	public int login(Login login) {
		boolean output = login.HasAccess();
		if(output == true) {
			userName = login.username;
			return login.GetUserType();
		}
		else
			System.exit(-1);
			return -1;
	}

	public void addTrading() {

	}

	public void viewTrading() {

	}

	public void decideBidding() {

	}

	public void discussBidding() {

	}

	public void submitBidding() {

	}

	public void showMenu( ProductMenu sm)
	{
		sm.showMenu();
	}

	/**
	 *  
	 */
	public void remind() {
		GetUserProducts();
		Reminder reminder = new Reminder();
		reminder.showReminder(thePerson.getProductList());

	}

	public void createUser(UserInfoItem userinfoitem) {
		String path = "";
		AddNewUser adduser = new AddNewUser();
		switch(userinfoitem.type)
		{
			case 0:
				path = "src/main/resources/BuyerInfo.txt";
				adduser.AddDetailsToConfig(path, userinfoitem.user, userinfoitem.password);


			case 1:
				path = "src/main/resources/SellerInfo.txt";
				adduser.AddDetailsToConfig(path, userinfoitem.user, userinfoitem.password);

		}
	}

	/**
	 *  
	 */
	public void createProductList() {

	}

	/**
	 *  
	 */
	public void GetUserProducts() {
		BufferedReader file;
		try {
			FileReader fr = new FileReader("src/main/resources/UserProduct.txt");
			file = new BufferedReader(fr);
			String line, username, productName;
			while ((line = file.readLine()) != null) {
				username = getUserName(line);
				productName = getProductName(line);
				if (username.replaceAll("\\s", "").toLowerCase().equals(thePerson.userName.replaceAll("\\s", "").toLowerCase())) {
					arrayList.add(productName);
					//theSelectedProduct = findProductByProductName(productName);

				}
			}
			if( arrayList.isEmpty())
			{
				System.out.println("You havenot selected any product previously");
			}
			else {
				for(int i = 0; i < arrayList.size(); i++) {
					System.out.println(arrayList.get(i));
				}
			}


		} catch (Exception ee) {
			System.out.println(ee);
		}

	}

	public void SelectProduct( ProductMenu pm , int userType, String userName, int productType) {
		if(userType == 0)
		{
			Buyer buyer = new Buyer();
			buyer.showMenu(pm, userName,productType);
		}
		else if(userType == 1)
		{
			Seller seller = new Seller();
			seller.showMenu(pm, userName, productType);
		}
	}
	public void productOperation() {

	}
	public int getUserType() {
		return userType;
	}

	public String getUserName(String temp) {
		int Sep = temp.lastIndexOf(':');
		return temp.substring(0, Sep);
	}

	public String getProductName(String temp) {
		int Sep = temp.lastIndexOf(':');
		return temp.substring(Sep + 1, temp.length());
	}

	public void updateUserProduct(String name, String username)
	{
		BufferedReader file;
		try {
			FileWriter myWriter = new FileWriter("src/main/resources/UserProduct.txt", true);
			myWriter.write("\n"+ username + " : " + name);
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
			}
		 catch (Exception e) {
			System.out.println("Exception found while writing data to UserProduct");

		}

	}

	private Product findProductByProductName(String productname) {

		ProductIterator Iterator = new ProductIterator(theProductList);
		return (Product) Iterator.next(productname);
	}

}
