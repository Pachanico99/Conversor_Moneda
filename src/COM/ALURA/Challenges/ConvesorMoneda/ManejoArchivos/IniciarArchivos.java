package COM.ALURA.Challenges.ConvesorMoneda.ManejoArchivos;

import java.io.File;
import java.io.IOException;

public interface IniciarArchivos {
    default void inciarArchivo(String nombreArchivo){
        File archivo = new File(nombreArchivo);
        try {
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado correctamente.");
            } else {
                System.out.println("El archivo ya existe.");
            }
        } catch (IOException e) {
            System.err.println("Error al crear el archivo: " + e.getMessage());
        }
    }
}
