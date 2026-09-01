# PP_TP1 - Sistema de Gestión de Eventos Universitarios

Trabajo Práctico N° 1 de Paradigmas de Programación (UTN - FRM), Unidad 1: Fundamentos de la POO e implementación básica en Java.

## Descripción

El sistema modela la gestión de eventos universitarios (charlas, talleres, hackathones, etc.), permitiendo asignarles una sala, registrar sus actividades, inscribir estudiantes en cada actividad y calcular el costo estimado de cada evento. El modelo integra los conceptos de encapsulamiento, relaciones entre objetos (asociación, agregación y composición), herencia y polimorfismo.

## Estructura de clases

| Clase | Tipo | Descripción |
|---|---|---|
| `Estudiante` | Concreta | Representa a un estudiante inscripto en actividades (legajo, nombre). |
| `Sala` | Concreta | Espacio físico asignado a un evento (id, nombre). |
| `Inscripcion` | Concreta | Vincula un `Estudiante` con una `Actividad`, con fecha y estado. |
| `Actividad` | Abstracta | Base común de toda actividad de un evento (id, título, cupo máximo, inscripciones). Define el método final `mostrarIdentificacion()` y los métodos abstractos `calcularCostoMateriales()` y `getTipo()`. |
| `Charla` | Concreta (extiende `Actividad`) | Actividad sin costo de materiales, con un disertante. |
| `Taller` | Concreta (extiende `Actividad`) | Actividad con costo de materiales según si requiere notebook ($5000) o no ($2000). |
| `EventoUniversitario` | Concreta | Agrupa una `Sala` (agregación) y una lista de `Actividad` (composición). Lleva el contador estático de eventos creados. |
| `App` | Clase principal | Contiene el método `main()` con la ejecución de prueba del sistema. |

## Relaciones entre clases

- **Composición**: `EventoUniversitario` — `Actividad`. Las actividades no existen sin el evento que las contiene.
- **Agregación**: `EventoUniversitario` — `Sala`. La sala existe independientemente del evento.
- **Asociación**: `Actividad` — `Inscripcion` — `Estudiante`. Cada inscripción vincula una actividad con un estudiante.
- **Herencia**: `Charla` y `Taller` extienden `Actividad`, que es una clase abstracta.

## Funcionalidad implementada

- Creación de eventos universitarios y copia mediante constructor de copia.
- Asignación de sala a un evento.
- Creación de actividades de tipo Charla y Taller mediante sobrecarga del método `crearActividad`.
- Cálculo del costo estimado del evento: si es gratuito, el costo es cero; en caso contrario, `(costoBase + costo de materiales de sus actividades) * 1.21`.
- Inscripción de estudiantes en actividades, generando un objeto `Inscripcion` por cada inscripción.
- Visualización de datos del evento y de sus actividades de forma polimórfica.
- Contador estático de eventos creados (`cantidadEventos`).

## Cómo ejecutar el proyecto

1. Clonar el repositorio.
2. Abrir el proyecto en IntelliJ IDEA.
3. Ejecutar la clase `App` (contiene el método `main`).

También puede compilarse y ejecutarse por línea de comandos desde la carpeta donde estén los archivos `.java`:

```bash
javac *.java
java App
```

## Mapa de memoria

En la carpeta del repositorio se incluye la imagen del mapa de memoria de ejecución, que representa los objetos creados en el heap y las variables locales del `main()` en el stack, junto con las relaciones de asociación, agregación, composición y herencia entre ellos, para el siguiente escenario:

- 3 estudiantes creados.
- 1 evento creado, con 1 sala asignada.
- 2 actividades del evento: una Charla y un Taller.
- 2 estudiantes inscriptos en la Charla y 2 estudiantes inscriptos en el Taller.

## Captura de ejecución

Se incluye en el repositorio una captura de la salida por consola de una ejecución del programa.

## Autor

Legajo: _(completar)_
