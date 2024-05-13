/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package camilo_medina.gitmanager.DBAdmin;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Camilo Medina
 */
public class ExecuteCommandsDB {
    public void ListCommands(){
        Boolean SeleccionarOpciones = true;
        while (SeleccionarOpciones){
            System.out.println("Para crear las tablas envie 1");
            System.out.println("Para eliminar las tablas envie 2");
            System.out.println("Para salir presione ENTER");
            System.out.print("Ingrese su opción: ");
            Scanner escaner = new Scanner(System.in);
            String UserAction = escaner.nextLine(); 
            if (UserAction == ""){
                break;
            }
            int Accion = 0;
            try{
                Accion = Integer.parseInt(UserAction);
            }catch (NumberFormatException error){
                System.out.println("Error en el input: " + error.getLocalizedMessage());
                continue;
            }
            if (Accion == 1){
                CreateDB creacion = new CreateDB();
                creacion.crear_tabla();
                SeleccionarOpciones = false;    
            }else if (Accion == 2){
                DropTables eliminar = new DropTables();
                System.out.println("Ingrese los nombres de las tablas separados por comas");
                System.out.print("Nombres: ");
                String TablasString = escaner.nextLine();
                String [] tablas = TablasString.split(",");
                eliminar.DropTables(tablas);
            }
        }    
        
    }
    
}


