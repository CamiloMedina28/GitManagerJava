/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package camilo_medina.gitmanager.DBAdmin;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Camilo Medina
 */
public class DropTables {
    public int DropTables(String[] NombresTablas){
        ConnectDB BDDConector = new ConnectDB();
        Connection conexion = BDDConector.ConectarDB();
        for(String i: NombresTablas){
            String Consulta = "DROP TABLE IF EXISTS ";
            try {
                Consulta += i;
                PreparedStatement DropSentence = conexion.prepareStatement(Consulta);
                DropSentence.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("No fue posible la eliminación de las tablas"
                                    + ex.getLocalizedMessage());
                BDDConector.CerrarConexion(conexion);
                return 1;
            }
        }
        BDDConector.CerrarConexion(conexion);
        return 0; 
    }
}
