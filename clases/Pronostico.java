package grupo6.clases;

public class Pronostico {

    Partido partido;
    Equipo equipo;
    ResultadoEnum resultado;

    Equipo equipoRealGanador;
    ResultadoEnum resultadoReal;


    int puntos;

    public Pronostico(){}
    public void setPronostico(Partido partido, Equipo equipo, ResultadoEnum resultado){
        this.partido = partido;
        this.equipo = equipo;
        this.resultado = resultado;
    }
    public void comprobarAcierto(){



        if(this.partido.golesEquipo1 == this.partido.golesEquipo2 ){
            this.equipoRealGanador = new Equipo(this.equipo.nombre,this.equipo.descripcion);
            this.resultadoReal = ResultadoEnum.EMPATE;
        }else{
            if(this.partido.golesEquipo1 > this.partido.golesEquipo2 ) {
                this.resultadoReal = ResultadoEnum.GANADOR;
                this.equipoRealGanador = new Equipo(this.equipo.nombre,this.equipo.descripcion);
            }else{
                this.resultadoReal = ResultadoEnum.PERDEDOR;
                this.equipoRealGanador = new Equipo(this.equipo.nombre,this.equipo.descripcion);
            }
        }

        if(this.resultado.equals(this.resultadoReal) && this.equipoRealGanador.nombre.equals(this.equipo.nombre) ){
            this.puntos++;
        }
    }
    public int puntos(){
        return this.puntos;
    }
}