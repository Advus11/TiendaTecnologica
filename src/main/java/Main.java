
public class Main {
    public static void main(String[] args) {
        Tienda tienda = new Tienda();
        tienda.cargarCatalogoDesdeArchivo(); // Cargar el catálogo desde el archivo al iniciar la aplicación
        tienda.inicializar();
        tienda.guardarCatalogoEnArchivo(); // Guardar el catálogo en el archivo al finalizar la aplicación
    }
}