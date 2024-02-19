package banco_de_dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import banco_de_dados.teste;

public class javaTest {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            // Solicitar nome de usuário
            System.out.println("Enter username:");
            String username = scanner.nextLine();

            // Exibir o nome de usuário
            System.out.println("Username is: " + username);

            // Estabelecer a conexão com o banco de dados
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:1111/teste?user=root&password=1234");

            // Chamar o método createUser da classe Teste passando a conexão e o nome de usuário
            teste.createUser(connection, username);

            scanner.close();
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
    }
}

