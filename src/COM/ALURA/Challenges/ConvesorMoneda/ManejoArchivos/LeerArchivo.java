package COM.ALURA.Challenges.ConvesorMoneda.ManejoArchivos;

import COM.ALURA.Challenges.ConvesorMoneda.Modelos.Conversion;
import COM.ALURA.Challenges.ConvesorMoneda.Modelos.Divisa;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
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
    
    default ArrayList<Conversion> cargarHistorialConveriones(String rutaArchivo){
        Gson gson = new Gson();
        var conversiones = new ArrayList<Conversion>();
        
        try (JsonReader reader = new JsonReader(new FileReader(rutaArchivo))) {
            // Configurar el lector para que ignore los nombres de las raíces y lea cada objeto JSON individual
            reader.setLenient(true);

            // Leer el archivo JSON mientras haya objetos para leer
            while (reader.hasNext()) {
                // Convertir el objeto JSON en un objeto Conversion
                Conversion conversion = gson.fromJson(reader, Conversion.class);
                conversiones.add(conversion);
            }
            reader.close();
            return conversiones;
        } catch (IOException e) {
            System.out.println("Ocurrio un error, en donde no se encontro el archivo Historial: " + e.getMessage());
            return null;
        }
    }
}
