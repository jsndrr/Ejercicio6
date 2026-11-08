/**
 * Widget informativo estático de notificaciones (No implementa Interactivo).
 */
public class WidgetAlerta extends Widget {
    private String mensajeAlerta;
    private String nivelSeveridad;

    public WidgetAlerta(String id, String nombre, int posX, int posY, int consumoKB, String mensaje, String severidad) {
        super(id, nombre, posX, posY, consumoKB);
        this.mensajeAlerta = mensaje;
        this.nivelSeveridad = severidad;
    }

    @Override
    public String renderizar() {
        return String.format("[ALERTA %s] %s - Msg: %s", nivelSeveridad.toUpperCase(), nombre, mensajeAlerta);
    }

    @Override
    public String toString() {
        return String.format("[Alerta] %s | Severidad: %s | Mensaje: %s", super.toString(), nivelSeveridad, mensajeAlerta);
    }
}