/**
 * Widget interactivo de visualización del clima.
 */
public class WidgetClima extends Widget implements Interactivo {
    private String ciudad;
    private double temperatura;

    public WidgetClima(String id, String nombre, int posX, int posY, int consumoKB, String ciudad, double temperatura) {
        super(id, nombre, posX, posY, consumoKB);
        this.ciudad = ciudad;
        this.temperatura = temperatura;
    }

    @Override
    public String renderizar() {
        return String.format("[WIDGET CLIMA] %s - Ciudad: %s | Temp: %.1f°C", nombre, ciudad, temperatura);
    }

    @Override
    public String hacerClic() {
        return "Abriendo pronóstico extendido de 7 días para " + ciudad + "...";
    }

    @Override
    public String actualizar() {
        this.temperatura += (Math.random() * 2 - 1); // Simulación de cambio térmico
        return "Clima actualizado en tiempo real para " + ciudad + ". Nueva temp: " + String.format("%.1f°C", temperatura);
    }

    @Override
    public String toString() {
        return String.format("[Clima] %s | Ciudad: %s | Temp: %.1f°C", super.toString(), ciudad, temperatura);
    }
}