# DOSW\_Lab2.7

## Reto 6: Habla con soporte tecnico

**Patron de diseño:** De comportamiento

**Patron utilizado:** Chain of responsability

### Justificacion

En este caso se utilizo este patron de diseño por como esta abordado el problema, pues digamos que al tener que manejar los distintos niveles de prioridad este puede ir escalando como lo hace en cadena de responsabilidad

### Como lo aplico

---

implementacion del reto 7 de la parte 3 del laboratorio



Patrón de Diseño Utilizado

Categoría: Patrones de Comportamiento (Behavioral Patterns)

Patrón: Command (Comando)



En este reto, necesitábamos:



Ejecutar acciones sobre diferentes dispositivos (luces, puertas, música, persianas)

Deshacer acciones para revertir configuraciones incorrectas

Mantener un historial de quién hizo qué acción

Investigar quién desconfiguró los electrodomésticos



El patrón Command es perfecto para este escenario porque:



Separa la solicitud de ejecución de la ejecución misma

Cada comando guarda su estado anterior, permitiendo el "undo"

Los comandos se pueden almacenar en un historial

Nuevos comandos se pueden agregar sin modificar código existente





Comandos Concretos (Comandos.java)

Cada comando concreto implementa la interfaz Comando y encapsula:



Una referencia al receptor (dispositivo)

Los parámetros necesarios para la acción

El estado anterior para poder deshacer

El usuario que ejecuta el commando



Receptores (Receivers) (Dispositivos.java)

Los receptores son los objetos que realmente realizan el trabajo. Cada dispositivo tiene sus propios métodos y estado.

