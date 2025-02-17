# MVVM Científicas

Esta aplicación Android utiliza el patrón arquitectónico **MVVM** para mostrar una lista de científicas.
La UI se implementa con *Jetpack Compose* y se manejan tareas asíncronas mediante *Kotlin Coroutines*.
Al interactuar con la lista, se simula una operación asíncrona antes de navegar a la pantalla de detalles.

---

## Descripción

La aplicación **MVVM Científicas** tiene como objetivo mostrar una lista de científicas.
Cada ítem se representa mediante una tarjeta que, al pulsarse, simula una operación asíncrona y
navega a una pantalla de detalles. La interfaz utiliza componentes de *Material Design 3* y
se garantiza una experiencia de usuario moderna y reactiva.

---

## Requisitos de Compilación

Para compilar y ejecutar esta aplicación, asegúrate de contar con los siguientes requisitos:

- **Android Studio Arctic Fox** (o versión superior).
- **Kotlin 1.6** (o superior).
- **Jetpack Compose 1.2** (o superior).
 **Room Database:** Para la persistencia de datos locales.
- Un dispositivo o emulador con **Android 5.0 (API 21)** o superior.

---

## Recursos de Desarrollo

La aplicación hace uso de los siguientes recursos y tecnologías:

- **Arquitectura MVVM:** Separa la lógica de negocio de la interfaz de usuario.
- **Jetpack Compose:** Permite construir interfaces de usuario de manera declarativa.
- **Navigation Component:** Facilita la navegación entre pantallas.
- **Kotlin Coroutines:** Maneja tareas asíncronas de forma sencilla.
- **Material Design 3:** Provee componentes visuales modernos y adaptativos.
- **Room Database:** Permite almacenar y recuperar datos de manera persistente.

---

## Instalación

Para clonar y ejecutar el proyecto, sigue estos pasos:

1. **Clona el repositorio:**

   ```bash
   git clone https://github.com/paulaagni/MVVM_Cientificas_Examen.git
