import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        try{
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\abdelFerdous\\IdeaProjects\\ElectricityBillingApp\\ElectricityBilling.db");
            Statement statement =conn.createStatement();
            statement.execute("Create Table if not exists login (meter_no TEXT , username TEXT , name TEXT , password TEXT , user TEXT) ");
            statement.execute("Create Table if not exists customer (name TEXT , meter TEXT , address TEXT , city TEXT , state TEXT , email TEXT, phone TEXT) ");
            statement.execute("Create Table if not exists meter_info (meter_number TEXT , meter_location TEXT , meter_type TEXT , phase_code TEXT , bill_type TEXT , days TEXT) ");
            statement.execute("Create Table if not exists tax (cost_per_unit TEXT , meter_rent TEXT , service_charge TEXT , service_tax TEXT , swacch_bharat_cess TEXT , fixed_tax TEXT) ");
            statement.execute("Create Table if not exists bill (meter TEXT , month TEXT , units TEXT , total_bill TEXT , status TEXT) ");
            statement.close();
            conn.close();

        }catch (SQLException e){

        }


    }
}