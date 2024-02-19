package banco_de_dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import banco_de_dados.updateMain;

public class updateTest {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            // Solicitar ID do usuário a ser alterado
            System.out.println("ID do usuário que vai ser alterado:");
            int userId = scanner.nextInt();

            // Solicitar novo nome de usuário
            System.out.println("Novo nome de usuário:");
            String newUsername = scanner.next();

            // Estabelecer a conexão com o banco de dados
            Connection updateConnection = DriverManager.getConnection("jdbc:mysql://localhost:1111/teste?user=root&password=1234");

            // Chamar o método updateUser da classe updateMain passando a conexão, o ID do usuário e o novo nome de usuário
            updateMain.updateUser(updateConnection, userId, newUsername);

            // Fechar o scanner e a conexão
            scanner.close();
            updateConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}





