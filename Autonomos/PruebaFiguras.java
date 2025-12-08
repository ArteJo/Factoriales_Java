package Autonomos;

/* Universidad Internacional del Ecuador UIDE
PROGRAMACION ESTRUCTURADA Y FUNCIONAL 1-CIB-2A
Nombre del Estudiante: Wilmer Joao Correa Guevara
Nombre del Docente: CARLOS ALBERTO VINTIMILLA CARRASCO

Aprendizaje Autónomo N°2
[X] 1. Cree las clases Círculo, Rectángulo, Cuadrado, Triángulo Rectángulo, con sus campos o variables y métodos.
[X] 2. Programe los metodos de cada clase que serán invocados en la clase principal PruebaFiguras por medio de 
    instancias de clase como se vió en la muestra de codigo proporcionada.
[X] 3. Agregar una nueva clase denominada Trapecio en el diagrama de clases. Definir los metodos para calcular
    el área y perímetro del trapecio.
[X] 4. Inserte la creacion de una instancia de la clase Trapecio para presentar los resultados en la clase PruebaFiguras.
[X] 5. Ejecutar el programa sin errores.
*/

// CLASE PARA EL CIRCULO

class Circulo {
    // Atributo
    private int radio;
    
    public Circulo(int radio) {
        this.radio = radio; // Radio del círculo
    }
    
    // Manera de calcular área del círculo
    // Fórmula: área = PI * radio²
    // @return El área calculada
    public double calcularArea() {
        return Math.PI * Math.pow(radio, 2);
    }
    
    // Manera de calcular el perímetro del círculo
    // Fórmula: perímetro = 2 * PI * radio
    // @return El perímetro calculado
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }
}

// CLASE PARA EL RECTANGULO

class Rectangulo {
    // Atributos
    private int base;
    private int altura;
    
    public Rectangulo(int base, int altura) {
        this.base = base; // Base del rectángulo
        this.altura = altura; // Altura del rectángulo
    }
    
    // Manera de calcular el área del rectángulo
    // Fórmula: área = base * altura
    // @return El área calculada
    public double calcularArea() {
        return base * altura;
    }
    
    // Manera de calcular el perímetro del rectángulo
    // Fórmula: perímetro = 2 * (base + altura)
    // @return El perímetro calculado
    public double calcularPerimetro() {
        return 2 * (base + altura);
    }
}

// CLASE PARA EL CUADRADO

class Cuadrado {
    // Atributo
    private int lado;
    
    public Cuadrado(int lado) {
        this.lado = lado; // Lado del cuadrado
    }
    
    // Manera de calcular el área del cuadrado
    // Fórmula: área = lado²
    // @return El área calculada
    public double calcularArea() {
        return Math.pow(lado, 2);
    }
    
    // Manera de calcular el perímetro del cuadrado
    // Fórmula: perímetro = 4 * lado
    // @return El perímetro calculado
        public double calcularPerimetro() {
        return 4 * lado;
    }
}

// CLASE PARA EL TRIANGULO RECTANGULO

class TrianguloRectangulo {
    // Atributos
    private int base;
    private int altura;
    
    public TrianguloRectangulo(int base, int altura) {
        this.base = base; // Base del triángulo
        this.altura = altura; // Altura del triángulo
    }
    
    // Manera de calcular el área del triángulo rectángulo
    // Fórmula: área = (base * altura) / 2
    // @return El área calculada
    public double calcularArea() {
        return (base * altura) / 2.0;
    }
    
    // Manera de calcular la hipotenusa del triángulo rectángulo
    // Creamos la hipotenusa porque es necesaria para calcular el perímetro
    // Fórmula: hipotenusa = √(base² + altura²)
    // @return La hipotenusa calculada
    public double calcularHipotenusa() {
        return Math.sqrt(Math.pow(base, 2) + Math.pow(altura, 2));
    }
    
    // Manera de calcular el perímetro del triángulo rectángulo
    // Fórmula: perímetro = base + altura + hipotenusa
    // @return El perímetro calculado
    public double calcularPerimetro() {
        return base + altura + calcularHipotenusa();
    }
    
