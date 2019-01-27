package test.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "stolik")
public class Stolik {

    @Id
    @NaturalId
    public int numer;

    @NotBlank
    @Column
    public int pojemnosc;

    @NotBlank
    @Column
    public String aktywnosc;

    @NotBlank
    @Column
    public String aktyp;

    @NotBlank
    @Column
    public String zajetosc;

    @NotBlank
    @Column
    public String akview;

    @Column
    public String akdsbl;

    public Stolik(){

    }

    public Stolik(int numer, int pojemnosc, String aktywnosc, String aktyp, String zajetosc, String akview, String akdsbl){
        this.numer=numer;
        this.pojemnosc=pojemnosc;
        this.aktywnosc=aktywnosc;
        this.aktyp=aktyp;
        this.zajetosc=zajetosc;
        this.akview=akview;
        this.akdsbl=akdsbl;
    }

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
