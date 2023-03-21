package Electricity;

import Ferdous.Datasource.DataBase;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class BillDetails extends JFrame{
 
    JTable t1;
    String x[] = {"Meter Number","Month","Units","Total Bill","Status"};
    String y[][] = new String[40][8];
    int i=0, j=0;
    BillDetails(String meter){
        super("Bill Details");
        setSize(700,650);
        setLocation(600,150);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        t1 = new JTable(y,x);
        
        try{
            DataBase.getInstance().openDb();
            ResultSet rs = DataBase.getInstance().billQuery(meter);
            t1.setModel(DbUtils.resultSetToTableModel(rs));
            DataBase.getInstance().closeDb();
            
        }catch(Exception e){
            e.printStackTrace();
            DataBase.getInstance().closeDb();

        }
        
        
        JScrollPane sp = new JScrollPane(t1);
        sp.setBounds(0, 0, 700, 650);
        add(sp);
        
    }
    
    public static void main(String[] args){
        new BillDetails("").setVisible(true);
    }
    
}
