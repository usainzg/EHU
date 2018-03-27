package test;

/**
 * @author PMOO 2018:
 *
 */

import javax.swing.JOptionPane;

import clases.Inventario;
import clases.Producto;
import excepciones.ProductoInexistenteException;
import gui.VentanaProductoBasica;

public class Test {

    /**
     * Se probaran algunos de los m�todos definidos en el TAD Producto y singleton
     * Inventario. COMPLETALO SEG�N CREAS NECESARIO
     *
     * @param args
     *            ninguno
     */
    public static void main(String[] args) {
        System.out.println();


        // 1. COMPLETA
        System.out.println("\n-1---------------------------------------------------------------\n");
        System.out.println("OBTENIENDO INSTANCIA DE INVENTARIO...");
        Inventario inventario = Inventario.getInstance();

        System.out.println();


        // 2. COMPLETA
        System.out.println("\n-2---------------------------------------------------------------\n");

        inventario.cargarProductosDelFichero();
        inventario.mostrarProductos();

        System.out.println();


        // 3. COMPLETA
        System.out.println("\n-3---------------------------------------------------------------\n");

        VentanaProductoBasica ventanaProducto = new VentanaProductoBasica();
        ventanaProducto.setModal(true);
        ventanaProducto.setVisible(true);

        if (ventanaProducto.pulsadoGuardar()) {

            try {
                // NOTA: se reemplazan los caracteres vacios con guiones
                int codigoP = Inventario.getInstance().getCodigoParaNuevoProducto();
                String nombreP = ventanaProducto.getTxtNombre().replace(" ", "-");
                double precioP = ventanaProducto.getTxtPrecio();
                int cantidadP = ventanaProducto.getTxtCantidad();
                double pesoP = ventanaProducto.getTxtPeso();

                Producto producto = new Producto(codigoP, nombreP, cantidadP, precioP, pesoP);
                boolean guardadoProducto = inventario.incluirNuevoProducto(producto);
                if (guardadoProducto) {
                    JOptionPane.showMessageDialog(ventanaProducto,
                            "Producto de codigo " + producto.getCodigoProducto() + " incluido en el inventario.");
                } else {
                    JOptionPane.showMessageDialog(ventanaProducto,
                            "No se ha podido guardar el producto, intentelo de nuevo.");
                }

            } catch (Inventario.CantidadNoPositivaException e) {
                e.SacarError();
            }
        }
        ventanaProducto.dispose(); // Haga click en "Guardar" o "Cancelar"

        inventario.mostrarProductos();
        System.out.println();


        // 4. COMPLETA
        System.out.println("\n-4----------------------------------------------------------------\n");

        inventario.mostrarProductos();
        System.out.println();

        Producto productoExistente = new Producto("unai sainz");
        boolean actualizadoExiste = false;
        try {
            actualizadoExiste = inventario.actualizarCantidadProducto(productoExistente, 100);
        } catch (ProductoInexistenteException e) {
            e.SacarError();
        } catch (Inventario.CantidadNoPositivaException e) {
            e.SacarError();
        }

        Producto productoNoExistente = new Producto("unaitxo");
        boolean actualizadoNoExistente = false;
        try {
            actualizadoNoExistente = inventario.actualizarCantidadProducto(productoNoExistente, 100);
        } catch (ProductoInexistenteException e) {
            e.SacarError();
        } catch (Inventario.CantidadNoPositivaException e) {
            e.SacarError();
        }

        System.out.println("EXISTENTE: " + ((actualizadoExiste) ? "actualizado" : "no actualizado"));
        System.out.println();
        System.out.println("NO EXISTENTE: " + ((actualizadoNoExistente) ? "actualizado" : "no actualizado"));
        System.out.println();

        inventario.mostrarProductos();


        // 5. COMPLETA
        System.out.println("\n-5----------------------------------------------------------------\n");

        try {
            System.out.println(inventario.getProducto(productoExistente));
        } catch (Inventario.CantidadNoPositivaException e) {
            e.SacarError();
        } catch (ProductoInexistenteException e) {
            e.SacarError();
        }

        try {
            inventario.getProducto(productoNoExistente);
        } catch (Inventario.CantidadNoPositivaException e) {
            e.SacarError();
        } catch (ProductoInexistenteException e) {
            e.SacarError();
        }

        System.out.println();
        System.out.println("\n-6----------------------------------------------------------------\n");


        // 6. COMPLETA
        inventario.guardarProductosEnFichero();

        // 7. COMPLETA
        System.out.println("\n-7----------------------------------------------------------------\n");

        System.out.println("IMPRIMIR PRODUCTO: ");
        try {
            inventario.getProducto(productoExistente).imprimirProducto();
        } catch (Inventario.CantidadNoPositivaException e) {
            e.SacarError();
        } catch (ProductoInexistenteException e) {
            e.SacarError();
        }

        System.out.println();
        System.out.println("IMPRIMIR ENVIABLE");
        try {
            inventario.getProducto(productoExistente).imprimirEnviable();
        } catch (Inventario.CantidadNoPositivaException e) {
            e.SacarError();
        } catch (ProductoInexistenteException e) {
            e.SacarError();
        }
    }
}
