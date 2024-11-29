# Prueba del Conocimiento 1.2.0

## Descripción

"Prueba del Conocimiento 1.2.0" es un proyecto desarrollado en Java utilizando NetBeans IDE. Este proyecto tiene como objetivo proporcionar una plataforma, junto con la funcionalidad de preguntas y respuestas para evaluar el conocimiento en diferentes materias.

## Estructura del Proyecto

El proyecto está organizado en varios paquetes y archivos, cada uno con un propósito específico:

- **Formularios**: Contiene las interfaces gráficas de usuario (GUI) para la interacción con el usuario.
  - `ingresar_usuario.form` y `ingresar_usuario.java`: Formulario y lógica para el ingreso de usuarios.
  - `Splash.form` y `Splash.java`: Pantalla de bienvenida al iniciar la aplicación.
  - `MainPage.java`: Página principal de la aplicación.

- **Objetos**: Define las clases de la DB que representan los datos y operaciones del sistema.
  - `Usuario.java`: Clase que representa a un usuario con atributos como nombre, email, y puntos.
  - `Pregunta.java`: Clase que representa una pregunta con atributos como materia, tema, y respuestas.

- **Laberintos**: Contiene la lógica y las interfaces para el juego de laberintos.
  - `LaberintoVentana.form` y `LaberintoVentana.java`: Ventana principal del juego de laberintos.
  - `LaberintoPanel.form`: Panel de interfaz para el juego.

- **MateriasPanels**: Paneles relacionados con las materias del juego.
  - `TroncoComunPanel.form`: Panel para la sección de Tronco Común.
  - `InformaticaPanel.form`: Panel para la sección de Informática.
  - etc...

## Archivos de Configuración

- **nbproject**: Contiene archivos de configuración del proyecto para NetBeans.
  - `project.xml`: Configuración del proyecto.
  - `project.properties`: Propiedades del proyecto, como rutas de compilación y configuración de JDK.
  - `build-impl.xml`: Script de construcción generado automáticamente.

- **build.xml**: Script de construcción principal que puede ser personalizado para ajustar el proceso de construcción del proyecto.

- **.gitignore**: Lista de archivos y directorios que deben ser ignorados por Git.

- **manifest.mf**: Archivo de manifiesto para la configuración del JAR resultante.

## Requisitos del Sistema

- **Java Development Kit (JDK) 22**: El proyecto está configurado para compilarse con JDK 22.
- **NetBeans IDE**: Recomendado para facilitar la gestión y ejecución del proyecto.

## Instrucciones de Instalación

1. Clona el repositorio en tu máquina local.
   ```bash
   git clone https://github.com/tu-usuario/Prueba_del_Conocimiento_1.2.git
   ```

2. Abre el proyecto en NetBeans IDE.

3. Asegúrate de que el JDK 22 esté configurado como la plataforma activa en NetBeans.

4. Ejecuta el proyecto desde NetBeans para iniciar la aplicación.

## Uso

- **Ingreso de Usuario**: Permite a los usuarios registrarse e iniciar sesión.
- **Juego de Laberintos**: Inicia el juego de laberintos desde la ventana principal.
- **Preguntas y Respuestas**: Evalúa el conocimiento del usuario en diferentes materias.

## Contribuciones

Las contribuciones son bienvenidas. Por favor, sigue los pasos estándar de GitHub para contribuir al proyecto.


## Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo `LICENSE` para más detalles.
