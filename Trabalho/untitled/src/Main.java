import java.sql.*;

public class Trabalho {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/seu_banco_de_dados";
    static final String USER = "usuario";
    static final String PASS = "senha";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate("INSERT INTO sua_tabela (coluna1, coluna2, coluna3) VALUES ('valor1', 'valor2', 'valor3')");
            System.out.println("Registro inserido com sucesso.");

            stmt.executeUpdate("UPDATE sua_tabela SET coluna1 = 'novo_valor' WHERE coluna2 = 'valor2'");
            System.out.println("Registro atualizado com sucesso.");

            stmt.executeUpdate("DELETE FROM sua_tabela WHERE coluna3 = 'valor3'");
            System.out.println("Registro excluído com sucesso.");

            ResultSet rs = stmt.executeQuery("SELECT * FROM sua_tabela");

            while (rs.next()) {
                int id = rs.getInt("id");
                String coluna1 = rs.getString("coluna1");
                String coluna2 = rs.getString("coluna2");
                String coluna3 = rs.getString("coluna3");

                System.out.println("ID: " + id);
                System.out.println("Coluna1: " + coluna1);
                System.out.println("Coluna2: " + coluna2);
                System.out.println("Coluna3: " + coluna3);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}