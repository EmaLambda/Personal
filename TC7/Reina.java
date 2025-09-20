public class Reina {
    private int posicionX;
    private int posicionY;
    private String[][] tabla;
    private int[][] movimientos;

    public Reina(String[][] tabla, int f, int c){
        posicionX = f;
        posicionY = c;
        this.tabla = tabla; // La tabla de ajedrez
        movimientos = new int[][] {{0,-1}, {0,1}, {1,0}, {-1,0}, {-1,-1}, {1,1}, {1,-1}, {-1,1}}; // Todos los movimientos
        if (tabla[f][c].equals("D")){
            calcularMovimientos();
        }
    }

    private void calcularMovimientos(){
        int mvx;
        int mvy;
        int cerrar;
        String[][] dirReina = new String[8][8];
        for (String[] i : dirReina){
            for (String j : i){
                j = "-";
            }
        }
        // TODO: tiene que hacer el calculo de los movimientos de la reina, tome en cuenta que se puede mover hacia todos lados hasta que choque con algo
        // Psst, probablemente sea un par de fors anidados usando todos los atributos
        for(int[] i : movimientos){
            mvx = posicionX + i[0];
            mvy = posicionY + i[1];
            cerrar = 0;
            while(cerrar == 0 && (mvx < 8 && mvx >= 0) && (mvy < 8 && mvy >= 0)){
                if (tabla[mvx][mvy].equals("-")){
                    dirReina[mvx][mvy] = "X";
                    mvx += i[0];
                    mvy += i[1];
                } else {
                    dirReina[mvx][mvy] = tabla[mvx][mvy];
                    cerrar = 1;
                }
            }
        }

        // Imprimir la tabla de movimientos de la Reina
        for (String[] i : dirReina){
            for (String j : i){
                System.out.printf("\n %s ", j);
            }
            System.out.println();
        }
    }
}