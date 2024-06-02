# Literalura-
LiterAlura es un proyecto de Java y Spring sobre un catalogo de libros

![Logo de Alura](https://github.com/jlfd12/Conversor-de-Monedas/assets/67215733/9781ec64-0aac-4605-a1ea-947a25c926fc)


<h1 font-weight="bold">Indice</h1>
<ol>
  <li>Descripción</li>
  <li>Uso</li>
  <li>Características y Demostración</li>
  <li>Herramientas utilizadas</li>
  <li>Desarrollador del proyecto</li>
</ol>

<h1 font-weight="bold">Descripción</h1>
<p>Este proyecto reune la información de los libros ingresados por el usuario y los almacena en una base de datos. De esta manera quedan a disposición del usuario para consulta.
El proyecto permite la consulta de estos mostrando la información de los libros, de los autores, autores vivos en un determinado año y libros en un determinado idioma. Los libros son recopilados haciendo uso de la API de Gutendex (https://gutendex.com/)y almacenados en una base de datos con ayuda de PostgresSQL (https://www.postgresql.org/).
</p>

<h1>Uso</h1>

<p>Descargar la carpeta de archivos del repositorio y abrir en su IDE de preferencia, en este caso se usó IntelliJ. Descargar ademas postgresSQL y el administrador de base de datos de su preferencia. En este caso se hizo uso de PgAdmin4 (https://www.pgadmin.org/download/pgadmin-4-windows/) y crear la base de datos dentro de este con el nombre Literalura. Una vez instalado esto se corre el programa desde la clase LiteraluraApplication</p>

<h1>Caracteristicas y Demostración</h1>

<p>Al inicar el programa se desplega un menú que indica que el ususario debe elegir alguna de las opciones, del 1 al 5, o bien 0 si lo que desea es salir del programa. 
  Para comenzar a hacer un registro de los libros lo primero deberá ser elegir la opción número 1.</p>

![menu](https://github.com/jlfd12/Literalura-/assets/67215733/fc8d050d-521b-405c-9277-355a075d5345)

<p>Si se ingresa una opción del menú inválida este desplegará un mensaje para ingresar una opción válida</p>

![errormenu](https://github.com/jlfd12/Literalura-/assets/67215733/bab910b2-b23b-4fb6-bf86-593d758ddf70)

<p>Al elegir la opción número 1 se pedirá al usuario ingresar el nombre de un libro. El cuál se mostrará a continuación junto con la información relacionada al libro.</p>

![opcion1](https://github.com/jlfd12/Literalura-/assets/67215733/417f3c65-ac76-4d92-beea-82f0a08a6464)

<p>En caso de no estár el libro deseado registrado en la API, se despleplegará un mensaje y deberá intentarlo de nuevo. </p>

![nolibroopcion1](https://github.com/jlfd12/Literalura-/assets/67215733/88c363a4-23d5-4dff-8976-f8a2d3dddbbe)

<p>Una vez registrados todos los libros deseados con la opcion 1 se puede elegir entre cualquiera de las 4 opciones siguentes. Siempre pudiendo registrar más libros.</p>
<p font-weight = "bold">Opción 2: </p>
<p>Muestra todos los libros registrados.</p>

![opcion2](https://github.com/jlfd12/Literalura-/assets/67215733/7f9fee99-ebdd-454f-830f-6b565df8d507)

<p font-weight="bold">Opción 3:</p>
<p>Muestra todos los autores registrados.</p>

![opcion3](https://github.com/jlfd12/Literalura-/assets/67215733/d550b3de-4c34-4fe5-b2a0-67e2b452f0b7)

<p font-weight="bold">Opción 4:</p>
<p>Muestra los autores vivos en determinado año. Para esto, el programa pedirá al usuario ingresar el año deseado y a continuación se mostrarán los autores.</p>

![opcion4](https://github.com/jlfd12/Literalura-/assets/67215733/a774d069-525f-4b8e-b50b-60e0c6444d83)

<p>Si se ingresa un dato que no corresponda a un año se desplegará un mensaje para ingresar una opción válida.</p>

![errorañoautor](https://github.com/jlfd12/Literalura-/assets/67215733/77bed4db-3b03-4d26-a44c-1f24cdf478d5)

<p font-weight="bold">Opción 5:</p>
<p>Muestra los libros escritos en determinado idioma. Para esto, el programa indicará al usuario que ingrese la nomenclatura del idioma indicado en la lista.</p>

![opcion5](https://github.com/jlfd12/Literalura-/assets/67215733/be5f161e-2e32-4a5b-95cd-71d0a9a98b16)

<p>Si se ingresa un dato que no corresponda a alguna de las nomenclaturas dadas se desplegará un mensaje para ingresar una opción válida.</p>

![erroridioma](https://github.com/jlfd12/Literalura-/assets/67215733/69818962-616d-49fd-9a11-6a68240a47fc)


https://github.com/jlfd12/Literalura-/assets/67215733/b1bc038a-ed79-4a39-801b-333083900189


<h1 font-weight="bold">Herramientas utilizadas</h1>

![java](https://github.com/jlfd12/Conversor-de-Monedas/assets/67215733/4437322b-70a5-4c58-8842-99f4284a8fab)

JAVA

![descarga (2)](https://github.com/jlfd12/Literalura-/assets/67215733/55fc15cc-725e-49b3-aff4-160ea4a91590)

POSTGRESSQL

![descarga (3)](https://github.com/jlfd12/Literalura-/assets/67215733/076bca87-ba1d-403d-a0a0-d184abba1a31)

GUTENDEX

<h1 font-weight="bold">Desarrollador del proyecto</h1>

Joanna L. Fernandez

![joannafd](https://github.com/jlfd12/Conversor-de-Monedas/assets/67215733/2d1de9ef-b76b-44a1-ac8c-2f60107de2f7)


