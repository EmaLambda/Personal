import java.util.Scanner;

public class Gato {
    private String[][] tablero = new String[3][3];
    public Gato(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = "[ ]";
            }
        }
    }

    public void imprimirTablero(){
        System.out.println();
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                System.out.print(tablero[i][j]);
            }
            System.out.println();
        }
    }

    public int getGanador(){
        String ganador = "";

        // Revisar columnas
        for (int i = 0; i < 3; i++){
            if (tablero[0][i].equals(tablero[1][i]) && tablero[1][i].equals(tablero[2][i])){
                if (!tablero[0][i].equals("[ ]")){
                    ganador = tablero[0][i];
                }
            }
        }
        // Revisar filas
        for (int i = 0; i < 3; i++){
            if (tablero[i][0].equals(tablero[i][1]) && tablero[i][1].equals(tablero[i][2])){
                if (!tablero[i][0].equals("[ ]")){
                    ganador = tablero[i][0];
                }
            }
        }

        // Revisar diagonales
        if (tablero[0][0].equals(tablero[1][1]) && tablero[1][1].equals(tablero[2][2])){
            ganador = tablero[0][0];
        } else if ((tablero[0][2]).equals(tablero[1][1]) && (tablero[1][1]).equals(tablero[2][0])){
            ganador = tablero[0][2];
        }

        int empate = 0;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (!tablero[i][j].equals("[ ]")){
                    empate += 1;
                }
            }
        }

        if (ganador.equals("[X]")){
            return 1;
        } else if (ganador.equals("[O]")){
            return 2;
        } else if (empate == 9) {
            return 0;
        } else {
            return -1;
        }
    }

    public void turnoJugador1(){
        Scanner input = new Scanner(System.in);
        int terminarturno = 0;
        while(terminarturno == 0){
            try {
                System.out.println("\nJugador 1, ingrese primero la fila 1, 2 o 3: \n");
                int filaX = input.nextInt() - 1;
                if(filaX >= 0 && filaX <= 2){
                    int salir2 = 0;
                    while(salir2 == 0){
                        try {
                            System.out.println("\nAhora ingrese la columna 1, 2 o 3: \n");
                            int columnaX = input.nextInt() - 1;
                            if (columnaX >= 0 && columnaX <= 2) {
                                if (tablero[filaX][columnaX].equals("[ ]")) {
                                    tablero[filaX][columnaX] = "[X]";
                                    imprimirTablero();
                                    terminarturno = 1;
                                    salir2 = 1;
                                } else {
                                    System.out.println("\nEsa casilla ya esta ocupada, intente de nuevo.");
                                    salir2 = 1;
                                }
                            } else if(columnaX < 0 || columnaX > 2){
                                System.out.println("\nPor favor ingrese una columna válida.");
                            }
                        } catch (Exception e) {
                            System.out.println("\nEntrada no valida, intente de nuevo.");
                            input.nextLine();
                        }
                    }
                } else if(filaX < 0 || filaX > 2){
                    System.out.println("\nPor favor ingrese una fila válida.");
                }
            } catch (Exception e){
                System.out.println("\nEntrada no valida, intente de nuevo.");
                input.nextLine();
            }
        }
    }

    public void turnoJugador2(){
        Scanner input = new Scanner(System.in);
        int terminarturno = 0;
        while(terminarturno == 0){
            try {
                System.out.println("\nJugador 2, ingrese primero la fila 1, 2 o 3: \n");
                int filaO = input.nextInt() - 1;
                if(filaO >= 0 && filaO <= 2){
                    int salir2 = 0;
                    while(salir2 == 0){
                        try {
                            System.out.println("\nAhora ingrese la columna 1, 2 o 3: \n");
                            int columnaO = input.nextInt() - 1;
                            if (columnaO >= 0 && columnaO <= 2) {
                                if (tablero[filaO][columnaO].equals("[ ]")) {
                                    tablero[filaO][columnaO] = "[O]";
                                    imprimirTablero();
                                    terminarturno = 1;
                                    salir2 = 1;
                                } else {
                                    System.out.println("\nEsa casilla ya esta ocupada, intente de nuevo.");
                                    salir2 = 1;
                                }
                            } else if(columnaO < 0 || columnaO > 2){
                                System.out.println("\nPor favor ingrese una columna válida.");
                            }
                        } catch (Exception e) {
                            System.out.println("\nEntrada no valida, intente de nuevo.");
                            input.nextLine();
                        }
                    }
                } else if(filaO < 0 || filaO > 2){
                    System.out.println("\nPor favor ingrese una fila válida.");
                }
            } catch (Exception e){
                System.out.println("\nEntrada no valida, intente de nuevo.");
                input.nextLine();
            }
        }
    }

    public void volverEmpezar(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = "[ ]";
            }
        }
    }

}
