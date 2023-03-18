package Ferdous.Datasource;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Signup extends JFrame implements ActionListener {

    JPanel panel;
    JTextField usernameTextField, nameTextField, passwordTextField, meterTextField;
    Choice choice;
    JButton registerButton, backButton;
    Signup(){
        setBounds(600, 250, 700, 400);

        panel = new JPanel();
        panel.setBounds(30, 30, 650, 300);
        panel.setLayout( null);
        panel.setBackground(Color.WHITE);
        panel.setForeground(new Color(34, 139, 34));
        panel.setBorder(new TitledBorder(new LineBorder(new Color(173, 216, 230), 2), "Create-Account", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(173, 216, 230)));
        add(panel);

        JLabel l1 = new JLabel("Username");
        l1.setForeground(Color.DARK_GRAY);
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        l1.setBounds(100, 50, 100, 20);
        panel.add(l1);

        usernameTextField = new JTextField();
        usernameTextField.setBounds(260, 50, 150, 20);
        panel.add(usernameTextField);

        JLabel l2 = new JLabel("Name");
        l2.setForeground(Color.DARK_GRAY);
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        l2.setBounds(100, 90, 100, 20);
        panel.add(l2);

        nameTextField = new JTextField();
        nameTextField.setBounds(260, 90, 150, 20);
        panel.add(nameTextField);


        JLabel l3 = new JLabel("Password");
        l3.setForeground(Color.DARK_GRAY);
        l3.setFont(new Font("Tahoma", Font.BOLD, 14));
        l3.setBounds(100, 130, 100, 20);
        panel.add(l3);

        passwordTextField = new JTextField();
        passwordTextField.setBounds(260, 130, 150, 20);
        panel.add(passwordTextField);


        JLabel l4 = new JLabel("Create Account As");
        l4.setForeground(Color.DARK_GRAY);
        l4.setFont(new Font("Tahoma", Font.BOLD, 14));
        l4.setBounds(100, 170, 140, 20);
        panel.add(l4);


        JLabel l5 = new JLabel("Meter Number");
        l5.setForeground(Color.DARK_GRAY);
        l5.setFont(new Font("Tahoma", Font.BOLD, 14));
        l5.setBounds(100, 210, 100, 20);
        l5.setVisible(false);
        panel.add(l5);

        meterTextField = new JTextField();
        meterTextField.setBounds(260, 210, 150, 20);
        meterTextField.setVisible(false);
        panel.add(meterTextField);

        choice = new Choice();
        choice.add("Admin");
        choice.add("Customer");
        choice.setBounds(260, 170, 150, 20);
        panel.add(choice);

        choice.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ae){
                String user = choice.getSelectedItem();
                if(user.equals("Customer")){
                    l5.setVisible(true);
                    meterTextField.setVisible(true);
                }else{
                    l5.setVisible(false);
                    meterTextField.setVisible(false);
                }
            }
        });


        registerButton = new JButton("Create");
        registerButton.setBackground(Color.BLACK);
        registerButton.setForeground(Color.WHITE);
        registerButton.setBounds(140, 290, 120, 30);
        registerButton.addActionListener(this);
        panel.add(registerButton);

        backButton = new JButton("Back");
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.setBounds(300, 290, 120, 30);
        backButton.addActionListener(this);
        panel.add(backButton);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Ferdous\\Graphics\\signupImage.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l6 = new JLabel(i3);
        l6.setBounds(450, 30, 250, 250);
        panel.add(l6);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new Signup().setVisible(true);
    }
}
