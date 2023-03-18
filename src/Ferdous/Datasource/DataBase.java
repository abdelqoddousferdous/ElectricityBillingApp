package Ferdous.Datasource;

import java.sql.*;

public class DataBase {

    private static  DataBase instance ;
    private final String ConnectionUrl = "jdbc:sqlite:C:\\Users\\abdelFerdous\\IdeaProjects\\ElectricityBillingApp\\ElectricityBilling.db";
    private static Connection conn ;
    private static Statement statement;

    public static final String Login_Table = " login ";
    public static final String Customer_Table = " customer ";
    public static final String MeterInfo_Table = " meter_info ";
    public static final String Tax_Table = " tax ";
    public static final String Bill_Table = " bill ";
    private ResultSet res ;
    private DataBase(){}

    public DataBase getInstance(){
        return instance ;
    }

    public boolean openDb(){
        try {
            conn = DriverManager.getConnection(ConnectionUrl);
            statement= conn.createStatement();
            return true ;

        }catch (SQLException e){
            System.out.println("Error opening the Database :"+e.getMessage());
            return false ;
        }

    }

    public  void closeDb(){
        try {
            if (res != null) {
              res.close();
            }
            if (statement != null) {
                statement.close();
            }
            if(conn != null){
                conn.close();
            }

        }catch (SQLException e){
            System.out.println("Error closing Database :"+e.getMessage());
        }

    }


}
