package Solitario.Pilas;

import Solitario.Cartas.Carta;

public class PilaCartasSuperior extends PilaCartas {
    private static final int numPilas = 4;
    @Override
    public boolean puedoColocar(Carta c) {
        if (c == null)
            return false;
        if (esVacia())
            return c.esAs();
         else
             return c.mayorQue(this.cima()) && c.mismoPalo(this.cima());
    }
    public static boolean esValido(int num) {
        return num >= 0 && num < numPilas;
    }
    @Override
    public String toString (){
        if (!esVacia())
            return this.cima().toString() + " y " + (tamano() - 1) + " cartas";
        else
            return "Vacia";
    }
    @Override
    public void anadir (Carta c){
        this.add(c);
    }
    @Override
    public void eliminar (){
        this.remove();
    }
}
