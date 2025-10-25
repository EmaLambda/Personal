public class Main {
    public static void main(String[] args) {
        String[][] mapaC = {
            {"I","-","-","-","X","X","-","-","-","S"},
            {"X","-","X","X","-","-","X","X","-","-"},
            {"-","-","S","-","-","-","X","-","-","X"},
            {"X","X","-","X","X","-","X","X","-","-"},
            {"-","-","X","-","-","-","-","-","X","-"},
            {"S","-","-","X","X","-","X","X","-","-"},
            {"-","-","X","-","-","-","-","X","-","S"},
            {"X","X","-","-","-","X","-","-","-","-"}
        };
        Camino ruta = new Camino(mapaC);
        ruta.CaminoOptimo("", ruta.PuntoPartida(mapaC)[0], ruta.PuntoPartida(mapaC)[1]);
        ruta.getCaminos();
    }
}
