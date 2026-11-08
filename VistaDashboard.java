import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Componente Vista (MVC) encargado exclusivamente de la consola.
 */
public class VistaDashboard {
    private Scanner scanner;

    public VistaDashboard() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarMenuPrincipal() {
        System.out.println("\n=== DASHBOARD MODULAR - MENÚ PRINCIPAL ===");
        System.out.println("1. Listar y renderizar todos los widgets activos");
        System.out.println("2. Buscar widget por ID o Nombre");
        System.out.println("3. Ordenar widgets por consumo de memoria (KB)");
        System.out.println("4. Interactuar con un widget (Clic / Actualizar)");
        System.out.println("5. Salir");
    }

    public void mostrarWidgets(ArrayList<Widget> widgets) {
        if (widgets == null || widgets.isEmpty()) {
            System.out.println("No hay widgets para mostrar.");
            return;
        }
        System.out.println("-------------------------------------------------------------------------------------------------");
        for (Widget w : widgets) {
            System.out.println(w.toString() + " | Render -> " + w.renderizar());
        }
        System.out.println("-------------------------------------------------------------------------------------------------");
    }

    public String pedirTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine().trim();
    }

    public int pedirEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                int val = scanner.nextInt();
                scanner.nextLine();
                return val;
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un entero válido.");
                scanner.nextLine();
            }
        }
    }
}