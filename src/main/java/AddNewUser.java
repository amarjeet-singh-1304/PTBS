import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class AddNewUser {

    void AddDetailsToConfig(int type, String username, String password)
    {
        Properties props = new Properties();
        props.put(username, password);
        String path = "";
        if(type == 1)
        {
            path = "src/main/resources/SellerInfo.txt";

            }
        else if (type == 0) {
            path = "src/main/resources/BuyerInfo.txt";
        }
        try
        {
            System.out.println(username + password + path);
            File file = new File(path);
            FileInputStream fileIn = new FileInputStream(file);
            props.load(fileIn);
            System.out.println(fileIn);
            FileOutputStream outputStream = new FileOutputStream(path);
            System.out.println(outputStream);
            props.store(outputStream, "This is a sample properties file");
            outputStream.close();
        }
        catch (Exception e)
        {
            System.out.println("File not found");
        }


    }
}
