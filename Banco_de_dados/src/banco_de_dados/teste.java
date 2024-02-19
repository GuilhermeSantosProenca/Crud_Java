 package banco_de_dados;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class teste  { 
	
	// static String url = "jdbc:mysql://localhost:1111/teste";
	// static String user = "root";
	// static String password = "1234";
	
	public static void main(String [] args) throws ClassNotFoundException, SQLException {	
	Class.forName("com.mysql.cj.jdbc.Driver");
Connection connection = DriverManager.getConnection("jdbc:mysql:localhost:1111/teste?user=root&password=1234");}

public static void createUser(Connection connection, String username) {
    try {
        String insertQuery = "INSERT INTO userName (username) VALUES (?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, username);
            preparedStatement.executeUpdate();
            System.out.println("Username inserido no banco de dados com sucesso.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}

