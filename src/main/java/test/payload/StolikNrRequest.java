package test.payload;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class StolikNrRequest {

    @NotBlank
    public String numer;

    public String getNumer() {
        return numer;
    }

    public void setNumer(String numer) {
        this.numer = numer;
    }

}
