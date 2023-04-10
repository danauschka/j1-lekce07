package cz.czechitas.lekce7;

import java.time.Month;
import java.time.MonthDay;

/**
 * Hlaví třída pro lekci 7.
 */
public class HlavniProgram {

    /**
     * Spouštěcí metoda celé aplikace.
     *
     * @param args
     */
    public static void main(String... args) {
        Svatky svatky = new Svatky();

        System.out.printf("V seznamu je %d jmen.", svatky.getPocetJmen()).println();
        System.out.printf("Monika má svátek %s.", svatky.kdyMaSvatek("Monika")).println();
        System.out.printf("Eva je v seznamu svátků: %b.", svatky.jeVSeznamu("Eva")).println();
    }

}
