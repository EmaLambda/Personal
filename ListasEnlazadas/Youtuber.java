public class Youtuber {
    public boolean suscrito;
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
        this.suscrito = false;
        this.nombre = nombre;
    }
     public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
     }
     public void mostrarCanal(){
        System.out.printf("\nCanal: %s\n\nSuscriptores: %d\nVideos: %d\nVistas: %s\nDescripcion: %s",nombre,suscriptores,videos,vistas,descripcion);
        System.out.println("");
     }
     public void setSuscripcion(){
        this.suscrito = true;
     }
}
