# Pat_Comportamientos_Augusto_Perrone

## Estructura:

Modelo Lógico: Habra cuatro cadenas de responsabilidad que formarán parte de una mas grande:

* DesmenuzadorDeTexto

  * Trocea el bloque de codigo para que sea mas facil de analizar, lo hace con un array
  * Hay que determinar como entra el codigo y pasa a un string para que pase a las otras cadenas
* AnalizadoresSintáctico

  * Handlers:
    * Bucles (con palabras reservadas)
    * Declaracion de variables (con palabras reservadas)
    * Palabras no reservadas
    * Espacios / Cambios de linea, etc
* AnalizadoresLéxicos

  El **análisis léxico** es el proceso de convertir una  secuencia de caracteres en una secuencia de tokens. Los tokens son las  unidades básicas como palabras clave, identificadores, constantes  numéricas, operadores, etc. Este proceso es similar a leer un texto y  separar las palabras y signos de puntuación para entender su significado  básico sin entrar en la estructura gramatical o significado contextual  completo.

  * Handlers:
    * Bucles (con palabras reservadas)
    * Declaracion de variables (con palabras reservadas)
    * Palabras no reservadas
    * Espacios / Cambios de linea, et
* AnalizadoresSemánticos

  ¿Qué es el Análisis Semántico?

  El análisis semántico se ocupa de verificar aspectos del código que no pueden ser capturados por el análisis léxico o sintáctico solo, tales como:

  * **Verificación de Tipos**: Asegurar que las operaciones se realicen entre tipos compatibles, como no sumar un entero y una cadena de texto.
  * **Declaraciones y Alcance de Variables**: Asegurar que las variables sean declaradas antes de su uso y gestionar su visibilidad según el ámbito.
  * **Uso de Funciones y Procedimientos**: Verificar que las llamadas a funciones y procedimientos sean con el número y tipo correcto de argumentos.
  * **Control de Flujo**: Asegurar que las estructuras de control del flujo del programa sean lógicamente válidas, como la existencia de una condición booleana en un `if`.
  * Handlers:

    * Bucles (con palabras reservadas)
    * Condiciones de los bucles
    * Saltos de linea o final de declaraciones
    * Declaraciones con palabras reservadas
    * Palabras no reservadas

El bloque de codigo a analizar son dos contadores:

* CountUp: bucle for va hacia arriba infinitamente
* CoundDown: bucle while que se detiene cuando llegue a 0

Controlador

* ControladorPuente

Vista

* Swing GUI

---

## Analizar los bucles con las expresiones regulares

```
while (condición) {
// Cuerpo del bucle
}
```

* Hay que identificar:
  * la palabra 'while'
  * la condicion entre paréntesis
  * el cuerpo del bucle entre las llaves

Expresion regular para el bucle 'while':

while\s*\((.*?)\)\s*\{([\s\S]*?)\}

* `while`: Busca literalmente la palabra "while".
* `\s*`: Coincide con cualquier cantidad de espacios en blanco (incluidos ninguno).
* `\(` y `\)`: Coinciden con los paréntesis que encierran la condición del bucle.
* `(.*?)`: Es un grupo de captura para la condición del bucle. El `?` hace que la cuantificación sea perezosa, lo que significa que captura lo menos posible hasta que el siguiente token en la expresión regular se pueda coincidir.
* `\s*`: Coincide nuevamente con cualquier cantidad de espacios en blanco antes de la llave que abre.
* `\{`: Coincide con la llave que abre el cuerpo del bucle.
* `([\s\S]*?)`: Es un grupo de captura para el cuerpo del bucle. `[\s\S]*` coincide con cualquier carácter incluyendo saltos de línea (esencial para abarcar múltiples líneas), y el `?` lo hace perezoso para asegurarse de capturar el contenido hasta la primera llave que cierra que encuentra.
* `\}`: Coincide con la llave que cierra el cuerpo del bucle.
