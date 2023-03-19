package Ferdous.Datasource;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NewCustomer extends JFrame implements ActionListener {

    JLabel customerNameLabel, meterLabel, addressLabel, stateLabel, cityLabel, emailLabel, phoneLabel,l8, l11;
    JTextField customerNameTextField,t2, addressTextField,t4,t5,t6,t7;
    JButton b1,b2;
    NewCustomer(){
        setLocation(600,200);
        setSize(700,500);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        panel.setBackground(new Color(173,216,230));

        JLabel title = new JLabel("New Customer");
        title.setBounds(180, 10, 200, 26);
        title.setFont(new Font("Tahoma", Font.PLAIN, 24));
        panel.add(title);

        customerNameLabel = new JLabel("Customer Name");
        customerNameLabel.setBounds(100, 80, 100, 20);

        customerNameTextField = new JTextField();
        customerNameTextField.setBounds(240, 80, 200, 20);
        panel.add(customerNameLabel);
        panel.add(customerNameTextField);

        meterLabel = new JLabel("Meter No");
        meterLabel.setBounds(100, 120, 100, 20);
        l11 = new JLabel();
        l11.setBounds(240, 120, 200, 20);
        panel.add(meterLabel);
        panel.add(l11);

        addressLabel = new JLabel("Address");
        addressLabel.setBounds(100, 160, 100, 20);
        addressTextField = new JTextField();
        addressTextField.setBounds(240, 160, 200, 20);
        panel.add(addressLabel);
        panel.add(addressTextField);
        cityLabel = new JLabel("City");
        cityLabel.setBounds(100, 200, 100, 20);
        t5 = new JTextField();
        t5.setBounds(240, 200, 200, 20);
        panel.add(cityLabel);
        panel.add(t5);
        stateLabel = new JLabel("State");
        stateLabel.setBounds(100, 240, 100, 20);
        t4 = new JTextField();
        t4.setBounds(240, 240, 200, 20);
        panel.add(stateLabel);
        panel.add(t4);

        emailLabel = new JLabel("Email");
        emailLabel.setBounds(100, 280, 100, 20);
        t6 = new JTextField();
        t6.setBounds(240, 280, 200, 20);
        panel.add(emailLabel);
        panel.add(t6);
        phoneLabel = new JLabel("Phone Number");
        phoneLabel.setBounds(100, 320, 100, 20);
        t7 = new JTextField();
        t7.setBounds(240, 320, 200, 20);
        panel.add(phoneLabel);
        panel.add(t7);

        b1 = new JButton("Next");
        b1.setBounds(120, 390, 100, 25);
        b2 = new JButton("Cancel");
        b2.setBounds(250, 390, 100, 25);

        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        panel.add(b1);
        panel.add(b2);
        setLayout(new BorderLayout());

        add(panel,"Center");

        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("Ferdous\\Graphics\\hicon1.jpg"));
        Image i3 = ic1.getImage().getScaledInstance(150, 300,Image.SCALE_DEFAULT);
        ImageIcon ic2 = new ImageIcon(i3);
        l8 = new JLabel(ic2);


        add(l8,"West");
        //for changing the color of the whole Frame
        getContentPane().setBackground(Color.WHITE);

        b1.addActionListener(this);
        b2.addActionListener(this);

        Random ran = new Random();
        long first = (ran.nextLong() % 1000000);
        l11.setText(""+Math.abs(first));

    }

    @Override
    public void actionPerformed(ActionEvent e) {


    }

    public static void main(String[] args) {
        new NewCustomer().setVisible(true);

        
    }
}
