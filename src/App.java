import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        Estudiante e1 = new Estudiante("1001", "Ana Gomez");
        Estudiante e2 = new Estudiante("1002", "Bruno Diaz");
        Estudiante e3 = new Estudiante("1003", "Carla Ruiz");

        List<Estudiante> estudiantes = new ArrayList<>();
        estudiantes.add(e1);
        estudiantes.add(e2);
        estudiantes.add(e3);

        Sala sala1 = new Sala(1, "Aula de Computación");

        EventoUniversitario hackathon = new EventoUniversitario("EV001", "Hackathon UTN", 10000, false);
        hackathon.asignarSala(sala1);
        hackathon.crearActividad(1, "Charla de apertura", 100, "Charla", "Ing. Roberto Sosa");
        hackathon.crearActividad(2, "Taller de Java", 30, "Taller", true);

        List<Actividad> actividadesHackathon = hackathon.getActividades();
        Actividad charla = actividadesHackathon.get(0);
        Actividad taller = actividadesHackathon.get(1);

        charla.inscribir(e1);
        charla.inscribir(e2);
        taller.inscribir(e2);
        taller.inscribir(e3);

        EventoUniversitario jornada = new EventoUniversitario("CABJ1905", "Jornada de Puertas Abiertas", 0, true);
        EventoUniversitario copiaJornada = new EventoUniversitario(jornada);

        System.out.println("===== Evento Hackathon =====");
        hackathon.mostrarDatos();
        charla.mostrarInscripciones();
        taller.mostrarInscripciones();

        System.out.println();
        System.out.println("===== Evento Jornada =====");
        jornada.mostrarDatos();

        System.out.println();
        System.out.println("===== Copia del Evento Jornada =====");
        copiaJornada.mostrarDatos();

        System.out.println();
        System.out.println("Total de eventos creados: " + EventoUniversitario.getCantidadEventos());
    }
}