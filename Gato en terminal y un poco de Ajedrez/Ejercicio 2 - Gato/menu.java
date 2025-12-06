import java.util.Scanner;

public class menu {
    public menu(){
        int opcion = 0;
        int ganador = 0;
        Gato juego = new Gato();
        Scanner input = new Scanner(System.in);
        int salir = 0;
        System.out.println("\nBienvenido al juego del Gato.\n\nDigite 1 para jugar o 2 para salir\n");
        while (salir == 0){
            try{
                if (opcion == 0){
                    opcion = input.nextInt();
                }
                if (opcion == 1){
                    System.out.println("\nMuy bien, comencemos.\n");
                    System.out.println("El jugador 1 es X");
                    System.out.println("El jugador 2 es O");
                    juego.imprimirTablero();
                    ganador = juego.getGanador();
                    while (ganador == -1){
                        juego.turnoJugador1();
                        ganador = juego.getGanador();
                        if (ganador == -1){
                            juego.turnoJugador2();
                            ganador = juego.getGanador();
                        }
                    }

                    if (ganador == 1){
                        System.out.println("\nFelicidades, el jugador 1 ha ganado!");
                    } else if (ganador == 2){
                        System.out.println("\nFelicidades, el jugador 2 ha ganado!");
                    } else if (ganador == 0){
                        System.out.println("\nEl juego ha terminado en empate.");
                    }

                    salir = intentar();
                    if (salir == 0){
                        juego.volverEmpezar();
                        opcion = 1;
                    }   
                } else if (opcion == 2){
                    salir = 1;
                    System.out.println("\nGracias, hasta la próxima :)\n");
                }
            } catch (Exception e){
                System.out.println("\nOpcion no valida, introduzca 1 o 2, por favor.");
                input.nextLine();
            }
        }
    }

    public int intentar(){
        Scanner input = new Scanner(System.in);
        System.out.println("\nDigite 1 para jugar de nuevo o 2 para salir\n");
        int salir2 = 0;
        int opcion2 = 0;
        while (salir2 == 0){
            try{
                opcion2 = input.nextInt();
                input.nextLine();
                if (opcion2 == 1){
                    salir2 = 1;
                } else if (opcion2 == 2){
                    salir2 = 1;
                    System.out.println("\nGracias por jugar.\n");
                } else {
                    System.out.println("\nOpcion no valida, introduzca 1 o 2, por favor.");
                }
            } catch (Exception e){
                System.out.println("\nOpcion no valida, introduzca 1 o 2, por favor.");
                input.nextLine();
            }
        }

        if (opcion2 == 2){
            return 1;
        } else {
            return 0;
        }
    }
}
