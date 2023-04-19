package grupo6;

import grupo6.clases.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App
{
    public static void main( String[] args ) throws IOException {

        String archivoPartidos = "C:\\xampp5\\htdocs\\cursos\\java\\tpfinal6\\src\\main\\java\\grupo6\\resultados.csv";
        String archivoPronosticos = "C:\\xampp5\\htdocs\\cursos\\java\\tpfinal6\\src\\main\\java\\grupo6\\pronosticos.csv";
        leerResultados(archivoPartidos,archivoPronosticos);

    }

    public static String leerResultados(String archivoPartidos, String archivoPronosticos) throws IOException {
        String cadena = "";
        Path f  = Paths.get(archivoPartidos);
        //System.out.println(f.toAbsolutePath());

        String[] linea;
        int goles1;
        int goles2;
        String idPartido;

        if(Files.exists(f) && Files.isReadable(f)) {
            int i = 0;
            for(String line : Files.readAllLines(f)){
                if(i>0) {
                    linea = line.split(";");
                    Equipo equipo1 = new Equipo(linea[4], linea[4]);
                    Equipo equipo2 = new Equipo(linea[4], linea[4]);
                    goles1 = Integer.parseInt(linea[2]);
                    goles2 = Integer.parseInt(linea[3]);
                    idPartido = linea[0];
                    Partido partido = new Partido(idPartido, equipo1, equipo2, goles1, goles2);
                    Ronda ronda = new Ronda(idPartido, partido);
                    buscarPronostico(archivoPronosticos, partido);
                }
                i++;
            }

        }else{
            System.out.println("Archivo " + archivoPartidos + " no existe");
        }
        return cadena;
    }

    public static boolean buscarPronostico(String archivoPronosticos, Partido partidoResultado) throws IOException {
        Pronostico pronostico = new Pronostico();
        String nroPartido = partidoResultado.getId();
        Path f  = Paths.get(archivoPronosticos);
        String[] linea;
        if(Files.exists(f) && Files.isReadable(f)) {
            int i = 0;
            for (String line : Files.readAllLines(f)) {
                if(i>0) {
                    linea = line.split(";");
                    if(nroPartido.equals(linea[0]) ) {
                        if (linea[2].trim().equals("X")) {
                            Equipo equipoPronostico = new Equipo(linea[1], linea[1]);
                            ResultadoEnum resultadoPronostico = ResultadoEnum.GANADOR;
                            pronostico.setPronostico(partidoResultado, equipoPronostico, resultadoPronostico);
                        }
                        if (linea[3].trim().equals("X")) {
                            Equipo equipoPronostico = new Equipo(linea[1], linea[1]);
                            ResultadoEnum resultadoPronostico = ResultadoEnum.EMPATE;
                            pronostico.setPronostico(partidoResultado, equipoPronostico, resultadoPronostico);
                        }
                        if (linea[4].trim().equals("X") ) {
                            Equipo equipoPronostico = new Equipo(linea[1], linea[1]);
                            ResultadoEnum resultadoPronostico = ResultadoEnum.PERDEDOR;
                            pronostico.setPronostico(partidoResultado, equipoPronostico, resultadoPronostico);
                        }
                        pronostico.comprobarAcierto();
                    }
                }
                i++;
            }
            System.out.println("Total Puntos Obtenidos: " + Integer.toString(pronostico.puntos()));
        }else{
            System.out.println("Archivo " + archivoPronosticos + " no existe");
        }

        return false;
    }
}
