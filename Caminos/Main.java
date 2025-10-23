public class Main {
    public static void main(String[] args) {
        String[][] mapaB = {
            {"X", "-", "-", "X", "-", "-", "S"},
            {"-", "X", "X", "-", "X", "X", "-"},
            {"-", "I", "-", "-", "-", "X", "-"}, // I está en (2,1). El área de (2,2) y (3,1) está abierta.
            {"X", "-", "-", "-", "X", "X", "-"},
            {"-", "S", "-", "-", "-", "-", "-"},
            {"-", "X", "X", "X", "-", "X", "X"},
            {"S", "-", "-", "-", "-", "-", "X"}
        };
        Camino ruta = new Camino(mapaB);
        ruta.CaminoOptimo("", ruta.PuntoPartida(mapaB)[0], ruta.PuntoPartida(mapaB)[1]);
        ruta.getCaminos();
    }
}
