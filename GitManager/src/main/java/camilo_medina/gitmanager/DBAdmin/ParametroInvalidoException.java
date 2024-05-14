/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package camilo_medina.gitmanager.DBAdmin;

/**
 *
 * @author Camilo Medina
 */
public class ParametroInvalidoException extends Exception {
    public ParametroInvalidoException(){
        super("Uno de los parámetros ingresados no es válido"
                + "Tal vez, ya existe en la base de datos.");
    }

    
}
