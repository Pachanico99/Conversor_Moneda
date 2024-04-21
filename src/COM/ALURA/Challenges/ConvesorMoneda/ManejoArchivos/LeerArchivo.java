package COM.ALURA.Challenges.ConvesorMoneda.ManejoArchivos;

import COM.ALURA.Challenges.ConvesorMoneda.Modelos.Conversion;
import COM.ALURA.Challenges.ConvesorMoneda.Modelos.Divisa;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public interface LeerArchivo {
    default ArrayList<Divisa> cargarDivisasAdmitidas(String rutaArchivo) throws FileNotFoundException{
        try (FileReader reader = new FileReader(rutaArchivo)) {
            // Leer el archivo JSON y convertirlo en un ArrayList de objetos Divisa
            Divisa[] arrayDivisas = new Gson().fromJson(reader, Divisa[].class);
            
            // Convertir el array de objetos Divisa en un ArrayList
            ArrayList<Divisa> listaDivisas = new ArrayList<>();
            listaDivisas.addAll(Arrays.asList(arrayDivisas));
            return listaDivisas;
        } catch (IOException e) {
            System.out.println("Ocurrio un error, en donde no se encontro el archivo Divisas: " + e.getMessage());
            return null;
        } catch (NullPointerException e){
            System.out.println("Ocurrio un error en la obtencion de divisas admitidas: " + e.getMessage());
            return null;
        }
    }
    // Método para cargar el historial de conversiones desde un archivo JSON
    default ArrayList<Conversion> cargarHistorialConveriones(String rutaArchivo) {
        Gson gson = new Gson();
        ArrayList<Conversion> conversiones = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            // Leer el contenido del archivo como un JsonArray
            JsonArray jsonArray = gson.fromJson(reader, JsonArray.class);
            
            if(!(jsonArray == null)){
                // Iterar sobre el JsonArray y convertir cada objeto JSON en un objeto Conversion
                for (int i = 0; i < jsonArray.size(); i++) {
                    Conversion conversion = gson.fromJson(jsonArray.get(i), Conversion.class);
                    conversiones.add(conversion);
                }
            }else{
                return null;
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        
        return conversiones;
    }
}
