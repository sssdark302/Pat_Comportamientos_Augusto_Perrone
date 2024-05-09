# Pat_Comportamientos_Augusto_Perrone

Estructura:

* Modelo Lógico
  * Handlers
  * CountUp
  * CoundDown
  * Desmenuzador de codigo con clases heredadas
  * Clases que vean si cada parte del codigo FUNCIONA
* Controlador
  * ControladorPuente
* Vista
  * Swing GUI



* Desmenuzador

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
