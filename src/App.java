import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static Scanner sc = new Scanner(System.in);

    public static int lecturaSegura(){
        boolean repetir = true  ; 
        int respuesta = 0 ;
        do {
            repetir = false ; 
            try {
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
        System.out.print("Intrdocue tu nombre");
        String nombre = sc.nextLine();
        int opcion  ;
        int danio ; 
        Aventurero av1 = new Aventurero(nombre, 40, 40, 10, 4); 
        Enemigo en1 = new Enemigo("Dragón malo", 0, 100, 10);
        while (en1.estaDerrotado() == false && av1.estaCaido() == false) {
            opcion = lecturaSegura();
            switch (opcion) {
                case 1:
                    System.out.println("Atacar con arma: 1");
                    danio = tirarDado20();
                    if ( danio == 1){
                        System.out.println("Fallo");
                    } else if ( danio == 20 ){
                        danio = 40 ; 
                        av1.atacar(en1, danio);
                    } else {
                        av1.atacar(en1, danio);
                    }
                    break;
                case 2: 
                    System.out.println("Beber poción");
                    av1.beberPocion();
                default:
                    break;
            }
            if ( en1.estaDerrotado()== false){
                en1.atacarEnemig(av1);
            }
        
        }
        System.out.println("Fin de la partida");
    }
}
