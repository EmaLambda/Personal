public class Youtuber {
    public String nombre;
    public int suscriptores;
    public int videos;
    public String vistas;
    public String descripcion;
    public Youtuber(String nombre, int suscriptores, int videos, String vistas, String descripcion){
        this.suscriptores = suscriptores;
        this.videos = videos;
        this.vistas = vistas;
        this.descripcion = descripcion;
    }
     public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
     }
}