    // Aqui determinamos el tipo de triángulo según sus lados
    // Imprime en la consola si es equilátero, isósceles o escaleno
    public void determinarTipoTriangulo() {
        double hipotenusa = calcularHipotenusa();
        
        if ((base == altura) && (base == hipotenusa) && (altura == hipotenusa)) {
            System.out.println("Es un triángulo equilátero");
        } else if ((base == altura) || (base == hipotenusa) || (altura == hipotenusa)) {
            System.out.println("Es un triángulo isósceles");
        } else {
            System.out.println("Es un triángulo escaleno");
        }
    }
}

// CLASE PARA EL TRAPECIO

class Trapecio {
    // Atributos
    private int baseMayor;
    private int baseMenor;
    private int altura;
    private double lado1;
    private double lado2;
    
    public Trapecio(int baseMayor, int baseMenor, int altura, double lado1, double lado2) {
        this.baseMayor = baseMayor; // Base mayor del trapecio
        this.baseMenor = baseMenor; // Base menor del trapecio
        this.altura = altura; // Altura del trapecio
        this.lado1 = lado1; // Lado izquierdo del trapecio
        this.lado2 = lado2; // Lado derecho del trapecio
    }
    
    // Manera de calcular el área del trapecio
    // Fórmula: área = ((baseMayor + baseMenor) * altura) / 2
    // @return El área calculada
    public double calcularArea() {
        return ((baseMayor + baseMenor) * altura) / 2.0;
    }
    
    // Manera de calcular el perímetro del trapecio
    // Fórmula: perímetro = baseMayor + baseMenor + lado1 + lado2
    // @return El perímetro calculado
    public double calcularPerimetro() {
        return baseMayor + baseMenor + lado1 + lado2;
    }
}

// CLASE PRINCIPAL - PRUEBA FIGURAS

public class PruebaFiguras {
    // Método main que crea un círculo, un rectángulo, un cuadrado,
    // un triángulo rectángulo y un trapecio. Para cada una de estas figuras geométricas,
    // se calcula su área y perímetro.
    public static void main(String args[]) {
        // Creamos instancias de las figuras geométricas
        Circulo figura1 = new Circulo(2); // Radio = 2
        Rectangulo figura2 = new Rectangulo(1, 2); // Base = 1, Altura = 2
        Cuadrado figura3 = new Cuadrado(3); // Lado = 3
        TrianguloRectangulo figura4 = new TrianguloRectangulo(3, 5); // Base = 3, Altura = 5
        // Añadimos trapecio a la muestra de codigo que se nos proporcionó
        // Base mayor = 10, Base menor = 6, Altura = 4, Lados = 5.0 y 5.0
        Trapecio figura5 = new Trapecio(10, 6, 4, 5.0, 5.0);
        
        // Resultados del Círculo
        System.out.println("El área del círculo es = " + figura1.calcularArea());
        System.out.println("El perímetro del círculo es = " + figura1.calcularPerimetro());
        System.out.println();
        
        // Resultados del Rectángulo
        System.out.println("El área del rectángulo es = " + figura2.calcularArea());
        System.out.println("El perímetro del rectángulo es = " + figura2.calcularPerimetro());
        System.out.println();
        
        // Resultados del Cuadrado
        System.out.println("El área del cuadrado es = " + figura3.calcularArea());
        System.out.println("El perímetro del cuadrado es = " + figura3.calcularPerimetro());
        System.out.println();
        
        // Resultados del Triángulo Rectángulo
        System.out.println("El área del triángulo es = " + figura4.calcularArea());
        System.out.println("El perímetro del triángulo es = " + figura4.calcularPerimetro());
        figura4.determinarTipoTriangulo();
        System.out.println();
        
        // Creamos una instancia de la clase Trapecio para presentar los resultados en la clase PruebaFiguras
        // Resultados del Trapecio
        System.out.println("El área del trapecio es = " + figura5.calcularArea());
        System.out.println("El perímetro del trapecio es = " + figura5.calcularPerimetro());
    }
}