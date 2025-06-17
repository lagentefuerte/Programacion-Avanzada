package Parcial2.Utils;

import java.util.HashMap;
import java.util.Map;

public class CalendarioAnual {

    private Map<Integer, Map<Integer, Boolean>> calendarioReservas;
    private int year;

    public CalendarioAnual(int year) {
        this.year = year;
        this.calendarioReservas = new HashMap<>();
        this.calendarioReservas.put(1, this.generateMap(31));
        this.calendarioReservas.put(2, this.generateMap(28));
        this.calendarioReservas.put(3, this.generateMap(31));
        this.calendarioReservas.put(4, this.generateMap(30));
        this.calendarioReservas.put(5, this.generateMap(31));
        this.calendarioReservas.put(6, this.generateMap(30));
        this.calendarioReservas.put(7, this.generateMap(31));
        this.calendarioReservas.put(8, this.generateMap(31));
        this.calendarioReservas.put(9, this.generateMap(30));
        this.calendarioReservas.put(10, this.generateMap(31));
        this.calendarioReservas.put(11, this.generateMap(30));
        this.calendarioReservas.put(12, this.generateMap(31));
    }

    private Map<Integer, Boolean> generateMap(int numeroDiasMes) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 1; i <= numeroDiasMes; i++) {
            map.put(i, Boolean.FALSE);
        }

        return map;
    }

    // Tiene que venir con el formato DD/MM/YYYY
    private int getDay(String date) {
        int offset = date.indexOf("/");
        return Integer.parseInt(date.substring(0, offset));
    }

    private int getMonth(String date) {
        int firstOffset = date.indexOf("/");
        int lastOffset = date.lastIndexOf("/");

        return Integer.parseInt(date.substring(firstOffset + 1, lastOffset));
    }
    public void ocuparDia (String date){
        this.calendarioReservas.get(getMonth(date)).put(getDay(date), true);
    }
    public boolean estaOcupado (String date){
        return this.calendarioReservas.get(getMonth(date)).get(getDay(date));
    }

}
