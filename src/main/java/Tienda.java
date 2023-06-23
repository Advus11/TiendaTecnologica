import java.util.ArrayList;
import java.util.List;

public class Tienda {
    private String direccion;
    private List<DispositivoTecnologico> catalogo;

    public Tienda(String direccion) {
        this.direccion = direccion;
        this.catalogo = new ArrayList<>();
    }

    public String getDireccion() {
        return direccion;
    }

    public List<DispositivoTecnologico> getCatalogo() {
        return catalogo;
    }

    public void agregarDispositivo(DispositivoTecnologico dispositivo) {
        catalogo.add(dispositivo);
    }

    public void eliminarDispositivo(DispositivoTecnologico dispositivo) {
        catalogo.remove(dispositivo);
    }
}
