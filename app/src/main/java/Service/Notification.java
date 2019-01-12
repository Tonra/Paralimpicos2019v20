package Service;

public class Notification {

    private String hora;
    private String id;
    private String texto;
    private String titulo;


    public Notification(String hora, String id, String texto, String titulo) {
        this.id = id;
        this.titulo = titulo;
        this.texto = texto;
        this.hora = hora;
    }
    public Notification(){

    }


    //SETTER AND GETTER
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
