package test.payload;

import org.hibernate.annotations.NaturalId;

import javax.persistence.Id;
import javax.validation.constraints.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Created by AAAaaaAAA on 21.01.2019.
 */
public class MenuRequest {

    private String id;

    @NotBlank
    @Size(min = 1, max = 20)
    private String nazwa;

    @NotBlank
    @Size(min = 1, max=200)
    private String opis;

    @NotBlank
    @Size(min = 1, max = 20)
    private String kategoria;

    @NotBlank
    private String cena;

    @NotBlank
    private String ilosc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    public String getIlosc() {
        return ilosc;
    }

    public void setIlosc(String ilosc) {
        this.ilosc = ilosc;
    }

}
