# SwitchButton Component

Bienvenido a la página de documentación de mi componente. He desarrollado un **SwitchButton** (botón interruptor) personalizado para la asignatura de Desarrollo de Interfaces (Práctica 3.2).

El objetivo de este proyecto es crear un control reutilizable para JavaFX que incluya propiedades, eventos personalizados y animaciones.

## Características
El componente incluye lo siguiente:
* **Propiedad `switchedOn`:** Para saber si está encendido o apagado.
* **Animación:** Desplazamiento suave y cambio de color al hacer clic.
* **Evento personalizado:** Lanza un evento cada vez que cambia de estado.

## Instalación
Para probar la librería:
1.  Ve a la pestaña de **[Releases](https://github.com/Josemg5/customComponent/releases)** de este repositorio.
2.  Descarga el archivo `.jar` de la última versión (v1.0.0).
3.  Añádelo al *Build Path* o dependencias de tu proyecto.

## 🛠 Ejemplo de Uso
Aquí tienes un ejemplo básico de cómo añadir el botón a tu interfaz y escuchar sus eventos:

```java
SwitchButton miBoton = new SwitchButton();

miBoton.setOnAction(event -> {
    if (miBoton.isSwitchedOn()) {
        System.out.println("¡Interruptor ENCENDIDO!");
    } else {
        System.out.println("Interruptor APAGADO");
    }
});

// Añadir al layout (ejemplo)
// root.getChildren().add(miBoton);
