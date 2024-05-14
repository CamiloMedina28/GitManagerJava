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
public class CrearParametro {
    public int InsertarParametro(int param_id, 
                                  String param_nombre, 
                                  String param_desc, 
                                  String param_sintaxis_larga, 
                                  String param_sintaxis_corta) throws ParametroInvalidoException{
         Boolean error;
        try {
            ConnectDB BDDConector = new ConnectDB();
            Connection conexion = BDDConector.ConectarDB();
            String CrearParametro = "INSERT INTO Parametro VALUES(?,?,?,?,?)";
            Map<String, String> Parametros = new HashMap<String, String>();
            Parametros.put("param_id", param_id+"");
            Parametros.put("param_nombre", param_nombre);
            Parametros.put("param_desc", param_desc);
            Parametros.put("param_sintaxis_larga", param_sintaxis_larga);
            Parametros.put("param_sintaxis_corta", param_sintaxis_corta);
            error = ComprobarParametros.ComprobarParametros(conexion, 
                                                            Parametros,
                                                            "Parametro", 
                                                            false);
            if (error){
                throw new ParametroInvalidoException();
            }else{
                PreparedStatement PreParametro = conexion.prepareStatement(CrearParametro);
                PreParametro.setInt(1, param_id);
                PreParametro.setString(2, param_nombre);
                PreParametro.setString(3, param_desc);
                PreParametro.setString(4, param_sintaxis_larga);
                PreParametro.setString(5, param_sintaxis_corta);
                PreParametro.executeUpdate();
                BDDConector.CerrarConexion(conexion);
                return 0;
            }
        }catch(SQLException ex){
            System.out.println("Error al mometo de crear el comando : "+
                                ex.getLocalizedMessage());
            return 1;
        }
    }
}
