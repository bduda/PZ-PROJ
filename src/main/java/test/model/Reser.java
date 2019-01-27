package test.model;

import org.hibernate.annotations.NaturalId;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

@Entity
@Table(name = "reser")
public class Reser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column
    private int stol;

    @NaturalId
    @Column(length = 100)
    private String kto;

    @NotNull
    @Column
    private Date data;

    @NotNull
    @Column
    private int godz;

    public Reser() {

    }

    public Reser(int stol, String kto, Date data, int godz ) {

        this.stol = stol;
        this.kto = kto;
        this.data=data;
        this.godz=godz;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStol() {
        return stol;
    }

    public void setStol(int stol) {
        this.stol = stol;
    }

    public String getKto() {
        return kto;
    }

    public void setKto(String kto) {
        this.kto = kto;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getGodz() {
        return godz;
    }

    public void setGodz(int godz) {
        this.godz = godz;
    }

}