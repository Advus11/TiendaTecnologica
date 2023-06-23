public class Computador extends DispositivoTecnologico {
    private String tarjetaVideo;
    private String fuentePoder;
    private String chasis;
    private Pantalla pantallaAsociada;

    public Computador(String marca, int memoriaRAM, int memoriaAlmacenamiento, String procesador, String modelo, int añoFabricacion,
                      double precio, int cantidadStock, String tarjetaVideo, String fuentePoder, String chasis, Pantalla pantallaAsociada) {
        super(marca, memoriaRAM, memoriaAlmacenamiento, procesador, modelo, añoFabricacion, precio, cantidadStock);
        this.tarjetaVideo = tarjetaVideo;
        this.fuentePoder = fuentePoder;
        this.chasis = chasis;
        this.pantallaAsociada = pantallaAsociada;
    }

    public String getTarjetaVideo() {
        return tarjetaVideo;
    }

    public String getFuentePoder() {
        return fuentePoder;
    }

    public String getChasis() {
        return chasis;
    }

    public Pantalla getPantallaAsociada() {
        return pantallaAsociada;
    }
}
