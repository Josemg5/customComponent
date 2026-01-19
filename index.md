---
layout: default
title: Documentación SwitchButton
---

# Componente SwitchButton

Bienvenido a la página de documentación del proyecto. He desarrollado un componente **SwitchButton** (interruptor) personalizado para la asignatura de Desarrollo de Interfaces.

El objetivo principal de este proyecto es ofrecer un control reutilizable para JavaFX que implemente características avanzadas como animaciones, estados visuales y personalización, siguiendo el patrón de diseño de Java Beans.

## Características

El componente cuenta con las siguientes funcionalidades:

* **Propiedades Reactivas:**
    * `switchedOn`: Propiedad booleana para controlar el estado encendido/apagado.
    * `vertical`: Propiedad que permite cambiar la orientación del interruptor mediante una rotación animada.
* **Personalización Visual:**
    * Métodos para definir los colores de estado activo (`colorOn`) y estado inactivo (`colorOff`).
    * Soporte completo para el estado deshabilitado (Disabled), manteniendo la integridad visual.
* **Feedback de Usuario:**
    * Animaciones de desplazamiento y transición de color al cambiar de estado.
    * Cambio dinámico del cursor (mano) al pasar sobre el componente activo.

## Instalación

Para utilizar la librería en un proyecto externo:

1.  Accede a la sección de **[Releases](https://github.com/Josemg5/customComponent/releases)** de este repositorio.
2.  Descarga el archivo `.jar` correspondiente a la última versión estable (v1.0.0).
3.  Añade el archivo descargado al *Build Path* o a las dependencias de tu proyecto.

## Ejemplo de Uso

A continuación se muestra un ejemplo de cómo instanciar el componente, personalizarlo y escuchar sus eventos mediante programación reactiva:

```java
// 1. Instanciar el componente
SwitchButton miInterruptor = new SwitchButton();

// 2. Personalizar apariencia (Opcional)
miInterruptor.setVertical(false);
miInterruptor.setColorOn(Color.web("#4CAF50")); // Verde personalizado

// 3. Gestionar eventos (Uso de Listeners)
miInterruptor.switchedOnProperty().addListener((obs, oldVal, newVal) -> {
    if (newVal) {
        System.out.println("El interruptor se ha encendido");
    } else {
        System.out.println("El interruptor se ha apagado");
    }
});

// 4. Añadir a la interfaz
contenedor.getChildren().add(miInterruptor);