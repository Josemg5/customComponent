# Práctica 3.2: Componente Personalizado (SwitchButton)

Este repositorio contiene el desarrollo de mi componente personalizado para la asignatura de Desarrollo de Interfaces. He implementado un **SwitchButton**, un control de tipo interruptor que no está disponible de forma nativa en JavaFX, diseñado para ser reutilizable y altamente configurable.

## Descripción del Proyecto

El objetivo de esta práctica ha sido crear un componente gráfico desde cero, evitando el uso de imágenes estáticas y utilizando únicamente código Java para el dibujado y las animaciones. El componente sigue el patrón de diseño de Java Beans, exponiendo propiedades observables para facilitar su integración.

### Características Implementadas
* **Diseño Programático:** La interfaz se genera mediante nodos `Rectangle` y `Circle` con efectos de sombra (`DropShadow`), lo que garantiza que se vea nítido en cualquier resolución.
* **Animaciones:** He implementado transiciones paralelas (`ParallelTransition`) para animar tanto el desplazamiento del interruptor como el cambio de color simultáneamente.
* **Propiedades Personalizadas:**
    * `switchedOn`: Controla el estado lógico (encendido/apagado).
    * `vertical`: Permite rotar el componente 90 grados mediante una animación.
    * `colorOn` / `colorOff`: Permite personalizar los colores según la necesidad del usuario.
* **Estado Deshabilitado:** El componente gestiona correctamente la propiedad `disabled`, bloqueando la interacción y cambiando el cursor.

## Tecnologías Utilizadas

* **Lenguaje:** Java 21 (compatible con 17+).
* **Framework Gráfico:** JavaFX.
* **Gestión de Proyecto:** Gradle (Groovy DSL).
* **Testing:** JUnit 5 para lógica y TestFX para interacción de interfaz.

## Instalación

Para probar o utilizar la librería:

1.  Accede a la sección de **Releases** de este repositorio.
2.  Descarga el archivo `.jar` de la versión `v1.0.0`.
3.  Añade la librería al *Classpath* de tu proyecto.

## Ejemplo de Uso

A continuación muestro cómo se instancia el botón y cómo se escuchan sus eventos mediante Listeners, tal como se recomienda en JavaFX:

```java
SwitchButton switchBtn = new SwitchButton();

// Personalización
switchBtn.setColorOn(Color.web("#2ECC71")); // Verde personalizado
switchBtn.setVertical(false); // Orientación horizontal

// Gestión de eventos (Reactiva)
switchBtn.switchedOnProperty().addListener((obs, oldVal, newVal) -> {
    System.out.println("Nuevo estado: " + (newVal ? "ENCENDIDO" : "APAGADO"));
});

// Añadir a la interfaz
root.getChildren().add(switchBtn);
