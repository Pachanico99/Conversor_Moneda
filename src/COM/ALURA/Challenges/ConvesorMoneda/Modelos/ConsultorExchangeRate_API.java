package COM.ALURA.Challenges.ConvesorMoneda.Modelos;

import java.io.IOException;

public class ConsultorExchangeRate_API extends Consultor_API{
    private static final String llaveDeUsuario = "87ffa9bcd38b851cf5fc4a7d";
    private static final String baseDireccion = "https://v6.exchangerate-api.com/v6/" + llaveDeUsuario;
    
    public static String direccionConversion(String codigoDeDivisaBase, String codigoDeDivisaObjectivo){
        return baseDireccion + "/pair/" + codigoDeDivisaBase + "/" + codigoDeDivisaObjectivo;
    }
    
    public static String direccionDivisasAdmitidas(){
        return baseDireccion + "/codes";
    }
    
    public static String obtenerDivisasAdmitidas()throws IOException, InterruptedException{
        return consultar_ExchangeRateAPI(direccionDivisasAdmitidas()).body();
    }
    
    public static String obtenerConversionDivisas(String coidigoDivisaBase, String codigoDeDivisaObjectivo) throws IOException, InterruptedException{
        return consultar_ExchangeRateAPI(direccionConversion(coidigoDivisaBase,codigoDeDivisaObjectivo)).body();
    }
}
