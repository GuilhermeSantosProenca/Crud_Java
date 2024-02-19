package banco_de_dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import banco_de_dados.getMain;

public class getTeste {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            // Solicitar ID do usuário a ser deletado
            System.out.println("Get user ID:");
            int id = scanner.nextInt();

            // Estabelecer a conexão com o banco de dados
            Connection getConnection = DriverManager.getConnection("jdbc:mysql://localhost:1111/teste?user=root&password=1234");

            // Chamar o método deleteUser da classe DatabaseManager passando a conexão e o ID do usuário
            getMain.getUser(getConnection, id);

            // Fechar o scanner e a conexão
            scanner.close();
            getConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
