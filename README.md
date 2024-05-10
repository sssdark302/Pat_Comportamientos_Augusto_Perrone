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

  * Handlers:

    * Bucles (con palabras reservadas)
    * Declaracion de variables (con palabras reservadas)
    * Palabras no reservadas
    * Espacios / Cambios de linea, et
* AnalizadoresSemánticos

  * Handlers:
  * * Bucles (con palabras reservadas)
    * Condiciones de los bucles
    * Saltos de linea o final de declaraciones
    * Declaraciones con palabras reservadas
    * Palabras no reservadas

El bloque de codigo a analizar son dos contadores:

* CountUp: bucle for va hacia arriba infinitamente. El toString() se ha implementando tal cual porque no se como hacerlo de otra manera al llamar al metodo en el main
* CoundDown: bucle while que se detiene cuando llegue a 0. El toString() se ha implementando tal cual porque no se como hacerlo de otra manera al llamar al metodo en el main

Controlador:

* ControladorPuente

Vista:


* Swing GUI

---

## Faltó por hacer:

* Vista: No se ha implementado la vista, no me dio tiempo.
* Controlador: No se ha implementado la vista, no me dio tiempo.
* Arraylist para guardar los tokens (léxico).
* Arraylist para guardar errores.
* Arbol sintáctico, hubiese mejorado la parte semántica.
* Se podría haber hecho mejor la cadena de responsabilidad, dividiéndola en 4 pero siendo englobada por una mas grande, no se si hubiese aportado mucho pero por lo menos era mas flexible.


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
