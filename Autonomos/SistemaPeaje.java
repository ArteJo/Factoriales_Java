package Autonomos;

// Arraylist sirve para manejar listas dinámicas
import java.util.ArrayList;

// Creamos una clase para el peaje
class Peaje {
    // Atributos del peaje
    // Empezamos con los valores en 0 porque vamos a ir sumando
    // a medida que pasen los vehículos
    private String nombre;
    private String departamento;
    private int totalPeaje = 0;
    private int totalCamiones = 0;
    private int totalMotos = 0;
    private int totalCarros = 0;
    private ArrayList<Vehiculo> vehiculos;
    
    public Peaje(String nombre, String departamento) {
        this.nombre = nombre; // Nombre del peaje
        this.departamento = departamento; // Departamento (provincias del pais?..) donde esta ubicado el peaje
        this.vehiculos = new ArrayList<>(); // Empezamos una lista vacía de vehículos que pasen por el peaje
    }

    // getNombre() nos permite obtener o leer el valor del atributo "nombre"
    public String getNombre() {
        return nombre;
    }
    // setNombre() nos permite modificar o escribir el valor del atributo "nombre"
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    // getDepartamento() nos permite obtener o leer el valor del atributo "departamento"
    public String getDepartamento() {
        return departamento;
    }
    // setDepartamento() nos permite modificar o escribir el valor del atributo "departamento"
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    // Toda la parte de arriba existe porque los atributos son privados
    // Necesitamos metodos públicos para acceder a ellos desde otras clases. 

    public void añadirVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo); // Añadimos el vehiculo a la lista dinámica para mantener un registro
        int valorPeaje = calcularPeaje(vehiculo); // Calcula cuánto debe pagar el vehículo
        totalPeaje += valorPeaje; // Sumamos el valor del peaje al total recolectado
        // Si totalPeaje es 10$ y un carro paga 2$, ahora va ser 12$.

        // Empezamos a contar cuántos vehículos de cada tipo han pasado por el peaje
        // instanceof verifica de que tipo es el vehiculo y aumenta el contador correspondiente
        if (vehiculo instanceof Carro) {
            totalCarros++; // Si es un carro aumenta en 1 el contador de carros
        } else if (vehiculo instanceof Moto) {
            totalMotos++; // Si es una moto aumenta en 1 el contador de motos
        } else if (vehiculo instanceof Camion) {
            totalCamiones++; // Si es un camión aumenta en 1 el contador de camiones
        }
    }
    
    // Aqui calculamos el peaje según el tipo de vehículo, devolviendo el valor correspondiente que debe pagar
    public int calcularPeaje(Vehiculo vehiculo) {
        return vehiculo.getValorPeaje();
    }
    
    // Imprimimos el reporte de toda la informacion del peaje.
    // Titulo, lista de vehículos con su placa, tipo y valor del peaje
    public void imprimir() {
        // Ponemos unas lineas decorativas para que se vea mejor
        System.out.println("========================================");
        System.out.println("ESTACIÓN DE PEAJE PANAVIAL: " + nombre);
        System.out.println("Departamento: " + departamento);
        System.out.println("========================================");
        System.out.println("\nVEHÍCULOS REGISTRADOS POR TELEPASS:");
        System.out.println("----------------------------------------");
        
        // Hacemos un bucle que recorre todos los vehiculos que se encuentren en el ArrayList (lista dinámica)
        // En cada iteración del bucle, el vehículo actual se asigna a la variable 'v'
        for (Vehiculo v : vehiculos) {
            System.out.print("Placa: " + v.getPlaca() + " - Tipo: "); // Imprimimos la placa del vehículo
            // instanceof verifica si el vehículo es de un tipo específico (Carro, Moto o Camion)
            // Si es un carro, imprime "Carro - Peaje: $2"
            if (v instanceof Carro) {
                System.out.println("Carro - Peaje: $" + v.getValorPeaje());
            } else if (v instanceof Moto) {
                System.out.println("Moto - Peaje: $" + v.getValorPeaje());
            // Si es un camion, necesitamos hacer un cast o conversión
            // para poder acceder al número de ejes "getNumeroEjes()"
            // Si el camión tiene 4 ejes, imprime "Camión (4 ejes) - Peaje: $4"
            } else if (v instanceof Camion) {
                Camion c = (Camion) v;
                System.out.println("Camión (" + c.getNumeroEjes() + " ejes) - Peaje: $" + v.getValorPeaje());
            }
        }
        
        // Imprimimos el resumen final con los totales de cada vehículo y el total recolectado del peaje
        System.out.println("----------------------------------------");
        System.out.println("\nRESUMEN:");
        System.out.println("Total Carros: " + totalCarros);
        System.out.println("Total Motos: " + totalMotos);
        System.out.println("Total Camiones: " + totalCamiones);
        System.out.println("Total Vehículos: " + vehiculos.size());
        System.out.println("\nTOTAL PEAJE RECOLECTADO: $" + totalPeaje);
    }
}

// Creamos una clase abstracta llamada Vehiculo
// Esta es una plantilla o modelo base para las demas clases de vehículos
// Además de que define caracteristicas comunes que todos los vehículos deben tener
abstract class Vehiculo {
    protected String placa; // Con protected las clases hijas pueden acceder a este atributo
    // Clases hijas: Carro, Moto, Camion
    // Todos los vehículos tienen una placa
    
