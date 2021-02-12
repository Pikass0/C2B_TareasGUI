<!--
*** Plantilla de readme hecha por othneildrew
-->


<!-- PROJECT SHIELDS -->
![language-shield]
![release-shield]
[![Contributors][contributors-shield]][contributors-url] 
[![Issues][issues-shield]][issues-url]
[![Contact][discord-shield]][discord-url]




<!-- PROJECT LOGO -->
<br />
<p align="center">
  <h3 align="center">Proyecto Kanban con Swing</h3>

  <p align="center">
    El mismo proyecto de siempre, esta vez con GUI de Java: Swing
    <br />
    ·
    <a href="https://github.com/Pikass0/C2B_TareasGUI/issues">Report Bug</a>
    ·
    <a href="https://github.com/Pikass0/C2B_TareasGUI/issues">Request Feature</a>
  </p>
</p>



<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary>Contenido</summary>
  <ol>
    <li>
      <a href="#sobre-el-proyecto">Sobre el proyecto</a>
      <ul>
        <li><a href="#tecnologías">Tecnologías usadas</a></li>
      </ul>
    </li>
    <li>
      <a href="#probar-el-proyecto">Probar el proyecto</a>
      <ul>
        <li><a href="#requisitos">Requisitos</a></li>
        <li><a href="#instalación">Instalación</a></li>
      </ul>
    </li>
    <li><a href="#uso">Uso</a></li>
    <li><a href="#contribución">Contrubución</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## Sobre el proyecto

![product-screenshot]<!--(https://example.com) por si se quiere metir link-->

Clásico Kanban, un tablero formado por tres listas para poder organizarse por tareas. Las listas suelen ser: To Do, In Progres, Done. (Pendiente, en progreso, terminado)

¿Qué cosas se pueden hacer?
* Mover una tarea de una lista a otra con ayuda de los botones
* Crear tareas las cuales por defecto aparecerán como pendientes
* Eliminar una o varias tareas al mismo tiempo
* Archivar una o varias tareas al mismo tiempo, aunque no se pueden desarchivar en esta versión, pero se quedan guardadas en la base de datos
* Botón de refrescar, si por cualquier motivo no se ha actualizado el tablero


### Tecnologías

Herramientas usadas:
* Swing
* Base de datos Derby con pool de conexiones



<!-- GETTING STARTED -->
## Probar el proyecto

Cómo ejecutar el proyecto:

### Requisitos

Descargar el Driver JDBC [Derby](http://db.apache.org/derby/derby_downloads.html)


### Instalación

1. Crear una base de datos con el nombre _Tareas_, sin usuario ni contraseña.

2. Clonar repositorio
   ```sh
   git clone https://github.com/Pikass0/C2B_TareasGUI.git
   ```

3. Poblar la base de datos, ejecutando `dbScript.sql`, que se encuentra en el paquete `tareas.db`

4. Ejecutar MainFrame.java y empezar a organizar tus proyectos, ¿¿¿quién quiere Trello teniendo C2B_TareasGUI???


<!-- USAGE EXAMPLES -->
## Uso

* Mover: solo se puede mover una tarea. Hay que seleccionarla y moverla con los botones
* Crear: creará una nueva tarea
* Eliminar: eliminará todas las tareas seleccionadas, para hacer selección multiple, utiliza <kbd>Ctrl</kbd> + <kbd>Click</kbd> o también puedes <kbd>Shift</kbd> + <kbd>Click</kbd> para seleccionar varías de golpe-
* Archivar: funciona de la misma manera que elimar, solo que las tareas se archivarán (en esta versión no podrás recuperarlas, pero podrás verlas en la base de datos).
* Refrescar: refresca la pantalla leyendo de nuevo todo desde la base de datos, por si no se ha actualizado


<!-- CONTRIBUTING -->
## Contribución

Si quieres contribuir:

1. Fork el proyecto
2. Crea tu rama (`git checkout -b feature/AmazingFeature`)
3. Commit los cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un [Pull request](https://github.com/Pikass0/C2B_TareasGUI/pulls)






<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->

[language-shield]: https://img.shields.io/badge/language-black?style=flat&logo=java
[release-shield]: https://img.shields.io/badge/release%20date-Nov%202020-lightgrey

[discord-shield]: https://img.shields.io/badge/chat-on%20discord-7289da.svg?style=flat&logo=discord
[discord-url]: https://www.discord.com/users/290575161869205504
[contributors-shield]: https://img.shields.io/github/contributors/Pikass0/C2B_TareasGUI?color=green
[contributors-url]: https://github.com/Pikass0/C2B_TareasGUI/graphs/contributors
[issues-shield]: https://img.shields.io/github/issues-raw/Pikass0/C2B_TareasGUI?color=orange
[issues-url]: https://github.com/Pikass0/C2B_TareasGUI/issues
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=flat&logo=linkedin&color=blue

[product-screenshot]: images/readme_swing.jpg
