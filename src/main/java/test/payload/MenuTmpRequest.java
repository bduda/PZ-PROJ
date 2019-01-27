package test.payload;

import org.hibernate.annotations.NaturalId;

import javax.persistence.Id;
import javax.validation.constraints.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Created by AAAaaaAAA on 21.01.2019.
 */
public class MenuTmpRequest {

    private String id;

    @NotBlank
    @Size(min = 1, max = 20)
    private String nazwa;

    @NotBlank
    private String cena;

    @NotBlank
    private String ilosc;

    @NotBlank
    private String stolik;

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

    public String getStolik() {
        return stolik;
    }

    public void setStolik(String stolik) {
        this.stolik = stolik;
    }
}
