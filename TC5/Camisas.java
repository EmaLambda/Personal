
/**
 * Write a description of class Camisas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Camisas
{
    private String nombre;
    private String tipo;
    private String talla;
    private String color;
    private int cdUso;
    public Camisas(String tipo, String color, String talla, String nombre, int cdUso){
        this.tipo = tipo;
        this.color = color;
        this.talla = talla;
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
    
    public String getNombreC(){
        return tipo + " " + nombre + " " + color;
    }
    
    public String getTalla(){
        return talla;
    }
    
    public String getTipo(){
        return tipo;
    }
    
    public String getColor(){
        return color;
    }
    
}