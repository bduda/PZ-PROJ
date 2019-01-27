package test.model;

import lombok.Builder;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "menutmp")
public class MenuTmp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String nazwa;

    @NotNull
    @Column
    private float cena;

    @NotNull
    @Column
    private int ilosc;

    @NotNull
    @Column
    private int stolik;

    public MenuTmp() {

    }

    public MenuTmp(String nazwa, float cena, int ilosc, int stolik ) {

        this.nazwa = nazwa;
        this.cena=cena;
        this.ilosc=ilosc;
        this.stolik=stolik;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }


    public float getCena() {
        return cena;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }

    public int getStolik() {
        return stolik;
    }

    public void setStolik(int stolik) {
        this.stolik = stolik;
    }
}
