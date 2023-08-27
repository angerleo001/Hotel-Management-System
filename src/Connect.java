//Contact me on instagram : angerleo001
import java.sql.*;

public class Connect {
    Connection c;
    Statement s;
    public Connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelaps", "root" , "@ngerleo001");
            s = c.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] arg){

    }
}