    // Hacemos un constructor para inicializar la placa
    // Las clases hijas deben llamar a este constructor
    public Vehiculo(String placa) {
        this.placa = placa;
    }
    
    // Getter y Setter para leer y modificar la placa
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
    // Método abstracto que obliga a las clases hijas a implementar este método
    // Cada tipo de vehículo va a calcular su peaje de forma diferente
    public abstract int getValorPeaje();
}

// Creamos la clase Carro
class Carro extends Vehiculo { // extends nos indica que Carro hereda de Vehiculo (aplicamos herencia)
    // Carro tiene todo lo que tiene Vehiculo mas las características que definamos aquí
    private int valorPeaje = 2; // Los carros pagan $2 de peaje
    
    public Carro(String placa) {
        super(placa); // Llamamos al constructor de la clase padre (Vehiculo) para inicializar la placa
    }
    
    // Implementamos el método abstracto de la clase Vehiculo
    @Override // Con override indicamos que estamos sobrescribiendo un método de la clase padre
    public int getValorPeaje() {
        return valorPeaje; 
    }
    
    public void setValorPeaje(int valorPeaje) {
        this.valorPeaje = valorPeaje; // Aqui podemos modificar el valor del peaje si es necesario
    }
}

// Creamos una clase Moto
// Esta funciona de forma similar a la clase Carro pero con unas condiciones diferentes 
// Las motos pagan $1 de peaje, ademas es una clase diferente porque las motos tienen características distintas
class Moto extends Vehiculo {
    private int valorPeaje = 1; // Las motos pagan $1 de peaje
    
    public Moto(String placa) {
        super(placa); // Volvemos a llamar al constructor de la clase padre (Vehiculo) para inicializar la placa
    }
    
    @Override // Volvemos a sobrescribir el método de la clase padre pero esta vez para las motos
    public int getValorPeaje() {
        return valorPeaje;
    }
    
    public void setValorPeaje(int valorPeaje) {
        this.valorPeaje = valorPeaje; // Aqui podemos modificar el valor del peaje si es necesario
    }
}

// Creamos una clase Camion
// Esta clase hija tiene una logica diferente debido a que los camiones pagan el peaje según el número de ejes
class Camion extends Vehiculo {
    private int valorPeajeEje = 1; // Los camiones pagan $1 por cada eje
    private int numeroEjes; // Cuantos ejes tiene el camión
    
    // Usamos un constructor que recibe la placa y el número de ejes
    public Camion(String placa, int numeroEjes) {
        super(placa); // Inicializa la placa
        this.numeroEjes = numeroEjes; // Inicializa el número de ejes
    }
    
    // Getter y Setter para el número de ejes que tenga el camión
    public int getNumeroEjes() {
        return numeroEjes; // Devuelve el número de ejes
    }
    public void setNumeroEjes(int numeroEjes) {
        this.numeroEjes = numeroEjes; // Modifica el número de ejes
    }
    
    // Calculamos el valor del peaje
    // No es un valor fijo, depende del número de ejes
    @Override // Volvemos a sobrescribir el método de la clase padre pero esta vez para los camiones
    public int getValorPeaje() {
        return valorPeajeEje * numeroEjes; // Calculamos 1$ por cada eje
    }
    
    // Getter y Setter para el valor del peaje por eje
    public int getValorPeajeEje() {
        return valorPeajeEje; // Devuelve el valor del peaje por eje
    }
    public void setValorPeajeEje(int valorPeajeEje) {
        this.valorPeajeEje = valorPeajeEje; // Modifica el valor del peaje por eje
    }
}

// Finalmente, creamos la clase main que va a ejecutar todo el programa
public class SistemaPeaje {
    public static void main(String[] args) {
        // Creamos la estación de peaje, vamos a usar el peaje de Oyacoto
        // que se ubica en la salida de Quito via a Imbabura.
        // Ecuador no usa departamentos, usamos provincias en su lugar pero en el diagrama de clases usa departamento
        Peaje peaje = new Peaje("Oyacoto", "Pichincha"); 
        
        // Creamos la lista de los vehículos que van a pasar por el peaje
        Carro carro1 = new Carro("GPC0084");
        Carro carro2 = new Carro("PCA5274");
        Carro carro3 = new Carro("PBC3375");
        Moto moto1 = new Moto("IQ441W");
        Moto moto2 = new Moto("IY657E");
        Moto moto3 = new Moto("EA817O");
        Camion camion1 = new Camion("POY0510", 4);
        Camion camion2 = new Camion("IBA5120", 6);
        Camion camion3 = new Camion("HBA2044", 3);
        // En total creamos 9 vehículos: 3 carros, 3 motos y 3 camiones con diferentes placas y ejes
        
        // Añadimos los vehículos al peaje
        // Cada llamada a añadirVehiculo() va a simular que un vehículo pasa por el peaje
        peaje.añadirVehiculo(carro1);
        peaje.añadirVehiculo(moto1);
        peaje.añadirVehiculo(camion1);
        peaje.añadirVehiculo(carro2);
        peaje.añadirVehiculo(moto2);
        peaje.añadirVehiculo(camion2);
        peaje.añadirVehiculo(carro3);
        peaje.añadirVehiculo(camion3);
        peaje.añadirVehiculo(moto3);
        
        // Imprimimos el resultado usando el método imprimir() de la clase Peaje que creamos al principio
        // Muestra en la consola todo el reporte: Encabezado, lista de vehículos, resumen y total recaudado.
        peaje.imprimir();
    }
}