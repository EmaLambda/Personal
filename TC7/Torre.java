public class Torre {
    private int posicionX;
    private int posicionY;
    private String[][] tabla;
    private int[][] movimientos;

    public Torre(String[][] tabla, int f, int c){
        posicionX = f;
        posicionY = c;
        this.tabla = tabla; // La tabla de ajedrez
        movimientos = new int[][] {{0,-1}, {0,1}, {1,0}, {-1,0}}; // Movimientos Horizontales y verticales
        if (tabla[f][c].equals("T")){
            calcularMovimientos();
        }
    }

    private void calcularMovimientos(){
        int mvx;
        int mvy;
        int cerrar;
        String[][] dirTorre = new String[8][8];
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                dirTorre[i][j] = "-";
            }
        }
        // TODO: tiene que hacer el calculo de los movimientos de la torre, tome en cuenta que se puede mover en horizontal y vertical hasta que choque con algo
        // Psst, probablemente sea un par de fors anidados usando todos los atributos
        dirTorre[posicionX][posicionY] = tabla[posicionX][posicionY];
        for(int[] i : movimientos){
            mvx = posicionX + i[0];
            mvy = posicionY + i[1];
            cerrar = 0;
            while(cerrar == 0 && (mvx < 8 && mvx >= 0) && (mvy < 8 && mvy >= 0)){
                if (tabla[mvx][mvy].equals("-")){
                    dirTorre[mvx][mvy] = "X";
                    mvx += i[0];
                    mvy += i[1];
                } else {
                    dirTorre[mvx][mvy] = tabla[mvx][mvy];
                    cerrar = 1;
                }
            }
        }

        // Imprimir la tabla de movimientos de la Torre
        System.out.println();
        for (String[] i : dirTorre){
            for (String j : i){
                System.out.printf("%s ", j);
            }
            System.out.println();
        }
    }
}