package grupo6.clases;

public class Ronda {
    String nro;
    private Partido[] partidos = new Partido[50000];

    public Ronda(String nro, Partido partido){
        this.nro = nro;
        this.partidos[Integer.parseInt(nro)] = partido;
    }

    int Puntos(){
        return 0;
    }
}