/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package camilo_medina.gitmanager.DBAdmin;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;

/**
 *
 * @author Camilo Medina
 */
public class CreateComando {
    public int crearComando(){
        
        String QueryCrearComando = "INSERT INTO Comando(com_nombre, com_sintaxis, com_desc) "
                + "VALUES(?,?,?)";
        
        
        return 0;
    }
    
}
