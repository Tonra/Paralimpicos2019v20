package Service;

public class Notification {

    private int id;
    private String titulo;
    private String texto;
    private String hora;

    public Notification(int id, String titulo, String texto, String hora) {
        this.id = id;
        this.titulo = titulo;
        this.texto = texto;
        this.hora = hora;
    }


    //SETTER AND GETTER
    public int getId() {
        return id;
    }

    public void setId(int id) {
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
