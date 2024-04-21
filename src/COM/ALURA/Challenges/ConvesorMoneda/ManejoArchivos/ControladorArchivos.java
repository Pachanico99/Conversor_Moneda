package COM.ALURA.Challenges.ConvesorMoneda.ManejoArchivos;

import COM.ALURA.Challenges.ConvesorMoneda.Modelos.ConsultorExchangeRate_API;
import COM.ALURA.Challenges.ConvesorMoneda.Modelos.Conversion;
import COM.ALURA.Challenges.ConvesorMoneda.Modelos.Divisa;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;

public class ControladorArchivos implements GuardarEnArchivo, LeerArchivo, IniciarArchivos{
    private final String divisasAdmitidasErapi = "/src/COM/ALURA/Challenges/ConvesorMoneda/ManejoArchivos/Archivos/divisasAdmitidas.json";
    private final String historialConversionesErapi = "/src/COM/ALURA/Challenges/ConvesorMoneda/ManejoArchivos/Archivos/historialConversiones.json";
    
    public static String obtenerRutaBase(){
        Path currentDirectoryPath = FileSystems.getDefault().getPath("");
        return  currentDirectoryPath.toAbsolutePath().toString().replaceAll("\\\\", "/");
    }
    
    public String obtenerRutaDivisasAdmitidasErapi(){
        return obtenerRutaBase() + divisasAdmitidasErapi;
    }
    
    public String obtenerRutaHistorial(){
        
        return obtenerRutaBase() + historialConversionesErapi;
    }

    public void inciarArchivo() throws InterruptedException, IOException{
        IniciarArchivos.super.inciarArchivo(this.obtenerRutaDivisasAdmitidasErapi());
        File archivo = new File(divisasAdmitidasErapi);
        if(archivo.length() <= 0){
            GuardarEnArchivo.super.guardarDivisasAdmitidas(ConsultorExchangeRate_API.obtenerDivisasAdmitidas(), this.obtenerRutaDivisasAdmitidasErapi());
        }
        IniciarArchivos.super.inciarArchivo(this.obtenerRutaHistorial());
    }
    
    @Override
    public void guardarConversion(Conversion conversion, String rutaArchivo){
        GuardarEnArchivo.super.guardarConversion(conversion, rutaArchivo);
    }

    @Override
    public ArrayList<Divisa> cargarDivisasAdmitidas(String rutaArchivo) throws FileNotFoundException{
        return LeerArchivo.super.cargarDivisasAdmitidas(rutaArchivo);
    }
    
    @Override
    public ArrayList<Conversion> cargarHistorialConveriones(String rutaArchivo){
        return LeerArchivo.super.cargarHistorialConveriones(rutaArchivo);
    }
}