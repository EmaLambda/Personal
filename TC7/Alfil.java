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
        if (tabla[f][c].equals("A")){
            calcularMovimientos();
        }
    }

    private void calcularMovimientos(){
        int mvx;
        int mvy;
        int cerrar;
        String[][] dirAlfil = new String[8][8];
        for (String[] i : dirAlfil){
            for (String j : i){
                j = "-";
            }
        }
        // TODO: tiene que hacer el calculo de los movimientos del alfil, tome en cuenta que se puede mover en los diagonales hasta que choque con algo
        // Psst, probablemente sea un par de fors anidados usando todos los atributos
        for(int[] i : movimientos){
            mvx = posicionX + i[0];
            mvy = posicionY + i[1];
            cerrar = 0;
            while(cerrar == 0 && (mvx < 8 && mvx >= 0) && (mvy < 8 && mvy >= 0)){
                if (tabla[mvx][mvy].equals("-")){
                    dirAlfil[mvx][mvy] = "X";
                    mvx += i[0];
                    mvy += i[1];
                } else {
                    dirAlfil[mvx][mvy] = tabla[mvx][mvy];
                    cerrar = 1;
                }
            }
        }

        // Imprimir la tabla de movimientos del alfil
        for (String[] i : dirAlfil){
            for (String j : i){
                System.out.printf("\n %s ", j);
            }
            System.out.println();
        }
    }
}