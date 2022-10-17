import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class MeatProductMenu implements ProductMenu {

	public void showMenu() {
			ArrayList<String> meatProductList = new ArrayList<String>();
			try {
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
