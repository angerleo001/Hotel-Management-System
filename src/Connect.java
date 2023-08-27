public class Connect {
    public Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] arg){

    }
}
