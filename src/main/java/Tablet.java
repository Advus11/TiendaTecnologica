import java.util.List;

public class Tablet extends DispositivoTecnologico {
    private String resolucionPantalla;
    private List<String> accesoriosIncorporados;

    public Tablet(String marca, int memoriaRAM, int memoriaAlmacenamiento, String procesador, String modelo, int añoFabricacion,
                  double precio, int cantidadStock, String resolucionPantalla, List<String> accesoriosIncorporados) {
        super(marca, memoriaRAM, memoriaAlmacenamiento, procesador, modelo, añoFabricacion, precio, cantidadStock);
        this.resolucionPantalla = resolucionPantalla;
        this.accesoriosIncorporados = accesoriosIncorporados;
    }

    @Override
    public String obtenerEspecificaciones() {
        String especificaciones = "Marca: " + getMarca() +
                "\nMemoria RAM: " + getMemoriaRAM() + "GB" +
                "\nMemoria de Almacenamiento: " + getMemoriaAlmacenamiento() + "GB" +
                "\nProcesador: " + getProcesador() +
                "\nModelo: " + getModelo() +
                "\nAño de Fabricación: " + getAñoFabricacion() +
                "\nPrecio: $" + getPrecio() +
                "\nCantidad en Stock: " + getCantidadStock() +
                "\nResolución de Pantalla: " + resolucionPantalla +
                "\nAccesorios Incorporados: " + accesoriosIncorporados;

        return especificaciones;
    }

    public String getResolucionPantalla() {
        return resolucionPantalla;
    }

    public List<String> getAccesoriosIncorporados() {
        return accesoriosIncorporados;
    }
}
