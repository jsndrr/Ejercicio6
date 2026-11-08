/**
 * CC2008 - Ejercicio 6: Dashboard Modular
 * Clase abstracta base de todos los widgets.
 * Implementa Comparable para ordenar por consumo de memoria (KB).
 */
public abstract class Widget implements Renderizable, Comparable<Widget> {
    protected String id;
    protected String nombre;
    protected int posicionX;
    protected int posicionY;
    protected int consumoMemoriaKB;

    public Widget(String id, String nombre, int posicionX, int posicionY, int consumoMemoriaKB) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID del widget no puede estar vacío.");
        }
        if (consumoMemoriaKB <= 0) {
            throw new IllegalArgumentException("El consumo de memoria debe ser mayor a cero.");
        }
        this.id = id.trim();
        this.nombre = nombre != null ? nombre.trim() : "";
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.consumoMemoriaKB = consumoMemoriaKB;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public int getPosicionX() { return posicionX; }
    public int getPosicionY() { return posicionY; }
    public int getConsumoMemoriaKB() { return consumoMemoriaKB; }

    /**
     * Criterio de ordenamiento natural por consumo de memoria (KB) de menor a mayor.
     */
    @Override
    public int compareTo(Widget otro) {
        return Integer.compare(this.consumoMemoriaKB, otro.consumoMemoriaKB);
    }

    @Override
    public String toString() {
        return String.format("ID: %-8s | Nombre: %-20s | Pos: (%2d, %2d) | Memoria: %4d KB",
                id, nombre, posicionX, posicionY, consumoMemoriaKB);
    }
}