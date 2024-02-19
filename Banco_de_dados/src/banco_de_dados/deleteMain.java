package banco_de_dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class deleteMain {
public static void main(String[] args) {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection deleteConnection = DriverManager.getConnection("jdbc:mysql://localhost:1111/teste?user=root&password=1234");

        // Chamar o método deleteUser diretamente na classe deleteUser
        deleteMain.deleteUser(deleteConnection, 1); // Substitua 1 pelo id do usuário a ser excluído

        deleteConnection.close(); // Certifique-se de fechar a conexão após o uso
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
    }
}

public static void deleteUser(Connection delete, int id) {
    try {
        String deleteQuery = "DELETE FROM userName WHERE id = ?";
        try (PreparedStatement preparedStatement = delete.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Username deletado no banco de dados com sucesso.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}