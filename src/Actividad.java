import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Actividad {
    public static final int CUPO_MINIMO = 5;
    private int id;
    private String titulo;
    private int cupoMaximo;
    private List<Inscripcion> inscripciones;

    public Actividad(int id, String titulo, int cupoMaximo) {
        this.id = id;
        this.titulo = titulo;
        this.cupoMaximo = cupoMaximo;
        this.inscripciones = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public void setCupoMaximo(int cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(List<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }

    public Inscripcion inscribir(Estudiante estudiante) {
        Inscripcion inscripcion = new Inscripcion(LocalDate.now(), "Confirmada", estudiante, this);
        inscripciones.add(inscripcion);
        return inscripcion;
    }

    public void mostrarInscripciones() {
        System.out.println("Inscripciones de la actividad " + titulo + ":");
        for (Inscripcion i : inscripciones) {
            System.out.println("- " + i.getEstudiante().getNombre() + " (legajo " + i.getEstudiante().getLegajo() + ") - " + i.getEstado() + " - " + i.getFecha());
        }
    }

    public final void mostrarIdentificacion() {
        System.out.println(getTipo() + " #" + id + ": " + titulo + " (cupo maximo " + cupoMaximo + ")");
    }

    public abstract double calcularCostoMateriales();

    public abstract String getTipo();
}