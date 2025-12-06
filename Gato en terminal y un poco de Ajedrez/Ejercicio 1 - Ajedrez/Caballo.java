public class Caballo {
    private int posicionX;
    private int posicionY;
    private String[][] tabla;
    private int[][] movimientos;

    public Caballo(String[][] tabla, int f, int c){
        posicionX = f;
        posicionY = c;
        this.tabla = tabla; // La tabla de ajedrez
        movimientos = new int[][] {{-1,-2}, {-2,-1}, {-2,1}, {-1,2}, {1,-2}, {2,-1}, {2,1}, {1,2}}; // Movimientos en L
        if (tabla[f][c].equals("C")){
            calcularMovimientos();
        }
    }

    private void calcularMovimientos(){
        int mvx;
        int mvy;
        String[][] dirCaballo = new String[8][8];
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                dirCaballo[i][j] = "-";
            }
        }
        // TODO: tiene que hacer el calculo de los movimientos del Caballo, tome en cuenta que se puede mover en L 1 movimiento, aunque en cualquier dirección
        // Psst, probablemente sea un par de fors anidados usando todos los atributos
        dirCaballo[posicionX][posicionY] = tabla[posicionX][posicionY];
        for(int[] i : movimientos){
            mvx = posicionX + i[0];
            mvy = posicionY + i[1];
            if((mvx < 8 && mvx >= 0) && (mvy < 8 && mvy >= 0)){
                if (tabla[mvx][mvy].equals("-")){
                    dirCaballo[mvx][mvy] = "X";
                    mvx += i[0];
                    mvy += i[1];
                } else {
                    dirCaballo[mvx][mvy] = tabla[mvx][mvy];
                }
            }
        }

        // Imprimir la tabla de movimientos del Caballo
        System.out.println();
        for (String[] i : dirCaballo){
            for (String j : i){
                System.out.printf("%s ", j);
            }
            System.out.println();
        }
    }
}
