import java.lang.Exception;
import java.util.Scanner;

public class Login  {

    Login(){}
    String[] details = new String[2];
    public boolean HasAccess() {
        boolean output = false;
        Scanner reader = new Scanner(System.in);
        System.out.println("Login Window :");
        System.out.println("Enter your username:");
        String username = reader.nextLine();
        System.out.println("Enter Password:");
        String password = reader.nextLine();
        String exactPassword = "";
        ReadConfig readConfig = new ReadConfig();
        try {
            details = readConfig.getPropValues(username);
            exactPassword = details[0];
        }
        catch(Exception e1){
            System.out.println(e1);
        }

        if (password.equals(exactPassword)) {
            if( details[1] == "Buyer")
            {
                output = true;

            }
            else if(details[1] == "Seller")
            {
                output = true;

            }

        } else {
            System.out.println("Please Enter Valid Username or Password");
        }

        return output;

    }

    public Integer GetUserType()
    {
        if(details[1] == "Buyer")
            return 0;
        else
            return 1;
    }


}