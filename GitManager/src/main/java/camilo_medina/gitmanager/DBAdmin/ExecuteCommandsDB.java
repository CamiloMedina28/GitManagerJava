/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package camilo_medina.gitmanager.DBAdmin;
import java.util.Scanner;


/**
 *
 * @author Camilo Medina
 */
public class ExecuteCommandsDB {
    public void ListCommands(){
        String [] Acciones = {"Crear las tablas ", 
                              "Eliminar las tablas ",
                              "Crear un comando ", 
                              "Crear un parámetro ", 
                              "Asociar un parámetro a un comando "};
        Boolean SeleccionarOpciones = true;
        while (SeleccionarOpciones){
            int Accion = 0;
            for(String i:Acciones){
                Accion += 1;
                System.out.println("Para " + i + "envie " + Accion);
            }
            System.out.print("Ingrese su opción: ");
            Scanner escaner = new Scanner(System.in);
            String UserAction = escaner.nextLine(); 
            if (UserAction == ""){
                break;
            }
            try{
                Accion = Integer.parseInt(UserAction);
            }catch (NumberFormatException error){
                System.out.println("Error en el input: " + error.getLocalizedMessage());
                continue;
            }
            switch(Accion){
                case 1:
                    CrearTablas();
                    SeleccionarOpciones = false;
                    break;
                case 2:
                    EliminarTablas();
                    SeleccionarOpciones = false;
                    break;
                case 3:
                    CreacionDeComando();
                    SeleccionarOpciones = false;
                    break;
                case 4:
                    CreacionDeParametro();
                    SeleccionarOpciones = false;
                case 5:
                    AsociarParametroConComando();
                    SeleccionarOpciones = false;
                default:
                    System.out.println("Por favor ingrese una opcion válida");
            }
        }    
        
    }
    
    private void CrearTablas(){
        CreateDB creacion = new CreateDB();
        creacion.crear_tabla();
        creacion = null;
    }
    
    private void EliminarTablas(){
        Scanner escaner2 = new Scanner(System.in);
        DropTables eliminar = new DropTables();
        System.out.println("Ingrese los nombres de las tablas separados por comas");
        System.out.print("Nombres: ");
        String TablasString = escaner2.nextLine();
        String [] tablas = TablasString.split(",");
        eliminar.DropTables(tablas);
        escaner2 = null;
        eliminar= null;
    }
    
    private void CreacionDeComando(){
        CrearComando creador = new CrearComando();
        Scanner escaner3 = new Scanner(System.in);
        String entrada;
        try{
            System.out.print("Ingrese el id del comando: ");
            entrada = escaner3.nextLine();
            int com_id = Integer.parseInt(entrada);
            System.out.print("Ingrese el nombre del comando: ");
            entrada = escaner3.nextLine();
            String com_nombre = entrada;
            System.out.print("Ingrese la sintaxis del comando: ");
            entrada = escaner3.nextLine();
            String com_sintaxis = entrada;
            System.out.print("Ingrese la descripción del comando: ");
            entrada = escaner3.nextLine();
            String com_desc = entrada;
            creador.InsertarComando(com_id, com_nombre, com_sintaxis, com_desc);
            creador = null;
            escaner3 = null;
        }catch(NumberFormatException error){
            System.out.println("Error en el id ingresado");
        }catch(ParametroInvalidoException ex){
            System.out.println("Error en parámetros ingresados.");
        }
    }
    
    private void CreacionDeParametro(){
        CrearParametro CreadorDeParametros = new CrearParametro();
        Scanner escaner4 = new Scanner(System.in);
        String entrada;
        try{
            System.out.print("Por favor ingrese el id: ");
            entrada = escaner4.nextLine();
            int param_id = Integer.parseInt(entrada);
            System.out.print("Por favor ingrese el nombre: ");
            entrada = escaner4.nextLine();
            String param_nombre = entrada;
            System.out.print("Por favor ingrese la descripción: ");
            entrada = escaner4.nextLine();
            String param_desc = entrada;
            System.out.print("Por favor ingrese la sintaxis larga: ");
            entrada = escaner4.nextLine();
            String param_sintaxis_larga = entrada;
            System.out.print("Por favor ingrese la sintaxis corta: ");
            entrada = escaner4.nextLine();
            String param_sintaxis_corta = entrada;
            CreadorDeParametros.InsertarParametro(param_id, 
                                                    param_nombre, 
                                                    param_desc,
                                                    param_sintaxis_larga, 
                                                    param_sintaxis_corta);
            CreadorDeParametros = null;
            escaner4 = null;
        }catch(ParametroInvalidoException ex){
           System.out.println("Error en parámetros ingresados.");
        }
    }
    
    private void AsociarParametroConComando(){
        AsociarParametosComandos Asociador = new AsociarParametosComandos();
        Scanner escaner5 = new Scanner(System.in);
        String entrada;
        try{
            System.out.print("Por favor ingrese el id del comando: ");
            entrada = escaner5.nextLine();
            int com_id = Integer.parseInt(entrada);
            System.out.print("Por favor ingrese el id del parametro: ");
            entrada = escaner5.nextLine();
            int param_id = Integer.parseInt(entrada);
            Asociador.AsociacionParamCom(com_id, param_id);
        }catch(ParametroInvalidoException ex){
           System.out.println("Error en parámetros ingresados.");
        }
    }
}


