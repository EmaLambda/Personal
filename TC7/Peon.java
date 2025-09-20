public class Peon {
    private int posicionX;
    private int posicionY;
    private String[][] tabla;
    private int[][] movimientos;

    public Peon(String[][] tabla, int f, int c){
        posicionX = f;
        posicionY = c;
        this.tabla = tabla; // La tabla de ajedrez
        movimientos = new int[][] {{1, 0}, {-1,0}}; // Movimientos verticales
        calcularMovimientos();
    }

    private void calcularMovimientos(){
        // TODO: tiene que hacer el calculo de los movimientos del peon, tome en cuenta que se puede mover hacia arriba o hacia abajo 1 movimiento
        // Psst, probablemente sea un par de fors anidados usando todos los atributos
    }
}