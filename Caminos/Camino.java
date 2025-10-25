public class Camino {
    private final String[][] mapa;
    private String[] caminos = new String[0];
    private final int[][] movim = {{0,1},{1,0},{-1,0},{0,-1}};
    public Camino(String[][] mapa){
        this.mapa = mapa;
    }

    public void CaminoOptimo(String camino,int x, int y){
        if (mapa[x][y].equals("S")) {
            AgregarCamino(camino);
            return;
        }
        String posOriginal = mapa[x][y];
        mapa[x][y] = "R"; // Camino recorrido
        for (int[] mov : movim) {
            if (verificar(mov, x, y) == 1){
                String nuevoCamino = camino + DetectarMov(mov[0],mov[1]);
                int movx = x + mov[0];
                int movy = y + mov[1];
                CaminoOptimo(nuevoCamino,movx,movy);
            }
        }
        mapa[x][y] = posOriginal; // La línea no puede ir en el for, pues en un segundo movimiento considera al inicio como desmarcado (hay bucle).
    }
    

    public void getCaminos(){
        if (caminos.length > 0){
            int cont = caminos[0].length();
            int cont1 = 0;
            int cont2 = 0;
            for (String cam : caminos){
                if (cam.length() < cont) {
                    cont = cam.length();
                }
            }
            for (String cam : caminos){
                if (cam.length() == cont){
                    cont1 += 1;
                }
            }
            String[] caminosOptimos = new String[cont1];
            for (String cam : caminos) {
                if (cam.length() == cont) {
                    caminosOptimos[cont2] = cam;
                    cont2 += 1;
                }
            }
            System.out.println("El(los) camino(s) más corto(s) es(son):\n");
            for (String cam : caminosOptimos){
                System.out.println(cam);
            }
            System.out.println("");
        } else {
            System.out.println("No se encontraron caminos.");
        }
    }

    public int verificar(int[] mov, int x, int y){
        int movx = x + mov[0];
        int movy = y + mov[1];
        if ((0 <= movx && movx < mapa.length) && (0 <= movy && movy < mapa[0].length)){
            if (mapa[movx][movy].equals("R") || mapa[movx][movy].equals("X")){
                return -1;
            } else {
                return 1;
            }
        } else {
            return -1;
        }
    }

    public void AgregarCamino(String camino){
        String[] nuevosCaminos = new String[caminos.length + 1];
        for (int i = 0 ; i < caminos.length ; i++){
            nuevosCaminos[i] = caminos[i];
        }
        nuevosCaminos[caminos.length] = camino;
        this.caminos = nuevosCaminos;
    }

    public int[] PuntoPartida(String[][] mapa){
        int x = 0;
        int y = 0;
        for (int i = 0 ; i < mapa.length ; i++){
            for (int j = 0 ; j < mapa[i].length ; j++){
                if (mapa[i][j].equals("I")){
                    x = i;
                    y = j;
                }
            }
        }
        return new int[] {x,y};
    }

    public String DetectarMov(int x, int y){
        if (x == 0){
            if (y == 1) {
                return "D";
            } else {
                return "A";
            }
        } else if (y == 0){
            if (x == 1){
                return "S";
            } else {
                return "W";
            }
        } else {
            return "NULL";
        }
    }

}
