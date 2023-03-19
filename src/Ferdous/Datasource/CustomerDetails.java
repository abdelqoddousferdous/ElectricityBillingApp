package Ferdous.Datasource;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CustomerDetails extends JFrame implements ActionListener {


    JTable t1;
    JButton b1;
    String x[] = {"Customer Name","Meter Number","Address","City","State","Email","Phone"};
    String y[][] = new String[40][8];
    int i=0, j=0;
    CustomerDetails(){
        super("Customer Details");
        setSize(1200,650);
        setLocation(400,150);

        try{
            DataBase.getInstance().openDb();

            ResultSet res = DataBase.getInstance().customerQuery();
            while(res.next()){
                y[i][j++]=res.getString("name");
                y[i][j++]=res.getString("meter");
                y[i][j++]=res.getString("address");
                y[i][j++]=res.getString("city");
                y[i][j++]=res.getString("state");
                y[i][j++]=res.getString("email");
                y[i][j++]=res.getString("phone");
                i++;
                j=0;
            }
            t1 = new JTable(y,x);

        }catch(Exception e){
            e.printStackTrace();
        }


        b1 = new JButton("Print");
        add(b1,"South");
        JScrollPane sp = new JScrollPane(t1);
        add(sp);
        b1.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        try{
            t1.print();
        }catch(Exception e){}
    }

    public static void main(String[] args){
        new CustomerDetails().setVisible(true);
    }
}
