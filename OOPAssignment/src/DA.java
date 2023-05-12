import java.sql.*;

public class DA {
    private Connection conn;

    public DA() {
        getConnection();
    }

    // Connect to the database
    public void getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to the database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/OOPAssignment", "root", "");
            System.out.println("You are now connected to the database");
        } catch (Exception ex) {
            System.out.println("Not connected");
        }
    }

    public void insertRecord(String username, String password) {

        try {
            System.out.println("Inserting data or records into table called javaLogin...");
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO javaLogin (username, password) VALUES(?,?)");
            stmt.setString(1,username);
            stmt.setString(2, password);
            int rows = stmt.executeUpdate();

            //System.out.println(rows + " rows inserted");
            System.out.println("User " + username +" registered successfully!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ResultSet readRecord(String username, String password){

        ResultSet rs = null;
        try{
            // Prepare a SELECT query to retrieve user data
            String sql = "SELECT * FROM javaLogin WHERE username=? AND password=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,username);
            stmt.setString(2, password);
            rs = stmt.executeQuery();

        } catch(SQLException e){
            System.out.println(e.getMessage());

        }
        return rs;
    }

    //Implement polymorphism
    public ResultSet readRecord(int id){
        ResultSet rs = null;
        try{
            // Prepare a SELECT query to retrieve user data
            String sql = "SELECT * FROM javaLogin WHERE CustomerID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,id);
            rs = stmt.executeQuery();

        } catch(SQLException e){
            System.out.println(e.getMessage());

        }
        return rs;
    }

//    public ResultSet getCustomerID(String username, String password){
//
//        ResultSet rs = null;
//
//        try{
//            String sql = "SELECT * FROM javaLogin WHERE username=? AND password=?";
//            PreparedStatement stmt = conn.prepareStatement(sql);
//            stmt.setString(1,username);
//            stmt.setString(2, password);
//            rs = stmt.executeQuery();
//        }catch(SQLException e) {
//            System.out.println(e.getMessage());
//
//        }
//        return rs;
//    }
}
