public class MatrizBase {

    private String[][] matriz;
    private String[][] nuevaMatriz; // Una mauskeherramienta misteriosa que nos servira mas tarde
    private int x;
    private int y;
    private String[] piezas;

    public MatrizBase(){
        // Aqui se crea el tablero a ojo del "programador" :)
        String[] piezas = {"T", "C", "A", "D", "R", "A", "C", "T"};
        matriz = new String[8][8];
        for (int i = 0;i < 8; i++){
            for (int j = 0; j < 8 ; j++){
                matriz[i][j] = "-";
            }
        }
        for (int i = 0; i < 8 ; i++){
            matriz[0][i] = piezas[i];
            matriz[1][i] = "P";
            if (i < 4){
                matriz[6][4+i] = "P";
                matriz[7][4+i] = piezas[i];
            }
            // Puede que este por aqui lo que hay que corregir/agregar
        }
        matriz[4][0] = "P";
        matriz[5][1] = "T";
        matriz[6][1] = "P";
        matriz[4][2] = "P";
        matriz[5][1] = "T";
        matriz[5][3] = "D";
        matriz[7][1] = "C";
        matriz[7][2] = "A";
        matriz[4][3] = "P";
        matriz[3][3] = "P";
        matriz[1][3] = "-";  
        System.out.println(matriz[6][7]);
    }

    public String[][] getMatriz(){
        return matriz;
    }
}