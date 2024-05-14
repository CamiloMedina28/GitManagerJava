/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package camilo_medina.gitmanager.DBAdmin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
            return comandos;
        } catch (SQLException ex) {
            System.out.println("Error al leer los comandos: " + 
                    ex.getLocalizedMessage());
            return null;
        } 
    }
    
}
