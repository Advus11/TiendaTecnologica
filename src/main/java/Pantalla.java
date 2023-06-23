public class Pantalla {
    private String marca;
    private String modelo;
    private int año;

    public Pantalla(String marca, String modelo, int año) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
    }

    public String obtenerEspecificaciones() {
        String especificaciones = "Marca: " + marca +
                "\nModelo: " + modelo +
                "\nAno: " + año;

        return especificaciones;
    }
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAño() {
        return año;
    }
}
