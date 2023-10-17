package justforpractice;

import java.sql.*;

public class PracticeSQL {
    public static void main(String[] args) {
        //jdbc is mandatory
        String url = "jdbc:mysql://3.249.240.23:3306/bekturyusupov";
        String user = "bekturyusupov";
        String password = "vgumikdgalsdkuec";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Establish connection
            connection = DriverManager.getConnection(url, user, password);
            //System.out.println("Connected to the database.");

            statement = connection.createStatement();

            //save it in an SQL Custom object
            resultSet = statement.executeQuery("select * from users");

            //result set returns a list of all rows
            resultSet.next();
            System.out.println(resultSet.getString("username"));

            resultSet.next();
            System.out.println(resultSet.getInt("profile_id"));

            while(resultSet.next()){
                System.out.println(resultSet.getString("username"));
            }

            int rowsAffected = statement.executeUpdate("UPDATE user_profile SET country = 'US' WHERE id=123");
            System.out.println(rowsAffected);
            System.out.println(rowsAffected);

            resultSet = statement.executeQuery("select * from user_profile");
            while(resultSet.next()){
                System.out.println(resultSet.getString("country"));
            }

            connection.close();
        } catch (ClassNotFoundException | SQLException e ) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
                statement.close();
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
