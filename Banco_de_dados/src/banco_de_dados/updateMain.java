package banco_de_dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class updateMain {
public static void main(String[] args) {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection updateConnection = DriverManager.getConnection("jdbc:mysql://localhost:1111/teste?user=root&password=1234");

        // Chamar o método deleteUser diretamente na classe deleteUser
        updateMain.updateUser(updateConnection, 1, "bbb"); // Substitua 1 pelo id do usuário a ser excluído

        updateConnection.close(); // Certifique-se de fechar a conexão após o uso
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
    }
}

public static void updateUser(Connection update, int id, String newUsername) {
    try { 
        String updateQuery = "UPDATE userName SET username = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = update.prepareStatement(updateQuery)) {
            preparedStatement.setString(1, newUsername);
            preparedStatement.setInt(2, id);
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(rowsAffected + " linhas atualizadas no banco de dados.");
            System.out.println("Username alterado no banco de dados com sucesso.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}
