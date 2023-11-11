import java.sql.*;

public class SqlDemo2 {

    public static void main(String[] args) {
        String dbUrl="jdbc:mysql://72.167.125.79:3306/joincoretechhrm_db";
        String userName="joincorebatch1";
        String password="joincorebatch1@123";


        Connection connection=null;
        Statement statement;
        ResultSet resultSet=null;

        try {
            connection= DriverManager.getConnection(dbUrl,userName, password);
            statement=connection.createStatement();
            resultSet=statement.executeQuery("SELECT * FROM Person0;");
            ResultSetMetaData resultSetMetaData =resultSet.getMetaData();
            for (int i=1; i<= resultSetMetaData.getColumnCount(); i++){

                System.out.print(resultSetMetaData.getColumnName(i)+" ");
            }
              System.out.println();
            while (resultSet.next()){
                System.out.print(resultSet.getString("id")+" ");
                System.out.print(resultSet.getString("firstname")+" ");
                System.out.print(resultSet.getString("lastname")+" ");
                System.out.print(resultSet.getString("age")+" ");
                System.out.print(resultSet.getString("city")+" ");
                System.out.println();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
