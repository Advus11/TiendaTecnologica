public class Notebook extends DispositivoTecnologico {
    private String resolucionPantalla;
    private String tipoTeclado;
    private int bateria;

    public Notebook(String marca, int memoriaRAM, int memoriaAlmacenamiento, String procesador, String modelo, int añoFabricacion,
                    double precio, int cantidadStock, String resolucionPantalla, String tipoTeclado, int bateria) {
        super(marca, memoriaRAM, memoriaAlmacenamiento, procesador, modelo, añoFabricacion, precio, cantidadStock);
        this.resolucionPantalla = resolucionPantalla;
        this.tipoTeclado = tipoTeclado;
        this.bateria = bateria;
    }

    public String getResolucionPantalla() {
        return resolucionPantalla;
    }

    public String getTipoTeclado() {
        return tipoTeclado;
    }

    public int getBateria() {
        return bateria;
    }
}

