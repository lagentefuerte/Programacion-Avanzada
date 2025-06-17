package Parcial2;

import Parcial2.Espacios.EspacioEvento;
import Parcial2.Exceptions.*;
import Parcial2.Utils.Utils;

import java.util.*;

public class Gestor {
    private Map<TipoEvento, SortedSet<EspacioEvento>> mapa;
    private List<EspacioEvento> espacios;
    public Gestor (){
        this.mapa = new HashMap<>();
        this.espacios = new ArrayList<>();
    }
    public void addEspacio (EspacioEvento e){
        for (TipoEvento t : e.eventosDisponibles()){
            SortedSet<EspacioEvento> espacioEventos = this.mapa.get(t);
            if(espacioEventos == null)
                espacioEventos = new TreeSet<>();
            espacioEventos.add(e);
            espacios.add(e);
        }
    }
    public void imprimirEspaciosBoda (){
        System.out.println(this.mapa.get(TipoEvento.BODA));
    }
    public void consultaEspacio (TipoEvento t, int capacidad, String date) throws NoValidDateException {
        if (Utils.validDateFormat(date)){
            for (EspacioEvento e : this.mapa.get(t)){
                if (e.cumpleCapacidad(capacidad) && !e.estaOcupado(date))
                    System.out.println(e);
            }
        }
        else
            throw new NoValidDateException();
    }
    public void reservaEspacio (String name, String date) throws NoValidNameException {
        boolean contiene = false;
        int i = 0;
        while (i < this.espacios.size() && !contiene)
        {
            EspacioEvento aux = this.espacios.get(i);
            contiene = aux.tieneNombre(name);
            if (contiene){
                if (!aux.estaOcupado(date))
                    aux.reservar(date);
                else
                    System.out.println("Espacio ya reservado");
            }
            i++;
        }
        if (!contiene)
            throw new NoValidNameException();
    }
}
