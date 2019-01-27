package test.model;

import lombok.Builder;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String nazwa;

    @NaturalId
    @Size(max = 200)
    private String opis;

    @NotBlank
    @Size(max = 20)
    private String kategoria;

    @NotNull
    @Column
    private float cena;

    @NotNull
    @Column
    private int ilosc;

    public Menu() {

    }

    public Menu(String nazwa, String opis, String kategoria, float cena, int ilosc ) {

        this.nazwa = nazwa;
        this.opis = opis;
        this.kategoria=kategoria;
        this.cena=cena;
        this.ilosc=ilosc;
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
}
