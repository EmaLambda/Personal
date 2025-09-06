
/**
 * Write a description of class Pantalones here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pantalones
{  
    private String talla;
    private int bolsillos;
    private String nombre;
    private int cdUso;
    public Pantalones(String talla, int bolsillos, String nombre, int cdUso){
        this.talla = talla;
        this.bolsillos = bolsillos;
        this.nombre = nombre;
        this.cdUso = cdUso;
    }
    
    public void setCD(int cdUso){
        this.cdUso = cdUso;
    }
    
    public int getCD(){
        return cdUso;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getTalla(){
        return talla;
    }
    
    public int getCantidadBolsillos(){
        return bolsillos;
    }
    
}