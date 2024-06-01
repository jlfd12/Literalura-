package com.aluracursos.literalura_.principal;

import com.aluracursos.literalura_.Repository.AutoresRepository;
import com.aluracursos.literalura_.Repository.LibrosRepository;
import com.aluracursos.literalura_.Service.ConsumoAPI;
import com.aluracursos.literalura_.Service.ConvierteDatos;
import com.aluracursos.literalura_.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
@Component
public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private final String URL_BASE = "https://gutendex.com/books/";
    private ConvierteDatos conversor = new ConvierteDatos();
    private LibrosRepository repositorio;
    private AutoresRepository autoresRepositorio;


    @Autowired
    public Principal(LibrosRepository repositorio, AutoresRepository autoresRepositorio) {
        this.repositorio = repositorio;
        this.autoresRepositorio = autoresRepositorio;
    }

    public Principal() {

    }

   public void muestraElMenu() {
       int opcion = -1;
       while (opcion != 0) {
           var menu = """
                                       
                   1 - Buscar libro por titulo 
                   2 - Listar libros registrados
                   3 - Listar autores registrados
                   4 - Listar autores vivos en un determinado año
                   5 - Listar libros por idioma
                                 
                   0 - Salir
                   """;
           System.out.println(menu);
           String input = teclado.nextLine();

           try{
               opcion = Integer.parseInt(input);
               switch (opcion) {
                   case 1:
                       buscarLibroPorTitulo();
                       break;
                   case 2:
                       librosRegistrados();
                       break;
                   case 3:
                       autoresRegistrados();
                       break;
                   case 4:
                       autoresVivos();
                       break;
                   case 5:
                       librosPorIdioma();
                       break;
                   case 0:
                       System.out.println("Cerrando la aplicación...");
                       break;
                   default:
                       System.out.println("Opción inválida");
               }
           } catch(NumberFormatException e){
               System.out.println("Entrada inválida. Por favor, ingrese una de las opciones mostradas en el menú");
           }
       }
   }

   public void buscarLibroPorTitulo(){
        System.out.println("Ingrese el nombre del libro que desea buscar: ");
        var tituloLibro = teclado.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE+"?search="+tituloLibro.replace(" ", "+"));
        var busqueda = conversor.obtenerDatos(json, Datos.class);
        if (busqueda != null && !busqueda.resultados().isEmpty()) {
            Optional<DatosLibros> datosBusqueda = busqueda.resultados().stream().
                    filter(l -> l.titulo().toUpperCase().contains(tituloLibro.toUpperCase())).
                    findFirst();
            DatosLibros datos = datosBusqueda.get();
            Libro libro = new Libro(datos);

            Libro libroGuardado = repositorio.save(libro);

            if (!datos.autores().isEmpty()) {
                for (DatosAutores datosAutor : datos.autores()) {
                    List<Autores> autorExistente = autoresRepositorio.findByNombre(datosAutor.nombre());
                    Autores autor;
                    if (!autorExistente.isEmpty()) {
                        autor = autorExistente.get(0);
                    } else {
                        autor = new Autores(datosAutor);
                    }
                    autor.getLibro().add(libroGuardado);
                    autoresRepositorio.save(autor);
                }

                System.out.println(datos);
            }
        }else {
            System.out.println("Libro no encontrado");
        }
   }


    public void librosRegistrados(){
        List<Libro> libros = repositorio.findAll();
        libros.stream()
                .sorted(Comparator.comparing(Libro::getTitulo))
                .forEach(System.out::println);
    }

    public void autoresRegistrados(){
        List<Autores> autores = autoresRepositorio.findAll();
        autores.stream()
                .sorted(Comparator.comparing(Autores::getNombre))
                .forEach(System.out::println);
    }

    public void autoresVivos(){
        System.out.println("Ingrese el año del cual desea obtener los autores: ");

        String input = teclado.nextLine();
        int fecha = 0;
        try{
            fecha = Integer.parseInt(input);
        }catch(NumberFormatException e){
            System.out.println("Entrada inválida. Ingrese un año en el formato adecuado. ej. 1950");
            return;
        }
        List<Autores> autoresVivos = autoresRepositorio.obtenerAutoresVivos(fecha);
        if(!autoresVivos.isEmpty()){
            autoresVivos.stream()
                    .sorted(Comparator.comparing(Autores::getNombre))
                    .forEach(System.out::println);
        }else{
            System.out.println("No se encontró información");
        }
    }

    public void librosPorIdioma() {
        List<String> idiomasPermitidos = List.of("en", "es", "pt", "fr", "it");
        boolean entradaValida = false;
        String idioma = "";
        while (!entradaValida) {
            System.out.println("""
                            Ingrese el idioma del cual desea obtener los libros:
                                            
                            en - inglés
                            es - español
                            pt -portugués
                            fr - francés
                            it - italiano
                                            
                            """);

            idioma = teclado.nextLine();
            if (idioma.length() != 2 || !idiomasPermitidos.contains(idioma)) {
                System.out.println("Entrada invalida. Ingrese únicamente la nomenclatura del idioma. ej. es");
            } else {
                entradaValida = true;
            }
        }

        List<Libro> libros = repositorio.libroPorIdiomas(idioma);
        if (!libros.isEmpty()) {
            libros.stream()
                    .sorted(Comparator.comparing(Libro::getTitulo))
                    .forEach(System.out::println);
        } else {
            System.out.println("No se encontró información");
        }
    }

}
