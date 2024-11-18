package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ConexionBD {

    Connection con;
    String driver = "com.mysql.cj.jdbc.Driver";
    String dbName = "finalpoo_tacotitos";
    String url = "jdbc:mysql://localhost:3306/" + dbName + "?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC"; // Url de base de datos
    String usuario = "root";
    String clave = "";

    /*** Establece una conexión a la base de datos utilizando los parámetros configurados* (URL, usuario y clave). 
     * Si la conexión es exitosa, retorna el objeto `Connection`.
     * Si ocurre un error, muestra un mensaje de error y termina la ejecución del programa.
     ** @return Un objeto `Connection` si la conexión es exitosa, o `null` si ocurre un error.
     * @throws SQLException Si ocurre un error al intentar establecer la conexión.
     */
    
    public Connection ConectarBaseDatos() throws SQLException {
        try {
            Connection con = DriverManager.getConnection(url, usuario, clave);
            System.out.println("Coneccion Correcta");
            return con;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "La Base de Datos no esta creada o existe algun error en ConexionBD.java", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return null;
    }
}

