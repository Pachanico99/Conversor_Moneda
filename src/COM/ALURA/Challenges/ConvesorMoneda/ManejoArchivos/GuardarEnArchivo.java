package COM.ALURA.Challenges.ConvesorMoneda.ManejoArchivos;

import COM.ALURA.Challenges.ConvesorMoneda.Modelos.Conversion;
import COM.ALURA.Challenges.ConvesorMoneda.Modelos.Divisa;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public interface GuardarEnArchivo {
    default void guardarDivisasAdmitidas(String divisasAdmitidas,String rutaArchivo) throws IOException, InterruptedException{
        // Instancia de Gson y JsonParser
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser parser = new JsonParser();

        // Creo el JsonObject para recibir la consulta
        JsonObject datosDivisas = JsonParser.parseString(divisasAdmitidas).getAsJsonObject();
        
        // Obtengo los codigos de divisas y el nombre de la moneda
        String json = gson.toJson(datosDivisas.getAsJsonArray("supported_codes"));
        
        // Lista para almacenar las divisas
        var divisas = new ArrayList<Divisa>();

        // Parsear el string JSON
        JsonArray jsonArray = parser.parse(json).getAsJsonArray();

        // Recorrer el array JSON y crear objetos Divisa
        for (JsonElement element : jsonArray) {
            JsonArray divisaArray = element.getAsJsonArray();
            String codigo = divisaArray.get(0).getAsString();
            String nombre = divisaArray.get(1).getAsString();
            Divisa divisa = new Divisa(codigo, nombre);
            divisas.add(divisa);
        }
        
        json = gson.toJson(divisas);

        // Escribir el JSON en un archivo
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            writer.write(json);
            System.out.println("Archivo JSON creado correctamente.");
            writer.close();
        } catch (IOException e) {
            System.out.println("Ocurrio un error: " + e.getMessage());
        }
    }
    
    default void guardarConversion(Conversion conversion, String rutaArchivo) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // Convertir la conversión a JSON
        JsonObject jsonObject = gson.toJsonTree(conversion).getAsJsonObject();

        // Leer el contenido actual del archivo (si existe)
        JsonArray jsonArray = new JsonArray();
        JsonArray anterior = leerJsonArray(rutaArchivo);
        jsonArray.add(jsonObject);
        if(!(anterior == null)){
            jsonArray.addAll( anterior);
        }
        // Escribir la lista de JSONObjects actualizada en el archivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            writer.write(gson.toJson(jsonArray));
            System.out.println("Resultado guardado correctamente en el archivo.");
        } catch (IOException e) {
            System.err.println("Error al guardar el resultado en el archivo: " + e.getMessage());
        }
    }

    // Método para leer el contenido actual del archivo y retornarlo como un JsonArray
    private JsonArray leerJsonArray(String rutaArchivo) {
        JsonArray jsonArray = new JsonArray();
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            Gson gson = new Gson();
            jsonArray = gson.fromJson(reader, JsonArray.class);
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return jsonArray;
    }
}
