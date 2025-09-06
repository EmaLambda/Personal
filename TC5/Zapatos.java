
/**
 * Write a description of class Zapatos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zapatos
{
    private String tipo;
    private double talla;
    private String nombre;
    private double estado;
    private int cdUso;
    public Zapatos(String tipo, double talla, String nombre, double estado, int cdUso){
        this.tipo = tipo;
        this.talla = talla;
        this.nombre = nombre;
        this.estado = estado;
        this.cdUso = cdUso;
    }
    
    public void setCD(int cdUso){
        this.cdUso = cdUso;
    }
    
    public String getTipo(){
        return tipo;
    }
    
    public int getCD(){
        return cdUso;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public double getTalla(){
        return talla;
    }
    
    public double getEstado(){
        return estado;
    }

}