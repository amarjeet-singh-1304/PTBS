import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class MeatProductMenu implements ProductMenu {

	public void showMenu() {
			ArrayList<String> meatProductList = new ArrayList<String>();
			try {
				System.out.println("Showing Meat Products Menu:");
				File file = new File("src/main/resources/ProductInfo.txt");
				BufferedReader br = new BufferedReader(new FileReader(file));

				String st;
				while ((st = br.readLine()) != null) {
					if(st.startsWith("Meat"))
					{
						String value = st.replaceFirst("Meat:","");
						meatProductList.add(value);
					}
				}

				for(int i = 0; i< meatProductList.size(); i++)
					System.out.println(meatProductList.get(i));
			}
			catch ( Exception e)
			{
				System.out.println("File Not Found"+ e);
			}


		}

	@Override
	public void selectProduct(int userType) {
		System.out.println("Meat Product Menu Selected:");
		Person person;
		if (userType == 0) {
			person = PersonFactory.CreateUserObject(0);

		} else
		{
			person = PersonFactory.CreateUserObject(1);

		}
		 new MeatProductMenu().showMenu();
	}

	/**
	 *  
	 */
	public void showAddButton() {

	}

	/**
	 *  
	 */
	public void showViewButton() {

	}

	/**
	 *  
	 */
	public void showRadioButton() {

	}

	/**
	 *  
	 */
	public void showLabels() {

	}

	/**
	 *  
	 */
	public void showComboxes() {

	}

}
