public class PersonFactory extends  Person{

    PersonFactory(ProductMenu pm) {
        super(pm);
    }

    @Override
    public void showMenu( ProductMenu pm, String userName, int productType) {

    }

    @Override
    public ProductMenu CreateProductMenu() {
        return null;
    }

    //Function to create the user object and show reminder to each accordingly

    public static Person CreateUserObject(int usertype ) {
        Person person;
        System.out.println("Implementing Factory Method");
        if (usertype == 0) {
            person = new Buyer();
        }
        else
        {
            person = new Seller();
        }
        return person;
    }
}
