package Parcial2.Espacios;

import Parcial2.Espacios.EspacioEvento;
import Parcial2.JuegoInfantil;
import Parcial2.TipoEvento;

import java.util.Arrays;
import java.util.List;

public class EspacioCelebracionesInfantiles extends EspacioEvento {
    private JuegoInfantil[] juegos;
    public EspacioCelebracionesInfantiles(String id, int capacidad, int numMetrosCuadrados, String address, int cost) {
        super(id, capacidad, numMetrosCuadrados, address, cost);
        this.juegos = JuegoInfantil.values();
    }
    @Override
    public List<TipoEvento> eventosDisponibles() {
        return List.of(TipoEvento.FIESTA_INFANTIL);
    }
    @Override
    public String toString  (){
        return "Espacio para celebraciones infantiles\n" + super.toString() + "\nJuegos disponibles " + Arrays.toString(this.juegos);
    }
}
