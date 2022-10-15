import java.io.*;
import java.util.ArrayList;


public class ProduceProductMenu implements ProductMenu {

	ArrayList<String> produceProductList = new ArrayList<String>();
	public void showMenu()  {

		try {
			File file = new File("src/main/resources/ProductInfo.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));

			String st;
			while ((st = br.readLine()) != null) {
				if(st.startsWith("Produce"))
				{
					String value = st.replaceFirst("Produce:","");
					produceProductList.add(value);
				}
			}

			for(int i = 0; i< produceProductList.size(); i++)
				System.out.println(produceProductList.get(i));
		}
		catch ( Exception e)
		{
			System.out.println("File Not Found"+ e);
		}

	}

	public void showAddButton() {

	}

	@Override
	public void showViewButton() {

	}

	public void showRadioButton() {

	}

	public void showLabels() {

	}

	@Override
	public void showComboxes() {

	}

}
