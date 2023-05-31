import Controlador.Conexion.Controlador.Login;
import Controlador.Conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
    private Connection connection;

    public LoginDAO() throws SQLException {
        // Realiza la conexión a la base de datos utilizando la clase conexion
        connection = new conexion().conectar();
    }

    public boolean validarCredenciales(Login login) {
        String query = "SELECT * FROM usuarios WHERE username = ? AND password = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, login.getUsername());
            statement.setString(2, login.getPassword());
            
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next(); // Devuelve true si existe un registro con las credenciales proporcionadas
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

