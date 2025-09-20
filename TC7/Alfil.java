public class Alfil {
    private int posicionX;
    private int posicionY;
    private String[][] tabla;
    private int[][] movimientos;

    public Alfil(String[][] tabla, int f, int c){
        posicionX = f;
        posicionY = c;
        this.tabla = tabla; // La tabla de ajedrez
        movimientos = new int[][] {{-1,-1}, {1,1}, {1,-1}, {-1,1}}; // Movimientos diagonales
        calcularMovimientos();
    }

    private void calcularMovimientos(){
        // TODO: tiene que hacer el calculo de los movimientos del alfil, tome en cuenta que se puede mover en los diagonales hasta que choque con algo
        // Psst, probablemente sea un par de fors anidados usando todos los atributos
    }
}