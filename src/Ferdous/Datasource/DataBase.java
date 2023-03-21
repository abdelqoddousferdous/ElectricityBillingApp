package Ferdous.Datasource;

import java.sql.*;

public class DataBase {

    private static  DataBase instance = new DataBase();
    private final String ConnectionUrl = "jdbc:sqlite:C:\\Users\\abdelFerdous\\IdeaProjects\\ElectricityBillingApp\\ElectricityBilling.db";
    private static Connection conn ;
    private static Statement statement;
    private static PreparedStatement preparedStatement ;
    private static String  prepareQuery = "SELECT * from login where username = ? and password = ? and user = ? ";
    private static String prepareBillQuery = "select * from bill where meter = ? AND month = ?";
    private static String prepareMeterInsertion = "INSERT INTO meter values( ? , ? , ? , ?)";
    private static String prepareBillInsertion = "insert into bill values( ? , ? , ? ,? , 'Not Paid')";

    private  static  String prepareCustomerUpdate = "UPDATE customer set address = ?, city = ? , state = ? , email = ? , phone = ? where meter = ?" ;


    public static final String Login_Table = " login ";
    public static final String Customer_Table = " customer ";
    public static final String MeterInfo_Table = " meter_info ";
    public static final String Tax_Table = " tax ";
    public static final String Bill_Table = " bill ";
    private ResultSet res ;


    public static DataBase getInstance(){
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

    public int metreInsertionQuery( String meter_number , String meter_location , String meter_type ,String phase_code ,String bill_type, String days){

        try {
            preparedStatement = conn.prepareStatement(prepareMeterInsertion);

            preparedStatement.setString(1, meter_number);
            preparedStatement.setString(2, meter_location);
            preparedStatement.setString(3, meter_type);
            preparedStatement.setString(4, phase_code);
            preparedStatement.setString(5, bill_type);
            preparedStatement.setString(6, days);

            int row = preparedStatement.executeUpdate();
            return row;

        }catch (SQLException e){
            e.printStackTrace();
            return -1 ;

        }

    }
    public int billInsertionQuery( String meter_number , String month , String unit ,int total_bill ){

        try {
            preparedStatement = conn.prepareStatement(prepareBillInsertion);

            preparedStatement.setString(1, meter_number);
            preparedStatement.setString(2, month);
            preparedStatement.setString(3, unit);
            preparedStatement.setString(4, ""+total_bill);


            int row = preparedStatement.executeUpdate();
            return row;

        }catch (SQLException e){
            e.printStackTrace();
            return -1 ;

        }

    }

    public ResultSet billQuery(){
        try{
            ResultSet res = statement.executeQuery("Select * from bill");
            return res ;
        }catch (SQLException e){
            return null ;
        }

    }
    public ResultSet billQuery(String meter , String month){
        try {
            preparedStatement = conn.prepareStatement(prepareBillQuery);
            preparedStatement.setString(1,meter);
            preparedStatement.setString(2, month);
            ResultSet res = preparedStatement.executeQuery();
            return res ;

        }catch (SQLException e){
            e.printStackTrace();
            return null ;

        }
    }
    public ResultSet customerQuery(){
     try {
         statement = conn.createStatement();
         ResultSet res = statement.executeQuery("SELECT * from customer");
         return res ;
     }catch (SQLException e){
         System.out.println(e.getMessage());
         return null ;
     }

    }
    public ResultSet customerQuery(String meter){
        try {
            preparedStatement = conn.prepareStatement("SELECT * from customer where meter = ?");
           preparedStatement.setString(1,meter);
            ResultSet res = preparedStatement.executeQuery();
            return res ;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return null ;
        }

    }
    public int customerUpdateQuery(String address , String city , String state , String email , String phone ,String meter){
        try {
            preparedStatement = conn.prepareStatement(prepareCustomerUpdate);
            preparedStatement.setString(1,address);
            preparedStatement.setString(2,city);
            preparedStatement.setString(3,state);
            preparedStatement.setString(4,email);
            preparedStatement.setString(5,phone);
            preparedStatement.setString(6,meter);

            int res = preparedStatement.executeUpdate();
            return res ;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return -1 ;
        }

    }

    public ResultSet queryTax(){
        try {
            statement = conn.createStatement();
            ResultSet res = statement.executeQuery("SELECT * from tax");
            return res ;
        }catch (SQLException e){
            e.printStackTrace();
            return null ;
        }

    }

    public ResultSet loginQuery(String username , String password , String accountType){
        try {
            preparedStatement = conn.prepareStatement(prepareQuery);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3,accountType);

            ResultSet res = preparedStatement.executeQuery();
                    //"and password = '" + password + "' and user = '" + accountType + "'");
           return res ;

        }catch (SQLException e){
            System.out.println("Error Login Query :"+ e.getMessage());
            return null;
        }

    }

    public boolean  signupQuery(String Query) {
        try {
            statement.execute(Query);
            return true;
        }catch (SQLException e){
            System.out.println("Error while registering :"+ e.getMessage());
            return false;
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
