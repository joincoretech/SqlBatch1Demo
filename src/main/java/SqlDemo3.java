import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class SqlDemo3 {

    public static void main(String[] args) {
        String dbUrl="jdbc:mysql://72.167.125.79:3306/joincoretechhrm_db";
        String userName="joincorebatch1";
        String password="joincorebatch1@123";


        Connection connection=null;
        Statement statement;
        ResultSet resultSet=null;
        List<Map<String, String>> table= new ArrayList<>();

         Map <String , String > row;

        try {
            connection= DriverManager.getConnection(dbUrl,userName, password);
            statement=connection.createStatement();
            resultSet=statement.executeQuery("SELECT * FROM Person0;");
            ResultSetMetaData resultSetMetaData =resultSet.getMetaData();

            while (resultSet.next()){
                row=new LinkedHashMap<>();
                for (int i=1; i<= resultSetMetaData.getColumnCount(); i++){
                  row.put(resultSetMetaData.getColumnName(i), resultSet.getString(i));
                }
                table.add(row);
            }
            System.out.println(table);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
