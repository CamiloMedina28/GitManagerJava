/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package camilo_medina.gitmanager.execCommand;
import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author Camilo Medina
 */

public class SelectDir {
    private static String Directorio;
    
    public static String seleccion(){
        JFileChooser FileChooser = new JFileChooser();
        FileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        FileChooser.setMultiSelectionEnabled(false);
        FileChooser.showOpenDialog(null);
        File ruta = FileChooser.getSelectedFile();
        setDirectorio(ruta.getAbsolutePath());
        return getDirectorio();
    }
    
    public static void setDirectorio(String dir){
        Directorio = dir;
    }
    
    public static String getDirectorio(){
        return Directorio;
    }
    
}
