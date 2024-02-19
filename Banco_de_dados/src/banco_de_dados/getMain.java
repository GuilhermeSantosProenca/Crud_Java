package banco_de_dados;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class getMain {
public static void main(String[] args) {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection getConnection = DriverManager.getConnection("jdbc:mysql://localhost:1111/teste?user=root&password=1234");

        // Chamar o método deleteUser diretamente na classe deleteUser
        getMain.getUser(getConnection, 1); // Substitua 1 pelo id do usuário a ser excluído

        getConnection.close(); // Certifique-se de fechar a conexão após o uso
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
    }
}

public static void getUser(Connection get, int id) {
    try {
        String getQuery = "select username FROM userName WHERE id = ?";
        try (PreparedStatement preparedStatement = get.prepareStatement(getQuery)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String username = resultSet.getString("username");
                System.out.println("Nome de usuário: " + username);
            } else {
                System.out.println("Usuário não encontrado com o ID: " + id);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}
