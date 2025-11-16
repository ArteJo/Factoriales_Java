package Autonomos;

/* Universidad Internacional del Ecuador UIDE
Fecha de compilación: 14 de noviembre de 2025
PROGRAMACION ESTRUCTURADA Y FUNCIONAL 1-CIB-2A
Nombre del Estudiante: Wilmer Joao Correa Guevara
Nombre del Docente: Carlos Alberto Vintimilla Carrasco*/

// Aprendizaje Autónomo N°1
/* Investigar lo que es el factorial de un número y cómo se calcula. 
Una vez que sepa la fórmula de cálculo, usar el IDE (Visual Studio Code) y escriba un programa en Java que:
Calcule y muestre por pantalla el factorial de todos los valores numéricos enteros entre 1 y 13.

Su programa debe incluir lo siguiente:
[X] 1. Una clase principal con el método main
[X] 2. Una clase secundaria con el método factorial que reciba como parámetro un número entero y 
       devuelva como resultado el factorial de dicho número
[X] 3. En la clase principal debe hacerse uso de un objeto de la clase secundaria para generar el resultado deseado
[X] 4. El programa debe incluir comentarios donde se muestra el nombre del alumno que desarrolla
       el programa, la fecha de compilación y explicación en las partes de código que considere más importantes
[X] 5. Como sugerencia para este trabajo, use bucles for */

// Clase principal del programa
public class Autonomo1_1 {
    
    public static void main(String[] args) {
        // Creamos un objeto de la clase secundaria (CalculadoraFactorial)
        CalculadoraFactorial calculadora = new CalculadoraFactorial();
        // Le damos un pequeño titulo al programa con println
        System.out.println("CÁLCULO DE FACTORIALES DEL 1 AL 13");
        // Usamos el bucle for para calcular el factorial de los números del 1 al 13
        /* Nota: 13! es el factorial más grande que se puede calcular sin exceder el 
        límite de long en Java, luego hay que usar BigInteger para numeros mas grandes */
        // Usamos la variable n para representar los numeros del 1 al 13 (n = 1)
        // La condicion se ejecuta mientras n sea menor o igual a 13 (n <= 13), si n = 14 se detiene
        // Después de cada iteración sumamos 1 a n (n++)
        for (int n = 1; n <= 13; n++) {
            // Long es un tipo de dato que almacena números enteros grandes
            // Aqui llamamos al método factorial de la clase secundaria con .factorial(n)
            // n es el valor del bucle que se pasa como argumento
            long resultadoFactorial = calculadora.factorial(n);
            // Mostramos el resultado con un formato para que sea más legible (printf).
            System.out.printf("%2d! = %,15d%n", n, resultadoFactorial);
        }
    }
}

// ---------------------------------------------------------------------------
// Clase secundaria que contiene el método para calcular factoriales
class CalculadoraFactorial {
    // Método que calcula el factorial de un número entero
    // Usamos public para que sea accesible desde la clase principal
    public long factorial(int numero) {
        // Variable para almacenar el resultado del factorial
        // Inicializamos en 1 porque si fuera 0, todo quedaria en 0 al multiplicar
        long resultado = 1;
        // Bucle for que multiplica todos los números desde 1 hasta el número dado
        // Ejemplo: Si numero = 5, entonces: 1*2*3*4*5 = 120
        for (int n = 1; n <= numero; n++) {
            resultado *= n;  // resultado = resultado * n
            /* Si n = 5
            Inicio:     resultado = 1
            n = 1:      resultado = 1 * 1 = 1
            n = 2:      resultado = 1 * 2 = 2
            n = 3:      resultado = 2 * 3 = 6
            n = 4:      resultado = 6 * 4 = 24
            n = 5:      resultado = 24 * 5 = 120 */ 
        }
        // Return devuelve el resultado del factorial calculado a la clase principal
        return resultado;
    }

}
