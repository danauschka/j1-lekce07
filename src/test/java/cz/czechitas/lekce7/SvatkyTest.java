package cz.czechitas.lekce7;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.Month;
import java.time.MonthDay;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Filip Jirsák
 */
class SvatkyTest {

    /**
     * Testuje metodu {@link Svatky#kdyMaSvatek(String)}
     */
    @Test
    void kdyMaSvatek() {
        Svatky svatky = new Svatky();
        assertEquals(MonthDay.of(5, 18), svatky.kdyMaSvatek("Nataša"));
        assertNull(svatky.kdyMaSvatek("Eva"));
    }

    @Test
    void kdyMaSvatek2() {
        //Arrange
        Svatky svatky = new Svatky();
        String jmenoNatasa = "Nataša";
        String jmenoEva = "Eva";
        MonthDay ocekavanyVysledekProNatasu = MonthDay.of(5, 18);

        //Act
        MonthDay skutecnyVysledekProNatasu = svatky.kdyMaSvatek(jmenoNatasa);
        MonthDay skutecnyVysledekProEvu = svatky.kdyMaSvatek(jmenoEva);

        //Assert
        assertEquals(ocekavanyVysledekProNatasu, skutecnyVysledekProNatasu);
        assertNull(skutecnyVysledekProEvu);
    }

    @Test
    void kdyMaSvatek_ProVstupNatasa_VraciValidniVystup() {
        //Arrange
        Svatky svatky = new Svatky();
        String jmeno = "Nataša";
        MonthDay ocekavanyVysledek = MonthDay.of(5, 18);
        //Act
        MonthDay skutecnyVysledek = svatky.kdyMaSvatek(jmeno);
        //Assert
        assertEquals(ocekavanyVysledek, skutecnyVysledek);
    }

    @Test
    void kdyMaSvatek_ProVstupEva_VraciNull() {
        //Arrange
        Svatky svatky = new Svatky();
        String jmeno = "Eva";
        MonthDay ocekavanyVysledek = null;
        //Act
        MonthDay skutecnyVysledek = svatky.kdyMaSvatek(jmeno);
        //Assert
        assertEquals(ocekavanyVysledek, skutecnyVysledek);
    }

    /**
     * Testuje metodu {@link Svatky#jeVSeznamu(String)}
     */
    @Test
    void jeVSeznamuExistujiciJmeno() {
        //TODO Otestovat, že najde v seznamu existující jméno
    /*
    Svatky svatky = new Svatky();
    assertTrue(svatky.jeVSeznamu("Nataša"));
    assertFalse(svatky.jeVSeznamu("Eva"));
    assertFalse(svatky.jeVSeznamu("fksngi"));
    */

        //Arrange
        Svatky svatky = new Svatky();
        String jmeno = "Nataša";
        Boolean ocekavanyVysledek = true;
        //Act
        Boolean skutecnyVysledek = svatky.jeVSeznamu(jmeno);
        //Assert
        assertTrue(skutecnyVysledek);
    }

    @Test
    void jeVSeznamuNeexistujiciJmeno() {
        //TODO Otestovat, že najde v seznamu neexistující jméno
        //Arrange
        Svatky svatky = new Svatky();
        String jmeno = "Tereza";
        Boolean ocekavanyVysledek = false;
        //Act
        Boolean skutecnyVysledek = svatky.jeVSeznamu(jmeno);
        //Assert
        assertFalse(skutecnyVysledek);
    }

    /**
     * Testuje metodu {@link Svatky#getPocetJmen()}
     */
    @Test
    void getPocetJmen() {
        //TODO Otestovat, že vrací počet jmen, která máme v seznamu
        //Arrange
        Svatky svatky = new Svatky();
        int ocekavanyVysledek = 37;
        //Act
        int skutecnyVysledek = svatky.getPocetJmen();
        //Assert
        assertEquals(ocekavanyVysledek, skutecnyVysledek);
    }

    /**
     * Testuje metodu {@link Svatky#getSeznamJmen()}
     */
    @Test
    void getSeznamJmen() {
        //TODO Zkontrolovat, že seznam jmen má správný počet položek.
        //Arrange
        Svatky svatky = new Svatky();
        int ocekavanyVysledek = 37;
        //Act
        int skutecnyVysledek = svatky.getSeznamJmen().size();
        //Assert
        assertEquals(ocekavanyVysledek, skutecnyVysledek);
    }

    /**
     * Testuje metodu {@link Svatky#pridatSvatek(String, int, int)}
     */
    @Test
    void pridatSvatekDenMesicInt() {
        //TODO Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
        //Arrange
        Svatky svatky = new Svatky();
        String jmeno = "Dana";
        MonthDay denSvatku = MonthDay.of(12, 11);
        //Act
        svatky.pridatSvatek(jmeno, denSvatku);
        MonthDay skutecnyDenSvatku = svatky.kdyMaSvatek(jmeno);
        //Assert
        assertTrue(svatky.jeVSeznamu(jmeno));
        assertEquals(denSvatku, skutecnyDenSvatku);
    }

    /**
     * Testuje metodu {@link Svatky#pridatSvatek(String, int, Month)}
     */
    @Test
    void pridatSvatekDenMesicMonth() {
        //TODO Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
        //Arrange
        Svatky svatky = new Svatky();
        String jmeno = "Dana";
        int denSvatku = 11;
        int mesicSvatku = 12;
        //Act
        svatky.pridatSvatek(jmeno, denSvatku, mesicSvatku);
        MonthDay skutecneDatumSvatku = svatky.kdyMaSvatek(jmeno);
        //Assert
        assertTrue(svatky.jeVSeznamu(jmeno));
        assertEquals(denSvatku, skutecneDatumSvatku.getDayOfMonth());
        assertEquals(mesicSvatku, skutecneDatumSvatku.getMonthValue());
    }

    /**
     * Testuje metodu {@link Svatky#pridatSvatek(String, MonthDay)}
     */
    @Test
    void pridatSvatekMonthDay() {
        //TODO Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
        //Arrange
        Svatky svatky = new Svatky();
        String jmeno = "Dana";
        int denSvatku = 11;
        Month mesicSvatku = Month.DECEMBER;
        //Act
        svatky.pridatSvatek(jmeno, denSvatku, mesicSvatku);
        MonthDay skutecneDatumSvatku = svatky.kdyMaSvatek(jmeno);
        //Assert
        assertTrue(svatky.jeVSeznamu(jmeno));
        assertEquals(denSvatku, skutecneDatumSvatku.getDayOfMonth());
        assertEquals(mesicSvatku, skutecneDatumSvatku.getMonth());
    }

    /**
     * Testuje metodu {@link Svatky#smazatSvatek(String)}
     */
    @Test
    void smazatSvatek() {
        //TODO Zkontrolovat, že po smazání bude počet svátků odpovídat novému počtu.
        //Arrange
        Svatky svatky = new Svatky();
        String jmeno = "Nataša";
        int ocekavanyVysledek = 36;
        //Act
        svatky.smazatSvatek(jmeno);
        //Assert
        assertEquals(ocekavanyVysledek, svatky.getPocetJmen());

    }
}
