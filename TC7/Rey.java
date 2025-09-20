public class Rey {
    private int posicionX;
    private int posicionY;
    private String[][] tabla;
    private int[][] movimientos;

    public Rey(String[][] tabla, int f, int c){
        posicionX = f;
        posicionY = c;
        this.tabla = tabla; // La tabla de ajedrez
        movimientos = new int[][] {{0,-1}, {0,1}, {1,0}, {-1,0}, {-1,-1}, {1,1}, {1,-1}, {-1,1}}; // Todos los movimientos
        if (tabla[f][c].equals("R")){
            calcularMovimientos();
        }
    }

    private void calcularMovimientos(){
        int mvx;
        int mvy;
        String[][] dirRey = new String[8][8];
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                dirRey[i][j] = "-";
            }
        }
        // TODO: tiene que hacer el calculo de los movimientos del Rey, tome en cuenta que se puede mover en todas las direcciones 1 movimiento
        // Psst, probablemente sea un par de fors anidados usando todos los atributos
        dirRey[posicionX][posicionY] = tabla[posicionX][posicionY];
        for(int[] i : movimientos){
            mvx = posicionX + i[0];
            mvy = posicionY + i[1];
            if((mvx < 8 && mvx >= 0) && (mvy < 8 && mvy >= 0)){
                if (tabla[mvx][mvy].equals("-")){
                    dirRey[mvx][mvy] = "X";
                    mvx += i[0];
                    mvy += i[1];
                } else {
                    dirRey[mvx][mvy] = tabla[mvx][mvy];
                }
            }
        }

        // Imprimir la tabla de movimientos del Rey
        System.out.println();
        for (String[] i : dirRey){
            for (String j : i){
                System.out.printf("%s ", j);
            }
            System.out.println();
        }
    }
}
