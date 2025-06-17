package Parcial2.Exceptions;

public class NoValidNameException extends Exception {
    public NoValidNameException (){
        super("El nombre del espacio no existe");
    }
}
