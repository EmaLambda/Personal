import java.util.Scanner;
public class Menu {
    public Menu(){
        Youtuber[] youtube = new Youtuber[]{
            new Youtuber("MrBeast", 306000000, 950, "98000M", "Desafíos extravagantes, grandes sorteos de dinero y filantropía."),
            new Youtuber("PewDiePie", 111000000, 4600, "29000M", "Comentarios, reseñas de memes y vlogs; contenido humorístico y variado."),
            new Youtuber("Mark Rober", 71000000, 240, "14500M", "Ciencia, ingeniería y proyectos a gran escala."),
            new Youtuber("El Reino Infantil", 70000000, 1950, "69500M", "Música, canciones y videos animados para el público preescolar."),
            new Youtuber("VEGETTA777", 34000000, 7100, "16000M", "Gameplays largos y narrativos de juegos como Minecraft, con historias."),
            new Youtuber("Muzska89", 1000000, 650, "5000M", "Videos humorísticos y reseñas de videojuegos.")
        };
        Canales canales = new Canales();
        Scanner input = new Scanner(System.in);
        boolean seguir = true;
        while (seguir) { 
            try {
                System.out.println("\nYoutube\n\n1) Consultar suscripciones\n2) Explorar canales\n3) Salir");
                int opcion = input.nextInt();
                switch (opcion){
                    case 1:
                        verSuscripciones(canales, input);
                        break;
                    case 2:
                        ExplorarCanales(input, youtube, canales);
                        break;
                    case 3:
                        System.out.println("Adios.");
                        seguir = false;
                        break;
                    default:
                        System.out.println("Entrada inválida.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error: Entrada inválida.");
                input.nextLine();
            }
        }
    }

    private void ExplorarCanales(Scanner input, Youtuber[] catalogo, Canales canales){
        boolean seguir = true;
        while (seguir){
            try {
                System.out.println("Seleccione un canal:");
                for (int i = 0 ; i < catalogo.length ; i++) {
                    System.out.printf("\n%d) %s",i+1,catalogo[i].nombre);
                }
                System.out.printf("\n%d) Volver\n",catalogo.length + 1);
                int opcion = input.nextInt();
                if (0 < opcion && opcion <= catalogo.length){
                    boolean seguir2 = true;
                    while(seguir2){
                        try {
                            catalogo[opcion - 1].mostrarCanal();
                            System.out.println("");
                            System.out.println("1) Suscribirse\n2) Volver");
                            int opcion2 = input.nextInt();
                            switch (opcion2) {
                                case 1:
                                    if (!catalogo[opcion - 1].suscrito){
                                        canales.agregar(catalogo[opcion - 1]);
                                        System.out.println("Te has suscrito a " + catalogo[opcion - 1].nombre);
                                        catalogo[opcion - 1].setSuscripcion();
                                    } else {
                                        System.out.println("Ya te has suscrito a este canal.");
                                    }
                                    seguir2 = false;
                                    break;
                                case 2:
                                    seguir2 = false;
                                    break;
                                default:
                                    System.out.println("Entrada inválida.");
                                    break;
                                }
                            } catch (Exception e) {
                                System.out.println("Error: Entrada inválida.");
                                input.nextLine();
                            }
                        }

                } else if (opcion == catalogo.length + 1){
                    seguir = false;
                } else {
                    System.out.println("Entrada inválida.");
                }
            } catch (Exception e) {
                System.out.println("Error: Entrada inválida.");
                input.nextLine();
            }
        }
    }

    private void verSuscripciones(Canales canales, Scanner input){
        if (canales.tamaño() > 0) {
            boolean seguir = true;
            while (seguir){
                try {
                    System.out.println("Seleccione uno de los canales para verlo:");
                    canales.misCanales();
                    System.out.printf("\n%d) Volver",canales.tamaño() + 1);
                    System.out.println("");
                    // System.out.println(canales.tamaño());
                    int opcion = input.nextInt();
                    if (opcion > 0 && opcion <= canales.tamaño()){
                        boolean seguir2 = true;
                        while(seguir2){
                            try {
                                Youtuber youtuber = canales.mostrarCanal(opcion);
                                System.out.println("1) Desuscribirse\n2) Volver");
                                int opcion2 = input.nextInt();
                                switch (opcion2) {
                                    case 1:
                                        canales.eliminar(youtuber);
                                        seguir2 = false;
                                        youtuber.suscrito = false;
                                        System.out.println("Te has desuscrito de " + youtuber.nombre);
                                        if (canales.tamaño() == 0){
                                            seguir = false;
                                        }
                                        break;
                                    case 2:
                                        seguir2 = false;
                                        break;
                                    default:
                                        System.out.println("Entrada inválida.");
                                        break;
                                }
                            } catch (Exception e) {
                                System.out.println("Error: Entrada inválida.");
                                input.nextLine();
                            }
                        }
                        
                    } else if (opcion == canales.tamaño() + 1){
                        seguir = false;
                    } else {
                        System.out.println("Entrada inválida.");
                    }
                } catch (Exception e) {
                    System.out.println("Error: Entrada inválida.");
                    input.nextLine();
                }
            }
        } else {
            System.out.println("No te has suscrito a ningún canal.");
        }
    }

}
