/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package camilo_medina.gitmanager.DBAdmin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Camilo Medina
 */
public class AsociarParametosComandos {
    public int AsociacionParamCom(int com_id, int param_id) throws ParametroInvalidoException{
        Boolean error;
        try {
            ConnectDB BDDConector = new ConnectDB();
            Connection conexion = BDDConector.ConectarDB();
            String CrearParamCom = "INSERT INTO ParametroComando VALUES(?,?)";
            Map<String, String> Parametros = new HashMap<String, String>();
            Parametros.put("paramcom_com_id", com_id+"");
            Parametros.put("paramcom_param_id", param_id+"");
            error = ComprobarParametros.ComprobarParametros(conexion, 
                                                            Parametros,
                                                            "ParametroComando", 
                                                            true);
            if (error){
                throw new ParametroInvalidoException();
            }else{
                PreparedStatement PreParametroComando = conexion.prepareStatement(CrearParamCom);
                PreParametroComando.setInt(1, com_id);
                PreParametroComando.setInt(2, param_id);
                PreParametroComando.executeUpdate();
                BDDConector.CerrarConexion(conexion);
            }
        }catch (SQLException ex) {
            System.out.println("Error al mometo de crear el comando : "+
                                ex.getLocalizedMessage());
            return 1;
        }
        return 0;
    }
    
}
