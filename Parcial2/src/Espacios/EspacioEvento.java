package Parcial2.Espacios;

import Parcial2.Utils.CalendarioAnual;
import Parcial2.TipoEvento;

import java.util.List;
import java.util.Objects;

public abstract class EspacioEvento implements Comparable<EspacioEvento>{
    private String id;
    private int capacidad;
    private int numMetrosCuadrados;
    private String address;
    private int cost;
    private CalendarioAnual calendario;
    public EspacioEvento (String id, int capacidad, int numMetrosCuadrados, String address, int cost){
        this.id = id;
        this.capacidad = capacidad;
        this.numMetrosCuadrados = numMetrosCuadrados;
        this.address = address;
        this.cost = cost;
        this.calendario = new CalendarioAnual(2023);
    }
    public abstract List<TipoEvento> eventosDisponibles();
    public int compareTo (EspacioEvento e){
        return numMetrosCuadrados - e.numMetrosCuadrados;
    }
    public boolean estaOcupado (String date){
        return this.calendario.estaOcupado(date);
    }
    public boolean cumpleCapacidad (int num){
        return num <= this.capacidad;
    }
    public boolean tieneNombre (String name){
        return name.equals(id);
    }
    public void reservar (String date){
        this.calendario.ocuparDia(date);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EspacioEvento that = (EspacioEvento) o;
        return capacidad == that.capacidad && numMetrosCuadrados == that.numMetrosCuadrados && cost == that.cost && id.equals(that.id) && address.equals(that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, capacidad, numMetrosCuadrados, address, cost);
    }
    public String toString (){
        return "Metros Cuadrados: " + this.capacidad + "\nDireccion: " + address + "\nNombre: \" " + id + "\"\nCapacidad: " + this.capacidad;
    }
}
