import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Widget de reloj con actualización continua.
 */
public class WidgetReloj extends Widget implements Interactivo {
    private boolean formato24h;
    private String zonaHoraria;

    public WidgetReloj(String id, String nombre, int posX, int posY, int consumoKB, boolean formato24h, String zonaHoraria) {
        super(id, nombre, posX, posY, consumoKB);
        this.formato24h = formato24h;
        this.zonaHoraria = zonaHoraria;
    }

    @Override
    public String renderizar() {
        String patron = formato24h ? "HH:mm:ss" : "hh:mm:ss a";
        String horaActual = LocalTime.now().format(DateTimeFormatter.ofPattern(patron));
        return String.format("[RELOJ] %s (%s) - Hora: %s", nombre, zonaHoraria, horaActual);
    }

    @Override
    public String hacerClic() {
        this.formato24h = !formato24h;
        return "Cambiado formato de hora a: " + (formato24h ? "24 Horas" : "12 Horas (AM/PM)");
    }

    @Override
    public String actualizar() {
        return "Reloj sincronizado con servidor NTP (" + zonaHoraria + ").";
    }

    @Override
    public String toString() {
        return String.format("[Reloj] %s | Zona: %s | Formato 24h: %s", super.toString(), zonaHoraria, (formato24h ? "Sí" : "No"));
    }
}