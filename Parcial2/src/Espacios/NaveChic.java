package Parcial2.Espacios;

import Parcial2.Espacios.EspacioEvento;
import Parcial2.TipoEvento;

import java.util.List;

public class NaveChic extends EspacioEvento {

    public NaveChic(String id, int capacidad, int numMetrosCuadrados, String address, int cost) {
        super(id, capacidad, numMetrosCuadrados, address, cost);
    }

    @Override
    public List<TipoEvento> eventosDisponibles() {
        return List.of(TipoEvento.EVENTO_CORPORATIVO, TipoEvento.BODA, TipoEvento.FIESTA_EMPRESA, TipoEvento.CELEBRACION_FAMILIAR);
    }

    @Override
    public String toString() {
        return "NaveChic\n" + super.toString();
    }
}
