package Service;

public class Ranking {

    private String primerLugar;
    private String segundoLugar;
    private String tercerLugar;

    public Ranking(String primerLugar, String segundoLugar, String tercerLugar){
        this.primerLugar=primerLugar;
        this.segundoLugar=segundoLugar;
        this.tercerLugar=tercerLugar;
    }
    public Ranking(){


    }

    public String getPrimerLugar() {
        return primerLugar;
    }

    public void setPrimerLugar(String primerLugar) {
        this.primerLugar = primerLugar;
    }

    public String getSegundoLugar() {
        return segundoLugar;
    }

    public void setSegundoLugar(String segundoLugar) {
        this.segundoLugar = segundoLugar;
    }

    public String getTercerLugar() {
        return tercerLugar;
    }

    public void setTercerLugar(String tercerLugar) {
        this.tercerLugar = tercerLugar;
    }
}
