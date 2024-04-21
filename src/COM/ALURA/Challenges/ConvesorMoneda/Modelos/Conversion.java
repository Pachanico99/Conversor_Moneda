package COM.ALURA.Challenges.ConvesorMoneda.Modelos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Conversion {
    private final String codigoDivisaBase;
    private final String codigoDivisaObjectivo;
    private final double tasaCambio;
    private final Date fechaDeUltimaActualización;
    private final Date fechaDeConsulta;
    private final double importe;
    
    public Conversion(ConversorERAPI erapi, double _importe){
        codigoDivisaBase = erapi.base_code();
        codigoDivisaObjectivo = erapi.target_code();
        tasaCambio = erapi.conversion_rate();
        fechaDeUltimaActualización = new Date(erapi.time_last_update_utc());
        fechaDeConsulta = new Date();
        importe = _importe;
    }
    
    public double importeConvertido(){
        return importe * tasaCambio;
    }

    @Override
    public String toString() {
        DateFormat formatoDeFecha = new SimpleDateFormat("dd|MM|yyyy - HH:mm:ss");
        return  "Fecha de conversion: " + formatoDeFecha.format(fechaDeConsulta) + " \n"
                + String.format("%,.2f", importe) + " " + codigoDivisaBase + " =\n"
                + String.format("%,.2f",this.importeConvertido()) + " " + codigoDivisaObjectivo + " \n"
                + "[Ultima fecha de actualizacion de la api: " + formatoDeFecha.format(fechaDeUltimaActualización) +"]\n"
                + "Razon de cambio: \n" 
                + "1 " + codigoDivisaBase + " = " + tasaCambio + " " + codigoDivisaObjectivo + "\n"
                + "1 " + codigoDivisaObjectivo + " = " + (1 / tasaCambio) + " " + codigoDivisaBase + "\n";               
    }

    public String toStringRecortado() {
        DateFormat formatoDeFecha = new SimpleDateFormat("dd|MM|yyyy - HH:mm:ss");
        return  "Fecha de conversion: " + formatoDeFecha.format(fechaDeConsulta) + " | "
                + String.format("%,.2f", importe) + " " + codigoDivisaBase + " = "
                + String.format("%,.2f",this.importeConvertido()) + " " + codigoDivisaObjectivo + " | "
                + "[Ultima fecha de actualizacion de la api: " + formatoDeFecha.format(fechaDeUltimaActualización) +"]";          
    }

    public String getCodigoDivisaBase() {
        return codigoDivisaBase;
    }

    public String getCodigoDivisaObjectivo() {
        return codigoDivisaObjectivo;
    }

    public double getTasaCambio() {
        return tasaCambio;
    }

    public Date getFechaDeUltimaActualización() {
        return fechaDeUltimaActualización;
    }

    public Date getFechaDeConsulta() {
        return fechaDeConsulta;
    }

    public double getImporte() {
        return importe;
    }
}
