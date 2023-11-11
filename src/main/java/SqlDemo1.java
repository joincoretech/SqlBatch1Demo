import java.sql.*;

public class SqlDemo1 {

    public static void main(String[] args) {

        String dbUrl="jdbc:mysql://72.167.125.79:3306/joincoretechhrm_db";
        String userName="joincorebatch1";
        String password="joincorebatch1@123";

        try {
            Connection connection= DriverManager.getConnection(dbUrl,userName,password);
            Statement statement= connection.createStatement();
            ResultSet resultSet=statement.executeQuery("Select firstname, lastname from employee;");
             while (resultSet.next()){
                 String firstName=resultSet.getString("firstname");
                 String lastName = resultSet.getString("lastname");
                 System.out.println(firstName+" "+lastName);
             }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
