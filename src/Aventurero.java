public class Aventurero {
    private String nombreAve;
    private int hpAv ; 
    private int hpMaximaAv ; 
    private int danioBaseAv;
    private int cantPociones;
    private static int CURACION_POCION = 20 ;

    public Aventurero (String nombreAve , int hpAv , int hpMaxima , int danioBaseAv , int cantPociones){
        this.nombreAve = nombreAve;
        this.hpAv = hpAv ; 
        this.hpMaximaAv = hpMaxima ;
        this.danioBaseAv = danioBaseAv ; 
        this.cantPociones = cantPociones;

    }

    public void atacar(Enemigo enemigo, int danio){
        danio += danioBaseAv ; 
        enemigo.recibirDanio(danio);
    }

    public void beberPocion(){
        if ( cantPociones > 0 ){
            cantPociones -= 1 ; 
            System.out.println("Glu glu glu");

            hpAv += CURACION_POCION ; 
            System.out.println("Hp actuales: "+ hpAv );
        }else{
            System.out.println("No te quedan pociones");
        }

    }
    
    public void recibirDanioAv(int danio){
        hpAv -= danio ; 
    }

    public boolean estaCaido(){
        boolean derrotado = false ;
        if (hpAv <= 0 ){
            derrotado = true ; 
        }
        return derrotado; 

    }


}
