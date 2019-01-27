package test.payload;

import javax.validation.constraints.NotBlank;


public class MenuByKatRequest {

    @NotBlank
    String kategoria;

    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }
}
