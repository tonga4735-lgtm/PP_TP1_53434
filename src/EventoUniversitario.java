import java.util.ArrayList;
import java.util.List;

public class EventoUniversitario {

    private static int cantidadEventos = 0;

    private final String id;
    private String titulo;
    private double costoBase;
    private boolean gratuito;
    private Sala sala;
    private List<Actividad> actividades;

    public EventoUniversitario(String id, String titulo, double costoBase, boolean gratuito) {
        this.id = id;
        this.titulo = titulo;
        this.costoBase = costoBase;
        this.gratuito = gratuito;
        this.actividades = new ArrayList<>();
        cantidadEventos++;
    }

    public EventoUniversitario(EventoUniversitario otro) {
        this.id = otro.id;
        this.titulo = otro.titulo;
        this.costoBase = otro.costoBase;
        this.gratuito = otro.gratuito;
        this.sala = otro.sala;
        this.actividades = new ArrayList<>(otro.actividades);
        cantidadEventos++;
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getCostoBase() {
        return costoBase;
    }

    public void setCostoBase(double costoBase) {
        this.costoBase = costoBase;
    }

    public boolean isGratuito() {
        return gratuito;
    }

    public void setGratuito(boolean gratuito) {
        this.gratuito = gratuito;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }

    public static int getCantidadEventos() {
        return cantidadEventos;
    }

    public static void setCantidadEventos(int cantidadEventos) {
        EventoUniversitario.cantidadEventos = cantidadEventos;
    }

    public double calcularCostoEstimado() {
        if (gratuito) {
            return 0;
        }
        double costoActividades = 0;
        for (Actividad actividad : actividades) {
            costoActividades += actividad.calcularCostoMateriales();
        }
        return (costoBase + costoActividades) * 1.21;
    }

    public void asignarSala(Sala sala) {
        this.sala = sala;
    }

    public void crearActividad(int id, String titulo, int cupo, String tipo, String disertante) {
        Actividad actividad = new Charla(id, titulo, cupo, disertante);
        actividades.add(actividad);
    }

    public void crearActividad(int id, String titulo, int cupo, String tipo, boolean requiereNotebook) {
        Actividad actividad = new Taller(id, titulo, cupo, requiereNotebook);
        actividades.add(actividad);
    }

    public void mostrarDatos() {
        System.out.println("Evento: " + titulo + " (id " + id + ")");
        System.out.println("Costo base: " + costoBase);
        System.out.println("Gratuito: " + gratuito);
        System.out.println("Costo estimado: " + calcularCostoEstimado());
        if (sala != null) {
            System.out.println("Sala: " + sala.getNombre() + " (id " + sala.getId() + ")");
        }
        System.out.println("Actividades:");
        for (Actividad actividad : actividades) {
            actividad.mostrarIdentificacion();
        }
    }
}