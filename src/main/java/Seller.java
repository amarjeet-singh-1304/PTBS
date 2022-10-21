import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

public class Seller extends Person {

	Properties props = new Properties();
	ArrayList<Offering> al = new ArrayList<Offering>();
	Seller(){
		super(theProductMenu);
	}

	Seller( ProductMenu pm){
		super(pm);
	}
	public void showMenu(ProductMenu theProductMenu, String userName, int productType) {
		System.out.println("Showing Menu:");
		theProductMenu.showMenu();
		addOfferings(userName);

	}

	@Override
	public ProductMenu CreateProductMenu() {

		return null;
	}

	public void addOfferings(String userName){

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter name from above you want to Offer:");
		String product = scanner.nextLine();
		Offering offering = new Offering();
		offering.setName(userName);
		offering.setProductName(product);
		//al.add(offering);
		writeOfferingToConfig(offering);

	}
	// Function to write offerings in a file for the buyers
	public void writeOfferingToConfig( Offering o)
	{


		File file = new File("src/main/resources/Offerings.txt");
		try{
			FileInputStream fileIn = new FileInputStream(file);
			props.load(fileIn);
			String value = props.getProperty(o.getName());
			if(value == null)
				props.setProperty(o.getName(), o.getProductName());
			else
				props.setProperty(o.getName(), value + "," + o.getProductName());

			fileIn.close();
			FileOutputStream outputStream = new FileOutputStream(file);

			System.out.println(props);
			props.store(outputStream, null);
			outputStream.flush();
			outputStream.close();

			FileWriter myWriter = new FileWriter("src/main/resources/UserProduct.txt", true);
			myWriter.write("\n" + o.getName() + " : " + o.getProductName());
			myWriter.close();
			System.out.println("Successfully wrote to the file.");

		}
		catch (Exception e)
		{
			System.out.println("Exception caught:" + e.getMessage());
		}


	}

}
