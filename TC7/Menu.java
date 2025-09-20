import java.util.Scanner;

public class Menu {
    public Menu(){
        Scanner input = new Scanner(System.in);
        int cerrar1 = 0;
        MatrizBase ajedrez = new MatrizBase();
        System.out.println("\nBievenido. Por favor, introduzca una coordenada en fila y columna para estudiar el movimiento de una pieza.");
        while (cerrar1 == 0) { 
            int fila = 0;
            int columna = 0;
            int cerrar2 = 0;
            int cerrar3 = 0;
            int intentar = 0;
            try {
                imprimirTabla(ajedrez.getMatriz());
                System.out.println("================\n");
                System.out.println("Introduzca una fila: ");
                fila = input.nextInt();
                input.nextLine();
                if (fila >= 0 && fila < 8) {
                    while (cerrar2 == 0) { 
                        try {
                            System.out.println("Ahora, introduzca una columna: ");
                            columna = input.nextInt();
                            input.nextLine();
                            if (fila >= 0 && fila < 8) {
                                if (!(ajedrez.getMatriz()[fila][columna].equals("-"))) {
                                    Alfil alfil = new Alfil(ajedrez.getMatriz(),fila,columna);
                                    Caballo caballo = new Caballo(ajedrez.getMatriz(),fila,columna);
                                    Peon peon = new Peon(ajedrez.getMatriz(),fila,columna);
                                    Reina reina = new Reina(ajedrez.getMatriz(),fila,columna);
                                    Rey rey = new Rey(ajedrez.getMatriz(),fila,columna);
                                    Torre torre = new Torre(ajedrez.getMatriz(),fila,columna);
                                    System.out.println("\n¿Desea volver a intentarlo con otra pieza?\n1-Sí\n2-No");
                                    while (cerrar3 == 0){
                                        try {
                                            intentar = input.nextInt();
                                            input.nextLine();
                                            if (intentar == 1){
                                                cerrar3 = 1;
                                                cerrar2 = 1;
                                            } else if (intentar == 2){
                                                cerrar3 = 1;
                                                cerrar2 = 1;
                                                cerrar1 = 1;
                                            } else {
                                                System.out.println("\nPor favor, introduzca:\n1-Intentarlo de nuevo\n2-Salir");    
                                            }
                                        } catch (Exception e) {
                                            System.out.println("\nPor favor, introduzca:\n1-Intentarlo de nuevo\n2-Salir");
                                            input.nextLine();
                                        }
                                    }
                                } else {
                                    System.out.println("\nLa casilla tomada no posee una pieza. Intenta con otra casilla.");
                                    cerrar2 = 1;
                                }
                            } else {
                                System.out.println("\nPor favor, introduzca una columna empezando por 0 y terminando en 7.\n");
                            }
                            
                        } catch (Exception e) {
                            System.out.println("\nIntroduzca un número del 0 al 7, por favor.");
                        }
                    }
                } else {
                    System.out.println("\nPor favor, introduzca una fila empezando por 0 y terminando en 7.\n");
                }
                
            } catch (Exception e) {
                System.out.println("\nIntroduzca un número del 0 al 7, por favor.");
            }
        }
    }

    private void imprimirTabla(String[][] tabla){
        System.out.println();
        for (String[] i : tabla) {
            for (String j : i) {
                System.out.printf("%s ",j);
            }
            System.out.println();
        }
    }

}
