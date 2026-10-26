public class Enemigo {
    private String nombreEne ;
    private int hp ; 
    private int hpMaxima;
    private int danioBase;

    public void estableceHp(){
        hp = hpMaxima;

    }
    public void recibirDanio(int danioBase){
        hp -= danioBase ; 
    }
    public boolean estaDerrotado(){
        boolean derrotado = false ;
        if (hp <= 0){
            derrotado = true ;
        }
        return derrotado;
    }
    public void atacarEnemig(Aventurero aventurero){
        int danio = danioBase ;
        aventurero.recibirDanioAv(danio);
    }
    public Enemigo (String nombreEne , int hp , int hpMaxima , int danioBase){
        this.nombreEne = nombreEne ; 
        this.hp = hp ;
        this.hpMaxima = hpMaxima ; 
        this.danioBase = danioBase ; 

    }


}
