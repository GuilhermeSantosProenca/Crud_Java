package banco_de_dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import banco_de_dados.deleteMain;

public class deleteTest {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            // Solicitar ID do usuário a ser deletado
            System.out.println("Delete user ID:");
            int userId = scanner.nextInt();

            // Estabelecer a conexão com o banco de dados
            Connection deleteConnection = DriverManager.getConnection("jdbc:mysql://localhost:1111/teste?user=root&password=1234");

            // Chamar o método deleteUser da classe DatabaseManager passando a conexão e o ID do usuário
            deleteMain.deleteUser(deleteConnection, userId);

            // Fechar o scanner e a conexão
            scanner.close();
            deleteConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
