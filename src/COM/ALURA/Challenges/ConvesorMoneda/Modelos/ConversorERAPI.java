package COM.ALURA.Challenges.ConvesorMoneda.Modelos;

public record ConversorERAPI(
        String base_code,
        String target_code,
        double conversion_rate,
        String time_last_update_utc
        ){
}
