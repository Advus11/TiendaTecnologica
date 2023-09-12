import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Tienda {
    private String direccion;
    private List<DispositivoTecnologico> catalogo;
    private List<Cliente> clientes;
    private final String archivoCatalogo = "catalogo.txt"; // Nombre del archivo para el catálogo

    public Tienda() {
        this.direccion = direccion;
        this.catalogo = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public void agregarCliente(Cliente cliente) { //Metodo agregar cliente
        if (!clienteExiste(cliente.getCorreoElectronico())) {
            clientes.add(cliente);
            System.out.println("Cliente agregado correctamente.");
        } else {
            System.out.println("El cliente ya existe.");
        }
    }
//Validacion de cliente
    private boolean clienteExiste(String correoElectronico) {
        for (Cliente cliente : clientes) {
            if (cliente.getCorreoElectronico().equalsIgnoreCase(correoElectronico)) {
                return true;
            }
        }
        return false;
    }

//Metodo que permite obtener la información de un dispositivo tecnológico
    public void obtenerInformacionDispositivo(String marca, String modelo, String tipo) {
        for (DispositivoTecnologico dispositivo : catalogo) {
            if ((marca == null || dispositivo.getMarca().equalsIgnoreCase(marca)) &&
                    (modelo == null || dispositivo.getModelo().equalsIgnoreCase(modelo)) &&
                    (tipo == null || dispositivo.getClass().getSimpleName().equalsIgnoreCase(tipo))) {
                System.out.println(dispositivo.obtenerEspecificaciones());
                System.out.println("-----------------------------");
            }
        }
    }

    //Metodo que permite mostrar todos los dispositivos por marca
    public List<DispositivoTecnologico> buscarDispositivosPorMarca(String marca) {
        List<DispositivoTecnologico> dispositivosEncontrados = new ArrayList<>();
        for (DispositivoTecnologico dispositivo : catalogo) {
            if (dispositivo.getMarca().equalsIgnoreCase(marca)) {
                dispositivosEncontrados.add(dispositivo);
            }
        }
        return dispositivosEncontrados;
    }
//Metodo que permite buscar dispositivos del catalogo por modelo y tipo
    public List<DispositivoTecnologico> buscarDispositivosPorModeloYTipo(String modelo, String tipo) {
        List<DispositivoTecnologico> dispositivosEncontrados = new ArrayList<>();
        for (DispositivoTecnologico dispositivo : catalogo) {
            if (dispositivo.getModelo().equalsIgnoreCase(modelo) &&
                    dispositivo.getClass().getSimpleName().equalsIgnoreCase(tipo)) {
                dispositivosEncontrados.add(dispositivo);
            }
        }
        return dispositivosEncontrados;
    }
    public void guardarCatalogoEnArchivo() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(archivoCatalogo))) {
            for (DispositivoTecnologico dispositivo : catalogo) {
                writer.println(dispositivo.getClass().getSimpleName());
                writer.print(dispositivo.getMarca() + "/");
                writer.print(dispositivo.getMemoriaRAM() + "/");
                writer.print(dispositivo.getMemoriaAlmacenamiento() + "/");
                writer.print(dispositivo.getProcesador() + "/");
                writer.print(dispositivo.getModelo() + "/");
                writer.print(dispositivo.getAnoFabricacion() + "/");
                writer.print(dispositivo.getPrecio() + "/");
                writer.print(dispositivo.getCantidadStock() + "/");

                if (dispositivo instanceof Computador) {
                    Computador computador = (Computador) dispositivo;
                    writer.print(computador.getTarjetaVideo() + "/");
                    writer.print(computador.getFuentePoder() + "/");
                    writer.print(computador.getChasis() + "/");
                    Pantalla pantalla = computador.getPantallaAsociada();
                    writer.print(pantalla.getMarca() + "/");
                    writer.print(pantalla.getModelo() + "/");
                    writer.print(pantalla.getAno());
                } else if (dispositivo instanceof Notebook) {
                    Notebook notebook = (Notebook) dispositivo;
                    writer.print(notebook.getResolucionPantalla() + "/");
                    writer.print(notebook.getTipoTeclado() + "/");
                    writer.print(notebook.getBateria());
                } else if (dispositivo instanceof Tablet) {
                    Tablet tablet = (Tablet) dispositivo;
                    writer.print(tablet.getResolucionPantalla() + "/");
                    List<String> accesorios = tablet.getAccesoriosIncorporados();
                    writer.print(accesorios.size() + "/");
                    for (String accesorio : accesorios) {
                        writer.print(accesorio + "/");
                    }
                }
                writer.println(); // Nueva línea para separar dispositivos
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para cargar el catálogo desde un archivo txt
    public void cargarCatalogoDesdeArchivo() {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivoCatalogo))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String tipo = line;
                String[] atributos = reader.readLine().split("/"); // Dividir los atributos por "/"
                String marca = atributos[0];
                int memoriaRAM = Integer.parseInt(atributos[1]);
                int memoriaAlmacenamiento = Integer.parseInt(atributos[2]);
                String procesador = atributos[3];
                String modelo = atributos[4];
                int anoFabricacion = Integer.parseInt(atributos[5]);
                double precio = Double.parseDouble(atributos[6]);
                int cantidadStock = Integer.parseInt(atributos[7]);

                if (tipo.equals("Computador")) {
                    String tarjetaVideo = atributos[8];
                    String fuentePoder = atributos[9];
                    String chasis = atributos[10];
                    String pantallaMarca = atributos[11];
                    String pantallaModelo = atributos[12];
                    int pantallaAno = Integer.parseInt(atributos[13]);

                    Pantalla pantalla = new Pantalla(pantallaMarca, pantallaModelo, pantallaAno);
                    Computador computador = new Computador(marca, memoriaRAM, memoriaAlmacenamiento, procesador, modelo,
                            anoFabricacion, precio, cantidadStock, tarjetaVideo, fuentePoder, chasis, pantalla);

                    catalogo.add(computador);
                } else if (tipo.equals("Notebook")) {
                    String resolucionPantalla = atributos[8];
                    String tipoTeclado = atributos[9];
                    int bateria = Integer.parseInt(atributos[10]);

                    Notebook notebook = new Notebook(marca, memoriaRAM, memoriaAlmacenamiento, procesador, modelo,
                            anoFabricacion, precio, cantidadStock, resolucionPantalla, tipoTeclado, bateria);

                    catalogo.add(notebook);
                } else if (tipo.equals("Tablet")) {
                    String resolucionPantalla = atributos[8];
                    int numAccesorios = Integer.parseInt(atributos[9]);
                    List<String> accesorios = new ArrayList<>();
                    for (int i = 0; i < numAccesorios; i++) {
                        accesorios.add(atributos[10 + i]);
                    }

                    Tablet tablet = new Tablet(marca, memoriaRAM, memoriaAlmacenamiento, procesador, modelo,
                            anoFabricacion, precio, cantidadStock, resolucionPantalla, accesorios);

                    catalogo.add(tablet);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Getter
    public String getDireccion() {
        return direccion;
    }

    public List<DispositivoTecnologico> getCatalogo() { //Metodo que muestra el catalogo actual
        return catalogo;
    }

    public void agregarDispositivo(DispositivoTecnologico dispositivo) { //Metodo que permite agregar un dispositivo
        catalogo.add(dispositivo);
    }

    public void eliminarDispositivo(DispositivoTecnologico dispositivo) { //Metodo que permite eliminar un dispositivo
        catalogo.remove(dispositivo);
    }
    public void inicializar() {
        // Agregar clientes
        Cliente cliente1 = new Cliente("John", "Doe", "john.doe@example.com", "123456789", "Soltero", "Ciudad A");
        agregarCliente(cliente1);

        Cliente cliente2 = new Cliente("Jane", "Smith", "jane.smith@example.com", "987654321", "Casada", "Ciudad B");
        agregarCliente(cliente2);

        // Agregar dispositivos tecnológicos
        DispositivoTecnologico dispositivo1 = new Computador("HP", 8, 512, "Intel Core i5", "HP Pavilion", 2021, 999.99, 10,
                "NVIDIA GeForce GTX 1650", "500W", "Mid Tower", new Pantalla("HP", "24f", 2021));
        agregarDispositivo(dispositivo1);

        DispositivoTecnologico dispositivo2 = new Notebook("Dell", 16, 1, "Intel Core i7", "Dell XPS", 2022, 1499.99, 5,
                "1920x1080", "Teclado retroiluminado", 8000);
        agregarDispositivo(dispositivo2);

        // Obtener información de un dispositivo
        System.out.println("Informacion del primer dispositivo:");
        String informacionDispositivo = dispositivo1.obtenerEspecificaciones();
        System.out.println(informacionDispositivo);

        // Buscar dispositivos por marca
        System.out.println("Dispositivos HP encontrados:");
        List<DispositivoTecnologico> dispositivosHP = buscarDispositivosPorMarca("HP");
        for (DispositivoTecnologico dispositivo : dispositivosHP) {
            System.out.println(dispositivo.obtenerEspecificaciones());
            System.out.println("-----------------------------");
        }

        // Buscar dispositivos por modelo y tipo
        System.out.println("Dispositivos Dell XPS (Notebook) encontrados:");
        List<DispositivoTecnologico> dispositivosDellXPS = buscarDispositivosPorModeloYTipo("Dell XPS", "Notebook");
        for (DispositivoTecnologico dispositivo : dispositivosDellXPS) {
            System.out.println(dispositivo.obtenerEspecificaciones());
            System.out.println("-----------------------------");
        }
    }
}
