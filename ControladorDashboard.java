import java.util.ArrayList;

/**
 * Controlador (MVC) que administra el flujo del Dashboard.
 */
public class ControladorDashboard {
    private Dashboard modeloDashboard;
    private VistaDashboard vista;

    public ControladorDashboard(Dashboard modeloDashboard, VistaDashboard vista) {
        this.modeloDashboard = modeloDashboard;
        this.vista = vista;
    }

    public void iniciarDashboard() {
        vista.mostrarMensaje("¡Motor Lógico del Dashboard Modular Iniciado!");
        boolean salir = false;

        while (!salir) {
            vista.mostrarMenuPrincipal();
            int opcion = vista.pedirEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1 -> vista.mostrarWidgets(modeloDashboard.getCatalogoWidgets());
                case 2 -> manejarBusqueda();
                case 3 -> {
                    modeloDashboard.ordenarWidgetsPorMemoria();
                    vista.mostrarMensaje("¡Widgets ordenados exitosamente por consumo de memoria KB (menor a mayor)!");
                    vista.mostrarWidgets(modeloDashboard.getCatalogoWidgets());
                }
                case 4 -> interactuarConWidget();
                case 5 -> {
                    salir = true;
                    vista.mostrarMensaje("Finalizando sesión del Dashboard Modular... ¡Hasta luego!");
                }
                default -> vista.mostrarMensaje("Opción fuera de rango (1-5).");
            }
        }
    }

    private void manejarBusqueda() {
        vista.mostrarMensaje("\n--- BÚSQUEDA DE WIDGETS ---");
        vista.mostrarMensaje("1. Buscar por ID exacto");
        vista.mostrarMensaje("2. Buscar por Nombre (coincidencia parcial)");
        int subOpcion = vista.pedirEntero("Seleccione método: ");

        if (subOpcion == 1) {
            String id = vista.pedirTexto("Ingrese el ID del widget: ");
            Widget w = modeloDashboard.buscarWidget(id);
            if (w != null) {
                vista.mostrarMensaje("\nWidget encontrado:\n" + w.toString() + "\nRender: " + w.renderizar());
            } else {
                vista.mostrarMensaje("No existe ningún widget con el ID '" + id + "'.");
            }
        } else if (subOpcion == 2) {
            String nombre = vista.pedirTexto("Ingrese el nombre a buscar: ");
            ArrayList<Widget> resultados = modeloDashboard.buscarWidget(nombre, true);
            vista.mostrarWidgets(resultados);
        } else {
            vista.mostrarMensaje("Opción de búsqueda no válida.");
        }
    }

    private void interactuarConWidget() {
        vista.mostrarMensaje("\n--- INTERACTUAR CON WIDGET ---");
        String id = vista.pedirTexto("Ingrese el ID del widget: ");
        Widget w = modeloDashboard.buscarWidget(id);

        if (w == null) {
            vista.mostrarMensaje("Error: El widget especificado no existe.");
            return;
        }

        // Verificación polimórfica vía Interfaz (ISP)
        if (w instanceof Interactivo) {
            Interactivo widgetInteractivo = (Interactivo) w;
            vista.mostrarMensaje("1. Hacer Clic");
            vista.mostrarMensaje("2. Actualizar estado");
            int accion = vista.pedirEntero("Seleccione acción: ");

            if (accion == 1) {
                vista.mostrarMensaje("Resultado Clic: " + widgetInteractivo.hacerClic());
            } else if (accion == 2) {
                vista.mostrarMensaje("Resultado Actualizar: " + widgetInteractivo.actualizar());
            } else {
                vista.mostrarMensaje("Acción no válida.");
            }
        } else {
            vista.mostrarMensaje("El widget '" + w.getNombre() + "' es estático/informativo y no soporta interacción.");
        }
    }
}