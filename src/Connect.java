import java.sql.*;

public class Connect {
    Connection c;
    public Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager;
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] arg){

    }
}
