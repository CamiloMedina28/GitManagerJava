/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package camilo_medina.gitmanager.DBAdmin;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Camilo Medina
 */
public class CrearComando {
    public int InsertarComando(int com_id, 
                               String com_nombre, 
                               String com_sintaxis, 
                               String com_desc) 
                                throws ParametroInvalidoException{
        Boolean error;
        try {
            ConnectDB BDDConector = new ConnectDB();
            Connection conexion = BDDConector.ConectarDB();
            String CrearComando = "INSERT INTO Comando VALUES(?,?,?,?)";
            Map<String, String> Parametros = new HashMap<String, String>();
            Parametros.put("com_id", com_id+"");
            Parametros.put("com_nombre", com_nombre);
            Parametros.put("com_sintaxis", com_sintaxis);
            error = ComprobarParametros.ComprobarParametros(conexion, 
                                                            Parametros,
                                                            "Comando", 
                                                            false);
            if (error){
                throw new ParametroInvalidoException();
            }else{
                PreparedStatement PreComando = conexion.prepareStatement(CrearComando);
                PreComando.setInt(1, com_id);
                PreComando.setString(2, com_nombre);
                PreComando.setString(3, com_sintaxis);
                PreComando.setString(4, com_desc);
                PreComando.executeUpdate();
                BDDConector.CerrarConexion(conexion);
            }
        } catch (SQLException ex) {
            System.out.println("Error al mometo de crear el comando : "+
                                ex.getLocalizedMessage());
            return 1;
        }
        return 0;
    }
    
}
