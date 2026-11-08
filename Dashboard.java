import java.util.ArrayList;
import java.util.Collections;

/**
 * Modelo que gestiona la lista polimórfica única de widgets en memoria.
 */
public class Dashboard {
    private ArrayList<Widget> catalogoWidgets;

    public Dashboard() {
        this.catalogoWidgets = new ArrayList<>();
        precargarWidgets();
    }

    /**
     * Carga inicial obligatoria de al menos 10 widgets de naturaleza diversa.
     */
    public final void precargarWidgets() {
        catalogoWidgets.add(new WidgetClima("WID-01", "Clima Capital", 0, 0, 1024, "Guatemala", 23.5));
        catalogoWidgets.add(new WidgetClima("WID-02", "Clima Xela", 0, 1, 980, "Quetzaltenango", 14.0));
        
        WidgetTareas t1 = new WidgetTareas("WID-03", "Pendientes UVG", 1, 0, 2048);
        t1.agregarTarea("Entregar Ejercicio 6 POO");
        t1.agregarTarea("Estudiar para examen de Física");
        catalogoWidgets.add(t1);

        WidgetTareas t2 = new WidgetTareas("WID-04", "Compras Oficina", 1, 1, 1500);
        t2.agregarTarea("Comprar cable HDMI");
        catalogoWidgets.add(t2);

        catalogoWidgets.add(new WidgetAlerta("WID-05", "Alerta Servidor", 2, 0, 512, "CPU al 92% de capacidad", "Crítica"));
        catalogoWidgets.add(new WidgetAlerta("WID-06", "Aviso Mantenimiento", 2, 1, 256, "Reinicio programado a las 23:00", "Informativa"));
        catalogoWidgets.add(new WidgetAlerta("WID-07", "Notificación Backup", 2, 2, 384, "Copia de seguridad completada", "Baja"));

        catalogoWidgets.add(new WidgetReloj("WID-08", "Reloj Principal", 3, 0, 768, true, "CST"));
        catalogoWidgets.add(new WidgetReloj("WID-09", "Reloj Londres", 3, 1, 768, false, "GMT"));
        catalogoWidgets.add(new WidgetReloj("WID-10", "Reloj Tokio", 3, 2, 800, true, "JST"));
    }

    public ArrayList<Widget> getCatalogoWidgets() { return catalogoWidgets; }

    // --- OVERLOADING DE BÚSQUEDA ---

    public Widget buscarWidget(String id) {
        if (id == null) return null;
        for (Widget w : catalogoWidgets) {
            if (w.getId().equalsIgnoreCase(id.trim())) return w;
        }
        return null;
    }

    public ArrayList<Widget> buscarWidget(String nombre, boolean porNombre) {
        ArrayList<Widget> resultados = new ArrayList<>();
        if (nombre == null) return resultados;
        for (Widget w : catalogoWidgets) {
            if (porNombre && w.getNombre().toLowerCase().contains(nombre.trim().toLowerCase())) {
                resultados.add(w);
            }
        }
        return resultados;
    }

    /**
     * Ordena la lista polimórfica usando Comparable (por consumo de memoria KB).
     */
    public void ordenarWidgetsPorMemoria() {
        Collections.sort(catalogoWidgets);
    }
}