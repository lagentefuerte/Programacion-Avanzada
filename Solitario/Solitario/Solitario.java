package Solitario;

import Solitario.Cartas.Carta;
import Solitario.Pilas.PilaCartasInferior;
import Solitario.Pilas.PilaCartasSuperior;

import java.util.*;

public class Solitario {
    private Queue <Carta> mazo;
    private PilaCartasInferior[] PilasInferiores;
    private PilaCartasSuperior[] PilasSuperiores;
    private final int numInf = 7;
    private final int numSup = 4;
    public Solitario (){
        this.mazo = new LinkedList<Carta>();
        this.PilasInferiores = new PilaCartasInferior[numInf];
        for (int i = 0; i < numInf; i++) {
            this.PilasInferiores[i] = new PilaCartasInferior();
        }
        this.PilasSuperiores = new PilaCartasSuperior[numSup];
        for (int i = 0; i < numSup; i++) {
            this.PilasSuperiores[i] = new PilaCartasSuperior();
        }
    }
    private void empezarJuego (){
        Carta [] baraja = Carta.newBaraja();
        ArrayList<Carta> barajaLista = new ArrayList<>(Arrays.asList(baraja));
        for (int i = 0; i < numInf; i++) {
            for (int j = i; j >= 0; j--) {
                this.PilasInferiores[i].add(barajaLista.get(0));
                barajaLista.remove(0);
            }
        }
        int size = barajaLista.size();
        for (int i = 0; i < size; i++) {
            this.mazo.add(barajaLista.get(0));
            barajaLista.remove(0);
        }
    }
    private void siguienteCola (){
        Carta aux = this.mazo.peek();
        this.mazo.remove();
        this.mazo.add(aux);
    }
    private void mostrarEstado (){
        System.out.println("Carta Superior de la cola: " + this.mazo.peek());
        for (int i = 0; i < numInf; i++) {
            System.out.println("Pila Inferior "+ i + "\n" + this.PilasInferiores[i]);
        }
        for (int i = 0; i < numSup; i++) {
            System.out.println("Pila Superior " + i + "\n" + this.PilasSuperiores[i]);
        }
    }
    private void moverCarta (int numPila, boolean esSuperior){
        Carta aux = this.mazo.peek();
        if (esSuperior){
            if (PilaCartasSuperior.esValido(numPila)){
                if (PilasSuperiores[numPila].puedoColocar(aux)){
                    PilasSuperiores[numPila].anadir(aux);
                    this.mazo.remove();
                }
                else
                    System.out.println("No se pudo colocar");
            }
            else
                System.out.println("El numero no es valido");
        }
        else {
            if (PilaCartasInferior.esValido(numPila)){
                if (PilasInferiores[numPila].puedoColocar(aux)) {
                    PilasInferiores[numPila].anadir(aux);
                    this.mazo.remove();
                }
                else
                    System.out.println("No se pudo colocar");
            }
            else
                System.out.println("El numero no es valido");
        }
    }
    private void moverCarta (int numPila2, int numPila1, boolean esSuperior){
        if (PilaCartasInferior.esValido(numPila1)){
            Carta aux = PilasInferiores[numPila1].cima();
            if (esSuperior){
                if (PilaCartasSuperior.esValido(numPila2)){
                    if (PilasSuperiores[numPila2].puedoColocar(aux)){
                        PilasSuperiores[numPila2].anadir(aux);
                        PilasInferiores[numPila1].eliminar();
                    }
                    else
                        System.out.println("No se pudo colocar");
                }
                else
                    System.out.println("El numero no es valido");
            }
            else {
                if (PilaCartasInferior.esValido(numPila2)){
                    if (PilasInferiores[numPila2].puedoColocar(aux)) {
                        PilasInferiores[numPila2].anadir(aux);
                        PilasInferiores[numPila1].eliminar();
                    }
                    else
                        System.out.println("No se pudo colocar");
                }
                else
                    System.out.println("El numero no es valido");
            }
        }
        else
            System.out.println("El numero no es valido");
    }
    private boolean hayVictoria (){
        return mazo.isEmpty();
    }
    private void moverPila (int numOrigen, int numDest){
        if (PilaCartasInferior.esValido(numOrigen) && PilaCartasInferior.esValido(numDest)){
            if (PilasInferiores[numDest].puedoColocar(PilasInferiores[numOrigen].getSuperior())){
                PilasInferiores[numOrigen].moverSuperior(PilasInferiores[numDest]);
            }
            else
                System.out.println("No se pudo colocar");
        }
        else
            System.out.println("El numero no es valido");
    }
    public void jugar () {
        this.empezarJuego();
        Scanner s = new Scanner(System.in);
        int decision = 1;
        while (!hayVictoria()) {
            System.out.println("1. Mostrar Estado del Juego\n2. Siguiente Carta de la Cola\n3. Mover carta de cola a una pila\n4. Mover carta de una pila a otra\n5. Mover una pila inferior a otra");
            decision = s.nextInt();
            switch (decision) {
                case 1 -> this.mostrarEstado();
                case 2 -> siguienteCola();
                case 3 -> {
                    System.out.println("¿Quiere moverlo a la pila superior? (si/no)");
                    s.nextLine();
                    String sup = s.nextLine();
                    System.out.println("¿A que numero de pila desea moverlo?");
                    int numPila = s.nextInt();
                    if (sup.equals("si"))
                        moverCarta(numPila, true);
                    else if (sup.equals("no"))
                        moverCarta(numPila, false);
                    else
                        System.out.println("Entrada no valida");
                }
                case 4 -> {
                    System.out.println("¿Quiere moverlo a la pila superior? (si/no)");
                    s.nextLine();
                    String si = s.nextLine();
                    System.out.println("¿A que numero de pila desea moverlo?");
                    int numPila1 = s.nextInt();
                    System.out.println("¿Desde que numero de pila desea moverlo?");
                    int numPila2 = s.nextInt();
                    if (si.equals("si"))
                        moverCarta(numPila1, numPila2, true);
                    else if (si.equals("no"))
                        moverCarta(numPila1, numPila2, false);
                    else
                        System.out.println("Entrada no valida");
                }
                case 5 -> {
                    System.out.println("¿A que numero de pila desea moverlo?");
                    int numPila1 = s.nextInt();
                    System.out.println("¿Desde que numero de pila desea moverlo?");
                    int numPila2 = s.nextInt();
                    moverPila(numPila2, numPila1);
                }
                default -> System.out.println("No le he entendido\n");
            }
        }
        System.out.println("VICTORIA\n");
    }
}
