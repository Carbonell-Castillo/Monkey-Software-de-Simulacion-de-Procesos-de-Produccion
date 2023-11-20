# Monkey: Software de Simulación de Procesos de Producción

Monkey es un software diseñado para la simulación y optimización de procesos de producción en empresas, basado en la técnica de eventos discretos. El objetivo principal es proporcionar a las empresas una herramienta accesible y rentable para analizar y mejorar sus procesos, reduciendo costos y aumentando la eficiencia.

## Características Principales

### Menú Inicial

Al iniciar el programa, se presenta al usuario un menú inicial que permite la configuración de los siguientes parámetros:

- Tiempo de procesamiento por producto en cada sector (en segundos).
- Costo por producto (en Quetzales/segundo) en cada sector.

El usuario debe ingresar valores enteros, y si se intenta iniciar la simulación con campos vacíos o datos no válidos, se mostrará un mensaje de error.

### Simulación

#### Visualización

Durante la simulación, se presenta una pantalla que muestra el tiempo transcurrido y cuatro sectores clave:

1. **Inventario**
2. **Producción**
3. **Empaquetado**
4. **Salida**

Cada segundo, se introduce una nueva materia prima en el sistema (hasta un máximo de 30 materias primas), representada por un círculo incoloro. La materia prima se desplaza a través de los sectores siguiendo el flujo de producción.

#### Proceso de Producción

1. **Inventario:** La materia prima ingresa al inventario, cambia su color y espera el tiempo indicado.
2. **Producción:** Se traslada al sector de producción, cambia su color al respectivo del sector y espera el tiempo indicado.
3. **Empaquetado:** La materia prima se mueve al sector de empaquetado, cambia su color y espera el tiempo indicado.
4. **Salida:** Finalmente, la materia prima va al sector de salida, espera el tiempo indicado y sale de la simulación.

#### Control de Materia Prima

Cada sector lleva un contador de la cantidad de materia prima actualmente en proceso. Se incluyen indicadores de inicio y fin para verificar cuánta materia prima falta por llegar y cuánta ha completado su procesamiento.

#### Fin de Simulación

Una vez que la última materia prima ha completado su procesamiento, se detiene el tiempo y se informa al usuario que la simulación ha finalizado. El usuario puede optar por regresar al menú inicial o generar un informe de la simulación.

Monkey proporciona una interfaz gráfica intuitiva y funcionalidades clave para analizar y mejorar los procesos de producción de una empresa de manera efectiva.