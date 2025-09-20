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
        if (tabla[f][c].equals("P")){
            calcularMovimientos();
        }
    }

    private void calcularMovimientos(){
        int mvx;
        int mvy;
        String[][] dirPeon = new String[8][8];
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                dirPeon[i][j] = "-";
            }
        }
        // TODO: tiene que hacer el calculo de los movimientos del peon, tome en cuenta que se puede mover hacia arriba o hacia abajo 1 movimiento
        // Psst, probablemente sea un par de fors anidados usando todos los atributos
        dirPeon[posicionX][posicionY] = tabla[posicionX][posicionY];
        for(int[] i : movimientos){
            mvx = posicionX + i[0];
            mvy = posicionY + i[1];
            if((mvx < 8 && mvx >= 0) && (mvy < 8 && mvy >= 0)){
                if (tabla[mvx][mvy].equals("-")){
                    dirPeon[mvx][mvy] = "X";
                    mvx += i[0];
                    mvy += i[1];
                } else {
                    dirPeon[mvx][mvy] = tabla[mvx][mvy];
                }
            }
        }

        // Imprimir la tabla de movimientos del Peón
        System.out.println();
        for (String[] i : dirPeon){
            for (String j : i){
                System.out.printf("%s ", j);
            }
            System.out.println();
        }
    }
}