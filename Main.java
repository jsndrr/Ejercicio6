/**
 * CC2008 - Ejercicio 6: Dashboard Modular
 * Punto de entrada del programa.
 */
public class Main {
    public static void main(String[] args) {
        Dashboard modelo = new Dashboard();
        VistaDashboard vista = new VistaDashboard();
        ControladorDashboard controlador = new ControladorDashboard(modelo, vista);
        
        controlador.iniciarDashboard();
    }
}