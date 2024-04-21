package COM.ALURA.Challenges.ConvesorMoneda.InterfazGrafica.Componentes;

import COM.ALURA.Challenges.ConvesorMoneda.Modelos.Conversion;
import java.util.ArrayList;
import javax.swing.*;

public class ModeloDeListaConversion extends AbstractListModel<String> {
    private final ArrayList<Conversion> items;

    public ModeloDeListaConversion(ArrayList<Conversion> conversiones) {
        items = conversiones;
    }

    @Override
    public int getSize() {
        return items == null ? 1 : items.size();
    }

    @Override
    public String getElementAt(int i) {
        return items == null ? "No hay informacion de conversiones pasadas" : items.get(i).toStringRecortado();
    }

    public Conversion getConversion(int i) {
        return items.get(i);
    }
}
