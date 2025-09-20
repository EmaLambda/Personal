public class Reina {
    private int posicionX;
    private int posicionY;
    private String[][] tabla;
    private int[][] movimientos;

    public Reina(String[][] tabla, int f, int c){
        posicionX = f;
        posicionY = c;
        this.tabla = tabla; // La tabla de ajedrez
        movimientos = new int[][] {{0,-1}, {0,1}, {1,0}, {1,-1}, {-1,-1}, {1,1}, {1,-1}, {-1,1}}; // Todos los movimientos
        calcularMovimientos();
    }

    private void calcularMovimientos(){
        // TODO: tiene que hacer el calculo de los movimientos de la reina, tome en cuenta que se puede mover hacia todos lados hasta que choque con algo
        // Psst, probablemente sea un par de fors anidados usando todos los atributos
    }
}