public class Reminder {

    void showReminder(ClassProductList productList)
    {
        ReminderVisitor visitor=new ReminderVisitor(this);
        visitor.visitFacade( new Facade());

    }

}
