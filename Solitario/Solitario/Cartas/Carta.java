package Solitario.Cartas;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Carta {
    private Palos palo;
    private Valores valor;
    public Carta (Palos palo, Valores valor){
        this.palo = palo;
        this.valor = valor;
    }
    public static Carta [] newBaraja (){
        Carta [] baraja = new Carta[Palos.values().length * Valores.values().length];
        for (int i = 0; i < Palos.values().length; i++) {
            for (int j = 0; j < Valores.values().length; j++) {
                baraja[i*Valores.values().length + j] = new Carta(Palos.values()[i], Valores.values()[j]);
            }
        }
        List<Carta> barajaLista = Arrays.asList(baraja);
        Collections.shuffle(barajaLista);
        barajaLista.toArray(baraja);
        return baraja;
    }
    public String toString (){
        return this.valor + " DE " + this.palo;
    }
    public boolean mayorQue (Carta c){
        if (c != null)
            return this.valor.ordinal()+1 == c.valor.ordinal();
         else
             return false;
    }
    public boolean mismoPalo (Carta c){
        if (c != null)
            return this.palo == c.palo;
        else
            return false;
    }
    public boolean esAs () { return this.valor == Valores.AS; }
}
