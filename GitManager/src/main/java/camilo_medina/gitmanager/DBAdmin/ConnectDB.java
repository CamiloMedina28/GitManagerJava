/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package camilo_medina.gitmanager.DBAdmin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Camilo Medina
 */

public class ConnectDB {
    public Connection ConectarDB(){
        Connection Conexion = null;
        try{
            String PathToDB = "F:\\1. INGENIERIA DE SISTEMAS\\PROGRAMACIÓN JAVA\\GIT MANAGER\\comandos.db";
            Conexion = DriverManager.getConnection("jdbc:sqlite:"+PathToDB);
        }catch(SQLException error){
            System.out.println("Error de conexión con db: " + error.getLocalizedMessage());
        }finally{
            return Conexion;
        }
    }
    
    public void CerrarConexion(Connection conexion){
        try {
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la conexión con la base de datos"
                    + ex.getLocalizedMessage());
        }
    }
}
