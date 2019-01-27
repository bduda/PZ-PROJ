package test.payload;

import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.validation.constraints.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class ReserSaveRequest {

    private String id;

    @NotBlank
    private String stol;

    @NotBlank
    private String kto;

    private String data;

    private String godz;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStol() {
        return stol;
    }

    public void setStol(String stol) {
        this.stol = stol;
    }

    public String getKto() {
        return kto;
    }

    public void setKto(String kto) {
        this.kto = kto;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getGodz() {
        return godz;
    }

    public void setGodz(String godz) {
        this.godz = godz;
    }
}
