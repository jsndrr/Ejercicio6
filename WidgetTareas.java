import java.util.ArrayList;

/**
 * Widget interactivo de lista de tareas pendientes.
 */
public class WidgetTareas extends Widget implements Interactivo {
    private ArrayList<String> listaTareas;

    public WidgetTareas(String id, String nombre, int posX, int posY, int consumoKB) {
        super(id, nombre, posX, posY, consumoKB);
        this.listaTareas = new ArrayList<>();
    }

    public void agregarTarea(String tarea) {
        if (tarea != null && !tarea.trim().isEmpty()) {
            listaTareas.add(tarea.trim());
        }
    }

    @Override
    public String renderizar() {
        return String.format("[WIDGET TAREAS] %s - Pendientes: %d tarea(s)", nombre, listaTareas.size());
    }

    @Override
    public String hacerClic() {
        if (listaTareas.isEmpty()) {
            return "No hay tareas pendientes en la lista '" + nombre + "'.";
        }
        String completada = listaTareas.remove(0);
        return "Tarea completada y removida: '" + completada + "'.";
    }

    @Override
    public String actualizar() {
        return "Sincronizando tareas pendientes con el servidor...";
    }

    @Override
    public String toString() {
        return String.format("[Tareas] %s | Tareas Activas: %d", super.toString(), listaTareas.size());
    }
}