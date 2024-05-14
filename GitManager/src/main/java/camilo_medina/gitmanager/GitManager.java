/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package camilo_medina.gitmanager;
import camilo_medina.gitmanager.GUI.MainView;
import camilo_medina.gitmanager.DBAdmin.ExecuteCommandsDB;
import java.util.Scanner;

/**
 *
 * @author Camilo Medina
 */
public class GitManager {
    public static void main(String[] args) throws NumberFormatException{
        Boolean SelectAction = true;
        Scanner escaner = new Scanner(System.in);
        
        while(SelectAction){  
            System.out.println("Ingrese un cero para alterar la base se datos");
            System.out.println("Ingrese un uno para ingresar a la interfáz gráfica");
            System.out.println("Presione enter para salir");
            System.out.print("Ingrese su opción: ");
            String UserAction = escaner.nextLine();
            if (UserAction == ""){
                SelectAction = false;
            }
            try{
                int Accion = Integer.parseInt(UserAction);
                if (Accion == 0){
                    ExecuteCommandsDB ejecutar = new ExecuteCommandsDB();
                    ejecutar.ListCommands();
                }else if (Accion == 1){
                    Interfaz();
                }else{
                    throw new NumberFormatException("El número ingresado no es ni cero ni uno");
                }
            }catch(NumberFormatException error){
                System.out.println("Error en el input: " + error.getLocalizedMessage());
            }
        }
    }
    
    private static void Interfaz(){
        MainView InterfazGrafica = new MainView();
        InterfazGrafica.setVisible(true);
        InterfazGrafica.setLocationRelativeTo(null);
    }
    
}
