import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static Scanner sc = new Scanner(System.in);

    public static int lecturaSegura(String frase){
        boolean repetir = true  ; 
        int respuesta = 0 ;
        do {
            repetir = false ; 
            try {
                System.out.print(frase );
                respuesta = sc.nextInt() ; 

                if ( respuesta <= 0 ) {
                    repetir = true ; 
                    System.out.println("Introduce un número entero positivo");
                } 
            } catch (InputMismatchException ex) {
                System.out.println("Error, introduce un caracter válido");
                repetir = true ; 
                sc.next();
            }
        } while (repetir);
        return respuesta ;
    }

    private static int tirarDado20() { 
        Random dado = new Random(); 
        return dado.nextInt(20) + 1; 
    } 

    public static void main(String[] args) throws Exception {
        System.out.println("Bienvenido al encuentro en la guaridad del dragón");
        System.out.print("Intrdocue tu nombre: ");
        String nombre = sc.nextLine();
        int opcion  ;
        int danio ; 
        boolean pasarTurno;
        Aventurero av1 = new Aventurero(nombre, 40, 40, 10, 4); 
        Enemigo en1 = new Enemigo("Dragón malo", 100, 100, 10);

        while (en1.estaDerrotado() == false && av1.estaCaido() == false) {
            pasarTurno = true ;
            System.out.println("Elige opción: ");
            System.out.println("1. Atacar");
            System.out.println("2. Beber poción");
            System.out.println("3. Iventario y datos");
            opcion = lecturaSegura("Elige : ");
            System.out.println("---------------");
            

            switch (opcion) {
                case 1:
                    System.out.println("Atacar con arma");
                    danio = tirarDado20();
                    
                    if ( danio == 1){
                        System.out.println("Fallo");
                    } else if ( danio == 20 ){
                        System.out.println("CRITICO !!!");
                        danio = 40 ; 
                        av1.atacar(en1, danio);
                    } else {
                        av1.atacar(en1, danio);
                    }
                    System.out.println("Daño: "+ danio);
                    System.out.printf("Vida de %s : %d \n", en1.getNombreEne() , en1.getHp()); 
                    break;
                case 2: 
                    System.out.println("Beber poción");
                    av1.beberPocion();
                    break;
                case 3:
                    pasarTurno = false ; 
                    System.out.println("====================");
                    System.out.printf("Estado de %s: HP: %d  Pociones: %d \n", av1.getNombreAve(), av1.getHpAv(), av1.getCantPociones() );
                    System.out.printf("Estado de %s: HP: %d \n", en1.getNombreEne(), en1.getHp());
                    System.out.println("====================");
                    break;
                default:
                    System.out.println("Elija una opcion válida ");
                    System.out.println("------------------------");
                    pasarTurno = false ; 
                    break;
            }
            if ( en1.estaDerrotado()== false && pasarTurno == true ){
                System.out.println("============ \n Turno del dragón");
                System.out.printf("El %s ataca", en1.getNombreEne());
                en1.atacarEnemig(av1);
            }
            en1.estaDerrotado();
            av1.estaCaido();
        }
        if ( en1.getHp() <= 0 ){
            System.out.println("GG wp ");
        }
        if ( av1.getHpAv() <= 0 ){
            System.out.println("L looser");
        }
        System.out.println("Fin de la partida");
    }
}
// TODO podria meterse un mirar mochila, estado del jugador etc que no consuma turnos de

// setters : para manipular atributos desde fuera.
// Se puede hacer con herencia ya que hay mucho código común