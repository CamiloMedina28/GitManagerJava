/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package camilo_medina.gitmanager.DBAdmin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;


/**
 *
 * @author Camilo Medina
 */
public class ComprobarParametros {
    public static boolean ComprobarParametros(Connection conexion, 
                                              Map Parametros, 
                                              String NombreTabla, 
                                              Boolean pk){
        String Querycomprobar = "SELECT * FROM ? WHERE ";
        Iterator it_map = Parametros.keySet().iterator();
        while(it_map.hasNext()){
            String key = (String) it_map.next();
            String value = (String) Parametros.get(key); 
            if (pk){
                Querycomprobar += (key + " = ? AND ");
            }else{
                Querycomprobar += (key + " = ? OR ");
            }
        }
        if (pk){
            Querycomprobar = Querycomprobar.replaceAll("AND $", "");
        }else{
            Querycomprobar = Querycomprobar.replaceAll("OR $", "");
        }
        Querycomprobar = Querycomprobar.replaceFirst("\\?", NombreTabla);
        try {
            PreparedStatement ComprobarParametros = conexion.prepareStatement(Querycomprobar);
            Iterator ItMapParameters = Parametros.keySet().iterator();
            int Contador = 1;
            while(ItMapParameters.hasNext()){
                String key = (String) ItMapParameters.next();
                String value = (String) Parametros.get(key); 
                ComprobarParametros.setString(Contador, value);
                Contador += 1;
            }
            ResultSet RSComprobarParametros = ComprobarParametros.executeQuery();
            if (RSComprobarParametros.next() ){
                return true;
            }
            return false;
        } catch (SQLException ex) {
            System.out.println("errorr al comprobar los parámetros dados" + 
                    ex.getLocalizedMessage());
            return true;
        }
    }
}
