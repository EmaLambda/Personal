import java.util.InputMismatchException;  //Error al no recibir valor esperado
import java.util.Scanner;
/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu
{
    private Camisas[] camisasDisponibles = new Camisas[5];
    private Pantalones[] pantalonesDisponibles = new Pantalones[3];
    private Zapatos[] zapatosDisponibles = new Zapatos[4];
    private int cdCamisas = Math.round(camisasDisponibles.length/2);
    private int cdPantalones = Math.round(pantalonesDisponibles.length/2);
    private int cdZapatos = Math.round(zapatosDisponibles.length/2);
    private int posicionC;
    private int posicionP;
    private int posicionZ;
    public Menu(){
        closetCamisas();
        closetPantalones();
        closetZapatos();
        int camisaselec;
        int pantalonselec;
        int zapatoselec;
        int salida = 0;
        int opcion;
        Scanner input = new Scanner(System.in);
        System.out.println("¡Bienvenido! :)");
        System.out.println("¿Qué quieres hacer con tu closet?\n");
        while (salida != 3){
            try{
                System.out.println("1-Armar outfit diario\n2-Consultar prendas\n3-Salir");
                opcion = input.nextInt();
                input.nextLine();
                if (opcion == 1){
                    System.out.println("Empecemos por la camisa.\n");
                    Camisas camselec = camisaSeleccionada();
                    System.out.println("Vamos con el pantalón.\n");
                    Pantalones pantselec = pantalonSeleccionado();
                    System.out.println("¿Y los zapatos?\n");
                    Zapatos zapselec = zapatosSeleccionados();
                    System.out.println("¡Excelente! Tu outfit del día es: ");
                    System.out.printf("\n%s\n%s\n%s\n\n",camselec.getNombreC(),pantselec.getNombre(),zapselec.getNombre());
                } else if (opcion == 2){
                    int opcion2 = 0;
                    while (opcion2 != 1)
                        try {
                            System.out.println("Prendas:\n1-Camisas\n2-Pantalones\n3-Zapatos");
                            opcion2 = input.nextInt();
                            input.nextLine();
                            if (opcion2 == 1){
                                mostrarCamisa();
                                opcion2 = 1;
                            } else if (opcion2==2){
                                mostrarPantalon();
                                opcion2 = 1;
                            } else if (opcion2==3){
                                mostrarZapatos();
                                opcion2 = 1;
                            } else {
                                System.out.println("Introduzca una de las opciones, por favor.");
                            }
                        } catch (InputMismatchException error){
                            System.out.print("Introduzca una opción válida.");
                        }
                    if (opcion2==1){
                        
                    }
                } else if (opcion == 3){
                    salida = opcion;
                } else {
                    System.out.println("Introduzca una de las opciones, por favor.");
                }
            } catch (InputMismatchException error){
                System.out.println("Por favor, digite una opción válida");
                input.nextLine();
            }
        }
    }
    
    public void closetCamisas(){
        camisasDisponibles[0] = new Camisas("Jersey", "Celeste/Blanca", "M", "Messi Argentina 2021",0);
        camisasDisponibles[1] = new Camisas("Jersey", "Rojo/Verde", "M","Ronaldo Portugal 2024",0);
        camisasDisponibles[2] = new Camisas("Camiseta","Gris","M","Manga larga",0);
        camisasDisponibles[3] = new Camisas("Camiseta","Beige","M","Manga corta casual",0);
        camisasDisponibles[4] = new Camisas("Camisa","Blanco/Anaranjado","M","Manga corta haiwaiana",0);
    }
    
    public void closetPantalones(){
        pantalonesDisponibles[0] = new Pantalones("L",2,"Pantalones negros",0);
        pantalonesDisponibles[1] = new Pantalones("L",4,"Pantalones militares",0);
        pantalonesDisponibles[2] = new Pantalones("L",2,"Jogger negro",0);
    }
    
    public void closetZapatos(){
        zapatosDisponibles[0] = new Zapatos("Tennis",40,"Converse blancas",50,0);
        zapatosDisponibles[1] = new Zapatos("Burros",40,"Hi-tec cafés oscuros",100,0);
        zapatosDisponibles[2] = new Zapatos("Tennis",40,"Adidas Supernova running 3",90,0);
        zapatosDisponibles[3] = new Zapatos("Primitivo",40,"Descalzo",25,0);
    }
    
    public Camisas camisaSeleccionada(){
        Scanner input = new Scanner(System.in);
        int camisa = 0;
        int cerrar1 = 0;
        Camisas[] camisasMostrar = new Camisas[5];  //lista temporal para mostrar en menu solo cooldown's en 0 (Sugerencia del profe)
        while (cerrar1 != 1){
            try{
                posicionC = 0;
                for (int i = 0;i<camisasMostrar.length;i++){
                    if (camisasDisponibles[i].getCD() == 0){
                        camisasMostrar[posicionC] = camisasDisponibles[i];
                        posicionC += 1;
                    }
                }
                System.out.println("Camisas disponibles: ");
                for(int i = 0;i<posicionC;i++){
                    System.out.printf("\n%d-%s",i+1,camisasMostrar[i].getNombreC());
                }
                System.out.println("");
                camisa = input.nextInt();
                input.nextLine();
                //System.out.println(posicionC);
                if (camisa>0 && camisa<=posicionC){
                    cerrar1 = 1;
                } else {
                    System.out.println("Por favor, ingrese una de las opciones");
                }
            } catch (InputMismatchException error){
                System.out.println("Por favor, ingrese una opción válida");
                input.nextLine();
            }
        }
        camisasMostrar[camisa - 1].setCD(cdCamisas);
        //for (Camisas cam : camisasMostrar){
        for (int i = 0;i<camisasDisponibles.length;i++){
            if (camisasMostrar[camisa-1] != camisasDisponibles[i] && camisasDisponibles[i].getCD()>0){
                int c = camisasDisponibles[i].getCD();
                camisasDisponibles[i].setCD(c-1);
                //System.out.println("Está entrando");
            }
        }
        //}
        return camisasMostrar[camisa - 1];
    }
    
    public Pantalones pantalonSeleccionado(){
        Scanner input = new Scanner(System.in);
        int pantalon = 0;
        int cerrar2 = 0;
        Pantalones[] pantalonesMostrar = new Pantalones[3]; //lista temporal para mostrar en menu solo cooldown's en 0 (Sugerencia del profe)
        while (cerrar2 != 1){
            try{
                posicionP = 0;
                for (int i = 0;i<pantalonesMostrar.length;i++){
                    if (pantalonesDisponibles[i].getCD() == 0){
                        pantalonesMostrar[posicionP] = pantalonesDisponibles[i];
                        posicionP += 1;
                    }
                }
                System.out.println("Pantalones disponibles: ");
                for(int i = 0;i<posicionP;i++){
                    System.out.printf("\n%d-%s",i+1,pantalonesMostrar[i].getNombre());
                }
                System.out.println("");
                pantalon = input.nextInt();
                input.nextLine();
                //System.out.println(posicionP);
                if (pantalon>0 && pantalon<=posicionP){
                    cerrar2 = 1;
                } else {
                    System.out.println("Por favor, ingrese una de las opciones");
                }
            } catch (Exception e){
                System.out.println("Por favor, ingrese una opción válida");
                input.nextLine();
            }
        }
        pantalonesMostrar[pantalon - 1].setCD(cdPantalones);
        //for (Pantalones pant : pantalonesMostrar){
        //System.out.println(pantalon-1);
        for (int j = 0;j<pantalonesDisponibles.length;j++){
            if (pantalonesMostrar[pantalon-1] != pantalonesDisponibles[j] && pantalonesDisponibles[j].getCD()>0){
                int p = pantalonesDisponibles[j].getCD();
                pantalonesDisponibles[j].setCD(p-1);
                System.out.println("Está entrando");
            }
        }
        //}
        return pantalonesMostrar[pantalon - 1];
    }
    
    public Zapatos zapatosSeleccionados(){
        Scanner input = new Scanner(System.in);
        int zapatos = 0;
        int cerrar3 = 0;
        Zapatos[] zapatosMostrar = new Zapatos[4]; //lista temporal para mostrar en menu solo cooldown's en 0 (Sugerencia del profe)
        while (cerrar3 != 1){
            try{
                posicionZ = 0;
                for (int i = 0;i<zapatosMostrar.length;i++){
                    if (zapatosDisponibles[i].getCD() == 0){
                        zapatosMostrar[posicionZ] = zapatosDisponibles[i];
                        posicionZ += 1;
                    }
                }
                System.out.println("Zapatos disponibles: ");
                for(int i = 0;i<posicionZ;i++){
                    System.out.printf("\n%d-%s",i+1,zapatosMostrar[i].getNombre());
                }
                System.out.println("");
                zapatos = input.nextInt();
                input.nextLine();
                //System.out.println(posicionZ);
                if (zapatos>0 && zapatos<=posicionZ){
                    cerrar3 = 1;
                } else {
                    System.out.println("Por favor, ingrese una de las opciones");
                }
            } catch (InputMismatchException error){
                System.out.println("Por favor, ingrese una opción válida");
                input.nextLine();
            }
        }
        
        if (!(zapatosMostrar[zapatos-1].getNombre().equals("Descalzo"))){
            zapatosMostrar[zapatos - 1].setCD(cdZapatos);
        }
        
        //for (Zapatos zaps : zapatosMostrar){
        for (int k = 0;k<pantalonesDisponibles.length;k++){
            if (zapatosMostrar[zapatos-1] != zapatosDisponibles[k] && zapatosDisponibles[k].getCD()>0){
                int z = zapatosDisponibles[k].getCD();
                zapatosDisponibles[k].setCD(z-1);
                //System.out.println("Está entrando");
            }
        }
        //}
        return zapatosMostrar[zapatos - 1];
    }
    
    public void mostrarCamisa(){
        int opcion3 = 0;
        Scanner input = new Scanner(System.in);
        while(opcion3 != 1){
            try {
                System.out.println("Camisas: ");
                for (int i = 0;i<camisasDisponibles.length;i++){
                    System.out.printf("\n%d-%s",i+1,camisasDisponibles[i].getNombreC());
                }
                System.out.println("");
                opcion3 = input.nextInt();
                input.nextLine();
                if (opcion3>0 && opcion3<=camisasDisponibles.length){
                    System.out.println(camisasDisponibles[opcion3 - 1].getNombre());
                    System.out.printf("\nColor: %s\nTipo: %s\nTalla: %s\n",camisasDisponibles[opcion3-1].getColor(),camisasDisponibles[opcion3-1].getTipo(),camisasDisponibles[opcion3-1].getTalla());
                    if (camisasDisponibles[opcion3 - 1].getCD()==0){
                        System.out.println("\nSe puede usar :)\n");
                    } else if (camisasDisponibles[opcion3 - 1].getCD()>0){
                        System.out.println("\nNo se puede usar :(\n");
                    }
                    opcion3 = 1;
                } else {
                    System.out.println("Introduzca una de las opciones, por favor.");
                }
            } catch (InputMismatchException error) {
                System.out.println("Introduzca una de las opciones, por favor.");
            }
        }
    }
    
    public void mostrarPantalon(){
        int opcion3 = 0;
        Scanner input = new Scanner(System.in);
        while(opcion3 != 1){
            try {
                System.out.println("Pantalones: ");
                for (int j = 0;j<pantalonesDisponibles.length;j++){
                    System.out.printf("\n%d-%s",j+1,pantalonesDisponibles[j].getNombre());
                }
                System.out.println("");
                opcion3 = input.nextInt();
                input.nextLine();
                if (opcion3>0 && opcion3<=pantalonesDisponibles.length){
                    System.out.println(pantalonesDisponibles[opcion3-1].getNombre());
                    System.out.printf("\nTalla: %s\nCantidad de bolsillos: %s\n",pantalonesDisponibles[opcion3-1].getTalla(),pantalonesDisponibles[opcion3-1].getCantidadBolsillos());
                    if (pantalonesDisponibles[opcion3 - 1].getCD()==0){
                        System.out.println("\nSe puede usar :)\n");
                    } else if (pantalonesDisponibles[opcion3 - 1].getCD()>0){
                        System.out.println("\nNo se puede usar :(\n");
                    }
                    opcion3 = 1;
                } else {
                    System.out.println("Introduzca una de las opciones, por favor.");
                }
            } catch (InputMismatchException error) {
                System.out.println("Introduzca una de las opciones, por favor.");
            }
        }
    }
    
    public void mostrarZapatos(){
        int opcion3 = 0;
        Scanner input = new Scanner(System.in);
        while(opcion3 != 1){
            try {
                System.out.println("Zapatos: ");
                for (int k = 0;k<zapatosDisponibles.length;k++){
                    System.out.printf("\n%d-%s",k+1,zapatosDisponibles[k].getNombre());
                }
                System.out.println("");
                opcion3 = input.nextInt();
                input.nextLine();
                if (opcion3>0 && opcion3<=zapatosDisponibles.length){
                    System.out.println(zapatosDisponibles[opcion3-1].getNombre());
                    System.out.printf("\nTipo: %s\nTalla: %s\nEstado: %s/100\n",zapatosDisponibles[opcion3-1].getTipo(),zapatosDisponibles[opcion3-1].getTalla(),zapatosDisponibles[opcion3-1].getEstado());
                    if (zapatosDisponibles[opcion3 - 1].getCD()==0){
                        System.out.println("\nSe pueden usar :)\n");
                    } else if (zapatosDisponibles[opcion3 - 1].getCD()>0){
                        System.out.println("\nNo se pueden usar :(\n");
                    }
                    opcion3 = 1;
                } else {
                    System.out.println("Introduzca una de las opciones, por favor.");
                }
            } catch (InputMismatchException error) {
                System.out.println("Introduzca una de las opciones, por favor.");
            }
        }
    }
}