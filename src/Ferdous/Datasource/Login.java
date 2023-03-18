package Ferdous.Datasource;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {

    JLabel usernameLabel , passwordLabel , label3 , label4 ;
    JTextField textField ;
    JPasswordField passwordField ;
    JButton loginButton , cancelButton , signupButton ;
    JPanel p1 ,p2 , p3 , p4 ;
    Choice choice ;

    Login(){
        super("Login Page");
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(300 , 20 , 100 ,20);
        add(usernameLabel);
        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(300 , 60 , 100 , 20);
        add(passwordLabel);

        textField = new JTextField(15);
        textField.setBounds(400 , 20 , 150 , 20);
        add(textField);

        passwordField = new JPasswordField(15);
        passwordField.setBounds(400 , 60 , 150 , 20);
        add(passwordField);

        label3 = new JLabel("Login as :");
        label3.setBounds(300 , 100 , 100 , 20);
        add(label3);

        choice = new Choice();
        choice.addItem("Admin");
        choice.addItem("Customer");
        choice.setBounds(400 , 100 ,150 , 20);
        add(choice);

        ImageIcon loginIcon = new ImageIcon(ClassLoader.getSystemResource("Ferdous\\Graphics\\login.png"));
        Image image = loginIcon.getImage().getScaledInstance(16 ,16 , Image.SCALE_DEFAULT);
        loginButton = new JButton("Login" , new ImageIcon(image));
        loginButton.setBounds(330 , 160 , 100 , 20);
        add(loginButton);

        ImageIcon cancelIcon = new ImageIcon(ClassLoader.getSystemResource("Ferdous\\Graphics\\cancel.jpg"));
        image = cancelIcon.getImage().getScaledInstance(16 ,16 , Image.SCALE_DEFAULT);
        cancelButton = new JButton("Cancel" , new ImageIcon(image));
        cancelButton.setBounds(450, 160 , 100 , 20);
        add(cancelButton);

        ImageIcon signupIcon = new ImageIcon(ClassLoader.getSystemResource("Ferdous\\Graphics\\signup.png"));
         image = signupIcon.getImage().getScaledInstance(16 ,16 , Image.SCALE_DEFAULT);
        signupButton = new JButton("Sign up" , new ImageIcon(image));
        signupButton.setBounds(380 , 200 , 130 , 20);
        add(signupButton);

        loginButton.addActionListener(this);
        cancelButton.addActionListener(this);
        signupButton.addActionListener(this);

        setLayout(new BorderLayout());

        setSize(640 , 300 );
        setLocation(600 , 300);
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new Login().setVisible(true);
    }
}
