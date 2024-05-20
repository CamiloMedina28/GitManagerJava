/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package camilo_medina.gitmanager.DBAdmin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Camilo Medina
 */
public class LeerComandos {
    public String[][] ListarComandos() throws ParametroInvalidoException{
        String SeleccionComandos = "Select * FROM Comando;";
        ConnectDB BDDConector = new ConnectDB();
        Connection conexion = BDDConector.ConectarDB();
        int numerocomandos = 0;
        try {
            Statement NumeroComandos = conexion.createStatement();
            ResultSet RSNumeroComandos = NumeroComandos.executeQuery("SELECT COUNT(*) FROM Comando;");
            if (RSNumeroComandos.next()){
                numerocomandos = RSNumeroComandos.getInt(1);
            }else{
                throw new ParametroInvalidoException();
            }
            Statement StatementComandos = conexion.createStatement();
            ResultSet Comandos = StatementComandos.executeQuery(SeleccionComandos);
            String[][] comandos = new String[numerocomandos][4];
            String[] columnas = {"com_id", "com_nombre", "com_sintaxis", "com_desc"};
            while (Comandos.next()){
                for(int i = 0; i < numerocomandos; i++){
                    for(int j = 0; j < 4; j++){
                        comandos[i][j] = Comandos.getString(columnas[j]);
                    }
                    Comandos.next();
                }
            }
            BDDConector.CerrarConexion(conexion);
            return comandos;
        } catch (SQLException ex) {
            System.out.println("Error al leer los comandos: " + 
                    ex.getLocalizedMessage());
            BDDConector.CerrarConexion(conexion);
            return null;
        } 
    }
    
    public String[][] ListarComandoConid(int id){
        String[][] comando = new String[3][4];
        ConnectDB BDDConector = new ConnectDB();
        Connection conexion = BDDConector.ConectarDB();
        String QuerySeleccionComando = "SELECT * FROM Comando WHERE com_id = " +
                id;
        try {
            Statement QueryPreparadoComando;
            QueryPreparadoComando = conexion.createStatement();
            ResultSet InformacionComando = QueryPreparadoComando.executeQuery(QuerySeleccionComando);
            
        } catch (SQLException ex) {
            System.out.println("Error al momento de obtener el comando: " + 
                    ex.getLocalizedMessage());
        }
        
        BDDConector.CerrarConexion(conexion);
        return comando;
    }
    
    public String ListarParametros(int id){
        ConnectDB BDDConector = new ConnectDB();
        Connection conexion = BDDConector.ConectarDB();
        String QuerySeleccionParametros = "SELECT * FROM Parametro INNER JOIN "
                + "ParametroComando ON ParametroComando.paramcom_com_id = "
                + "Parametro.param_id WHERE ParametroComando.paramcom_com_id = "
                + id;
        try {
            Statement QueryPreparadoParametro;
            QueryPreparadoParametro = conexion.createStatement();
            ResultSet InformacionParametros = QueryPreparadoParametro.executeQuery(QuerySeleccionParametros);
        
        } catch (SQLException ex){
            System.out.println("Error al momento de obtener los parámetros: "
                                + ex.getLocalizedMessage());
        }
        
        BDDConector.CerrarConexion(conexion);
        return "hola";
    }
    
    public String ListarContenido(int id){
        ConnectDB BDDConector = new ConnectDB();
        Connection conexion = BDDConector.ConectarDB();
        String QuerySeleccionContenido = "SELECT * FROM Contenido WHERE"
                + "con_param_id = " + id;
        
        BDDConector.CerrarConexion(conexion);
        return "hola";
    }
    
}
