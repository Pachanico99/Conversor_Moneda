package COM.ALURA.Challenges.ConvesorMoneda.Modelos;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Consultor_API {
    public static HttpResponse<String> consultar_ExchangeRateAPI(String direccion) throws IOException, InterruptedException {
        // Creo cliente
        HttpClient cliente = HttpClient.newHttpClient();
        
        // Creo la solicitud
        HttpRequest solicitud = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

        // Devuelvo la respuesta de la api
        return cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());
    }
}
