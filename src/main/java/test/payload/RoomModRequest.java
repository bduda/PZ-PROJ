package test.payload;

import org.hibernate.annotations.NaturalId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

public class RoomModRequest {


    public int numer;

    public int pojemnosc;

    @NotBlank
    public String aktywnosc;

    @NotBlank
    public String aktyp;

    @NotBlank
    public String zajetosc;

    @NotBlank
    public String akview;

    public String akdsbl;


    public int getNumer() {
        return numer;
    }

    public void setNumer(int numer) {
        this.numer = numer;
    }

    public int getPojemnosc() {
        return pojemnosc;
    }

    public void setPojemnosc(int pojemnosc) {
        this.pojemnosc = pojemnosc;
    }

    public String getAktywnosc() {
        return aktywnosc;
    }

    public void setAktywnosc(String aktywnosc) {
        this.aktywnosc = aktywnosc;
    }

    public String getZajetosc() {
        return zajetosc;
    }

    public void setZajetosc(String zajetosc) {
        this.zajetosc = zajetosc;
    }

    public String getAktyp() {
        return aktyp;
    }

    public void setAktyp(String aktyp) {
        this.aktyp = aktyp;
    }


    public String getAkview() {
        return akview;
    }

    public void setAkview(String akview) {
        this.akview = akview;
    }

    public String getAkdsbl() {
        return akdsbl;
    }

    public void setAkdsbl(String akdsbl) {
        this.akdsbl = akdsbl;
    }
}
