package COM.ALURA.Challenges.ConvesorMoneda.Modelos;

public class Divisa {
    String codigoDivisa;
    String nombreDivisa;
    
    public Divisa(String _codigoDivisa, String _nombreDivisa){
        codigoDivisa = _codigoDivisa;
        nombreDivisa = _nombreDivisa;
    }

    public String getCodigoDivisa() {
        return codigoDivisa;
    }

    public String getNombreDivisa() {
        return nombreDivisa;
    }

    @Override
    public String toString() {
        return codigoDivisa + " - " + nombreDivisa;
    }
}
