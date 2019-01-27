package test.payload;

public class MenuTmpResponse {
    private Long id;
    private float cena;
    private int ilosc;
    private int stolik;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
