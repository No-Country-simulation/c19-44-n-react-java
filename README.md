<h1 align="center"> MediConnect</h1>

![logo](https://github.com/user-attachments/assets/26a87b29-f3da-42ae-a7db-150539b684e2)


![Static Badge](https://img.shields.io/badge/release%20date-july-Green)![Static Badge](https://img.shields.io/badge/status-en%20desarrollo-yellow)![Static Badge](https://img.shields.io/badge/language-java-red?style=for-the-badge)

<h4 align="center">
:construction: Proyecto en construcción :construction:
</h4>

## 🚀Descripción del proyecto:
Este proyecto ha sido realizado como parte de la simulación realizada por NoCountry, en la que se forma un equipo multidisciplinario para llevar a cabo un proyecto desde la idea a la ejecución, cada miembro del equipo 
debe tener el perfil necesario para realizar laborar individuales y trabajar en equipo.  El proyecto que nuestro equipo eligió se trata de una herramienta para profesionales o empresas prestadoras de servicios de salud
que aporta una solución a muchas dificultades que trae consigo la atención médica brindada de forma tradicional.

El proyecto realizado con el lenguaje Java en su version 17 usando Spring Boot para creación del proyecto y usando el IDE IntelliJ Idea.

## 💻Quienes Somos 🧑‍💻:
- `UX/UI Designer`: Daily Fuenmayor
- `Backend Developer`: Maria Campos
- `Backend Developer`: Heriberto Amaya

## ⚙️Funcionalidades Actuales:
- `Registro de Usuarios`: Los usuarios pueden registrarse para tener un perfil desde el cual podran gestionar su atención.
- `Generar Turno`: El usuario resgistrado puede agendar un turno al seleccionar la especialidad médica que necesita y la fecha/hora que desea su turno.

## ⚙️Funcionalidades por Implementar:
- `Edicion de perfil`: El usuario será capaz de agregar información para completar su información.
- `Acceso a Médicos`: El cliente podra interactuar con los usuarios desde un perfil en cual podran gestionar y atender los turnos generados.
- `Y Mas...`

## 🛠️Funcionamiento de la Aplicación:
<h4 align="center"> Preparar el ambiente para ejecutar la aplicación: </h4>

- `Paso 1`
<p>Es necesario el uso de un IDE capaz de compilar proyectos Java, como Netbeans, Eclipse o IntelliJ IDEA, estos deben usar el JDK version 17. Abrimos el IDE y agregamos el proyecto con File -> Open -> Seleccionamos la carpeta de Backend. Se verá así: </p>

![intellij](https://github.com/user-attachments/assets/5f99918d-1d0b-4c94-a6bd-fffde7f94122)

- `Paso 2`

<p>Creamos nuestra base de datos en MySQL Workbench y le damos el nombre apropiado.</p>

- `Paso 3`

<p>En el archivo application.properties de nuestro IDE configuramos el acceso a nuestra base de datos.<br>

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver<br>
spring.datasource.url=jdbc:mysql://localhost:3306/telemedicina<br>
spring.datasource.username=root<br>
spring.datasource.password=1234567890<br>

Siendo "telemedicina" el nombre de nuestra base de datos, "root" el usuario y "1234567890" la contraseña. Reemplazamos los datos que sean necesarios de acuerdo al entorno local.
</p>

- `Paso 4`

<p>Una vez completas las configuraciones necesarias se procede a ejecutarlo, damos doble click a el archivo ClinicaVirtualApplication.java para abrirlo y dando click en el icono color verde triangular(▶️) se ejecutará. Si todo sale bien se mostrara al final de log, el puerto local donde fue desplegado el proyecto, el mas común es el 8080. Nuestra webApp utiliza Hibernate, que es una tecnología que al momento de correr la aplicacion por primera vez se construyen las tablas dentro de la base de datos.</p>

![run project](https://github.com/user-attachments/assets/24946c6d-2813-4981-8501-647c5ff73345)

- `Paso 5`

<p>Dentro de MySQL Workbench seleccionamos trabajar con nuestra base de datos y luego debemos ejecutar el siguiente código, que sera necesario para la generación de turnos:
  
insert into medicos (name, especialidad) values ('Heri Gaitan', 'Cardiología');<br>
insert into medicos (name, especialidad) values ('Daily Fuenmayor', 'Ginecología');<br>
insert into medicos (name, especialidad) values ('María Campos', 'Pediatría');<br>
insert into medicos (name, especialidad) values ('Brenda', 'Oftalmología');<br>

Esto paso será usado de forma temporal, ya que en el futuro generaremos el usuario de tipo administrador que podra gestionar a los médicos desde su perfil. </p>

- `Paso 5`

<p>Ahora pasamos a abrir el Visual Studio Code, siguiendo los pasos File -> Open Folder -> Seleccionamos la carpeta de Frontend. Hecho lo anterior veremos las carpetas y archivos, dando click derecho sobre el archivo index.html y seleccionando la opcion 'Open with Live Server' se ejecutara de forma local nuestro proyecto Frontend, nos aparecerá una notificación informando el puerto local usado para desplegarlo. Se abrira una pestaña en nuestro navegador con el proyecto totalmente cargado, conectado y listo para ser usado.</p>



## ✔️Tecnologías utilizadas:
- `Figma`:
- `HTML5, CSS y Javascript`
- `Java 17`
- `Spring Boot`
- `Maven`
- `Hibernate`
- `Insomnia`
- `MySQL Workbench`


## Autores

| [<img src="https://avatars.githubusercontent.com/u/174158607?v=4" width=115><br><sub>Daily Fuenmayor, UX/UI Designer</sub>](https://github.com/dailyFuenmayor)|
| :---: |
| [<img src="https://avatars.githubusercontent.com/u/157176273?v=4" width=115><br><sub>Maria Campos, Backend Developer</sub>](https://github.com/MariaCampos97)|
| [<img src="https://avatars.githubusercontent.com/u/150280699?v=4" width=115><br><sub>Heriberto Amaya, Backend Developer</sub>](https://github.com/Gildartz08)|
| [<img src="https://avatars.githubusercontent.com/u/156859650?v=4" width=115><br><sub>Julieta Mores, Team Leader</sub>](https://github.com/julieta-mores-t)|
