package Solitario.Pilas;

import Solitario.Cartas.Carta;

public class PilaCartasInferior extends PilaCartas {
    private int visibilidad;
    private static final int numPilas = 7;
    public PilaCartasInferior (){
        super();
        this.visibilidad = 1;
    }
    @Override
    public boolean puedoColocar(Carta c) {
        return c != null && (esVacia() || this.cima().mayorQue(c));
    }
    public static boolean esValido(int num) {
        return num >= 0 && num < numPilas;
    }
    private void aumentarVisibilidad (){
        if (!esVacia())
            this.visibilidad++;
    }
    private void checkVisibilidad (){
        if (this.visibilidad > this.tamano())
            this.visibilidad = this.tamano();
    }
    private void disminuirVisibilidad (){
        if (this.visibilidad > 1)
            this.visibilidad--;
    }
    public String toString() {
        if (!esVacia()){
            this.checkVisibilidad();
            return mostrarNTerminos(visibilidad) + " y " + (tamano() - this.visibilidad) + " cartas";
        }
        else
            return "Vacia";
    }
    public Carta getSuperior (){
        return getSuperior(this.visibilidad);
    }
    public void moverSuperior(PilaCartasInferior p){
        int vis = this.visibilidad;
        Carta aux;
        for (int i = 0; i < vis; i++) {
            aux = getSuperior(this.visibilidad);
            p.anadir(aux);
            this.eliminarElemento(aux);
            this.disminuirVisibilidad();
            this.checkVisibilidad();
        }
        p.checkVisibilidad();
    }
    @Override
    public void anadir (Carta c){
        this.add(c);
        this.aumentarVisibilidad();
        this.checkVisibilidad();
    }
    @Override
    public void eliminar (){
        this.remove();
        this.disminuirVisibilidad();
        this.checkVisibilidad();
    }
}
