public class MatrizBase {

    private String[][] matriz;
    private String[][] nuevaMatriz; // Una mauskeherramienta misteriosa que nos servira mas tarde
    private int x;
    private int y;
    private String[] piezas;

    public MatrizBase(){
        // TODO: Corregir lo que haya que corregir aqui
        // TODO: Hacer el objeto Rey.
        String[] piezas = {"T", "C", "A", "D", "R", "A", "C", "T"};
        matriz = new String[8][8];
        for (int i = 0; i< 8; i++){
            matriz[0][i] = piezas[i];
            matriz[1][i] = "P";
            // Puede que este por aqui lo que hay que corregir/agregar
            matriz[7][i] = piezas[i];
            matriz[6][i] = "P";
            for (int j = 2;j < 6; j++) {
                matriz[j][i] = "-";
            }
        }
        // TODO: Recibir las coordenadas de la pieza requerida
        // TODO: Calcular la nueva matriz con la pieza elegida
        System.out.println(matriz[6][7]);
    }

    public String[][] getMatriz(){
        return matriz;
    }
}