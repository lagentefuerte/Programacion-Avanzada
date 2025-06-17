package Solitario.Pilas;

import Solitario.Cartas.Carta;

import java.util.Stack;

public abstract class PilaCartas {
    private Stack<Carta> cartas;
    public PilaCartas (){
        this.cartas = new Stack<>();
    }
    public abstract boolean puedoColocar (Carta c);
    public abstract void anadir (Carta c);
    public void add (Carta c){
        this.cartas.push(c);
    }
    public void remove (){
        if (!esVacia()) {
            this.cartas.pop();
        }
    }
    public abstract void eliminar();
    public Carta cima (){
        if (!esVacia())
            return this.cartas.peek();
        else
            return null;
    }
    protected String mostrarNTerminos (int n){
        if(!esVacia())
        {
            String s = "";
            Stack<Carta> aux = (Stack<Carta>) cartas.clone();
            for (int i = 0; i < n; i++) {
                s += aux.peek() + "\n";
                aux.pop();
            }
            return s;
        }
        else
            return "Vacia";
    }
    protected boolean esVacia (){
        return this.cartas.empty();
    }
    protected int tamano (){
        return this.cartas.size();
    }
    protected Carta getSuperior (int n){
        if (!esVacia())
        {
            Stack<Carta> aux = (Stack<Carta>) cartas.clone();
            for (int i = 1; i < n; i++) {
                aux.pop();
            }
            return aux.peek();
        }
        else
            return null;
    }
    protected void eliminarElemento (Carta c){
        if(!esVacia())
            this.cartas.remove(c);
    }
}
