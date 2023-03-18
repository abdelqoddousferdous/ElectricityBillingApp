package Ferdous.Datasource;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class About extends JFrame implements ActionListener {

    JButton button1 ;
    JLabel labelAbout ;
    Font f , f1 , f2 ;
    TextArea textArea ;
    String aboutText ;

    About(){
        setLayout(null);
        button1 = new JButton("Exit");
        add(button1);
        button1.setBounds(180 , 430 , 120 , 20);
        button1.addActionListener(this);
        f= new Font("RALEWAY" , Font.BOLD , 180);
        setFont(f);
        aboutText = "Lorem Ipsum is simply dummy text of the printing and typesetting industry \n" +
                ". Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,\n" +
                " when an unknown printer took a galley of type and scrambled it to make a type specimen book.\n";
        textArea = new TextArea(aboutText , 10 , 40 , Scrollbar.VERTICAL);
        textArea.setEditable(false);
        textArea.setBounds(20 , 100 , 450 , 300);
        add(textArea);
        f1 = new Font("RALEWAY" , Font.BOLD , 16);
        textArea.setFont(f1);

        Container container = this.getContentPane();
        textArea = new TextArea();
        labelAbout = new JLabel("ABOUT THE APP");
        add(labelAbout);
        labelAbout.setBounds(170 , 10 , 180 , 80);
        labelAbout.setForeground(Color.RED);

        f2 = new Font("RALEWAY" , Font.BOLD , 20);
        labelAbout.setFont(f2);

        setBounds(700 , 220 , 500 , 550 );
        setLayout(null);
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
      
        dispose();
      //System.exit(0);
    }

    public static void main(String[] args) {
        new About().setVisible(true);
    }
}
