/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package camilo_medina.gitmanager.DBAdmin;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author Camilo Medina
 */
public class CreateDB {
    public int crear_tabla(){
        ConnectDB BDDConector = new ConnectDB();
        Connection conexion = BDDConector.ConectarDB();
        String CrearComando = "CREATE TABLE IF NOT EXISTS Comando (" +
                              "com_id INTEGER PRIMARY KEY NOT NULL," +
                              "com_nombre VARCHAR(45) NOT NULL," +
                              "com_sintaxis VARCHAR(45) NOT NULL," +
                              "com_desc MEDIUMTEXT NOT NULL);";
        
        String CrearParametros = "CREATE TABLE IF NOT EXISTS Parametro(" +
                                 "param_id INTEGER PRIMARY KEY NOT NULL," +
                                 "param_nombre VARCHAR(45) NOT NULL," + 
                                 "param_desc MEDIUMTEXT NOT NULL," +    
                                 "param_sintaxis_larga VARCHAR(45) NULL," + 
                                 "param_sintaxis_corta VARCHAR(45) NULL);";
        
        String CrearContenido = "CREATE TABLE IF NOT EXISTS Contenido(" +
                                "con_param_id INTEGER PRIMARY KEY NOT NULL," +
                                "con_info_necesaria VARCHAR(45) NOT NULL," +
                                "con_tipo VARCHAR(45) NOT NULL,"
                                + "con_select VARCHAR(100) NULL," +
                                "FOREIGN KEY(con_param_id) references PARAMETRO(param_id));";
        
        String CrearParametroComando = "CREATE TABLE IF NOT EXISTS ParametroComando(" +
                                        "paramcom_com_id INTEGER NOT NULL," + 
                                        "paramcom_param_id INTEGER NOT NULL," + 
                                        "FOREIGN KEY(paramcom_com_id) REFERENCES Comando(com_id)," + 
                                        "FOREIGN KEY(paramcom_param_id) REFERENCES Parametro(param_id)," +
                                        "PRIMARY KEY(paramcom_com_id, paramcom_param_id));";
        
        
        try {
            Statement stm = conexion.createStatement();
            stm.executeUpdate(CrearComando);
            stm.executeUpdate(CrearParametros);
            stm.executeUpdate(CrearContenido);
            stm.executeUpdate(CrearParametroComando);
            BDDConector.CerrarConexion(conexion);
            return 0;
        } catch (SQLException error) {
            System.out.println("Error fatal: " + error.getLocalizedMessage());
            BDDConector.CerrarConexion(conexion);
            return 1;
        }
    }
}
