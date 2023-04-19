package grupo6.clases;

import static grupo6.clases.ResultadoEnum.GANADOR;

public class Partido {

    String idPartido;
    Equipo equipo1;
    Equipo equipo2;
    int golesEquipo1;
    int golesEquipo2;

    public Partido(String idPartido, Equipo equipo1, Equipo equipo2, int goles1, int goles2){
        this.idPartido = idPartido;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEquipo1 = goles1;
        this.golesEquipo2 = goles2;
    }

    public String getId(){
        return this.idPartido;
    }

    ResultadoEnum resultado(Equipo equipo){
        ResultadoEnum resultado;
        resultado = GANADOR;
        return resultado;
    }

}
