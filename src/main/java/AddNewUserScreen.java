import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddNewUserScreen extends JFrame implements ActionListener {

    Container container = getContentPane();

    JLabel userTypeLabel = new JLabel("Select the type of User:");
    JLabel userLabel = new JLabel("Enter Username");
    JLabel passwordLabel = new JLabel("Enter Passoword");

    JRadioButton userType0 = new JRadioButton("Buyer");
    JRadioButton userType1 = new JRadioButton("Seller");
    JTextField userNameField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton submitButton = new JButton("Submit");

    ButtonGroup bg=new ButtonGroup();

    int k = 2;

    AddNewUserScreen() {
        bg.add(userType0);
        bg.add(userType1);
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();

    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        userTypeLabel.setBounds(50, 100, 200,30 );
        userLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 220, 100, 30);
        userType0.setBounds(230, 100, 70, 30);
        userType1.setBounds(300,100,70,30);
        userNameField.setBounds(230, 150, 150, 30);
        passwordField.setBounds(230, 220, 150, 30);
        submitButton.setBounds(50, 300, 100, 30);

    }

    public void addComponentsToContainer() {
        container.add(userTypeLabel);
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userType0);
        container.add(userType1);
        container.add(userNameField);
        container.add(passwordField);
        container.add(submitButton);

    }

    public void addActionEvent() {

        submitButton.addActionListener(this);
        userType0.addActionListener(this);
        userType1.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of LOGIN button
        if(userType0.isSelected()){
            k = 0;
            //JOptionPane.showMessageDialog(this,"You are Buyer.");
        }
        if(userType1.isSelected()){
            k =1;
        }

        if (e.getSource() == submitButton) {
            String userText;
            String pwdText;
            userText = userNameField.getText();
            pwdText = passwordField.getText();
            AddNewUser addNewUser = new AddNewUser();
            Facade facade = new Facade();
            if(k == 0)
            {
                addNewUser.AddDetailsToConfig(0, userText, pwdText);
                facade.login();

            }
            else if(k == 1)
            {
                addNewUser.AddDetailsToConfig(1,userText,pwdText);
                facade.login();


            }
            else
            {
                JOptionPane.showMessageDialog(this, "Please select user type");
            }


        }


    }

}

