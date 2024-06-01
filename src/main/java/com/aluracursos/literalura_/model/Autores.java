package com.aluracursos.literalura_.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "autores")
public class Autores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Integer fechaNacimiento;
    private Integer fechaMuerte;

    @ManyToMany(mappedBy = "autores", fetch = FetchType.EAGER)
    private List<Libro> libro = new ArrayList<>();

    public Autores(){}

    public Autores(DatosAutores datosAutores) {
        this.nombre = datosAutores.nombre();
        this.fechaNacimiento = datosAutores.fechaNacimiento();
        this.fechaMuerte = datosAutores.fechaMuerte();
    }

    public Autores(String nombre, Integer fechaNacimiento, Integer fechaMuerte) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaMuerte = fechaMuerte;
        this.libro = new ArrayList<>();
    }

    public String nombreAutor(){
        return nombre;
    }

    public String toString(){
        String libros = libro.stream()
                .map(Libro::getTitulo)
                .collect(Collectors.joining(", "));
        return  "-----AUTOR-----" + "\n" +
                "Nombre: '" + nombre + '\n' +
                "Fecha de Nacimiento: " + fechaNacimiento + "\n" +
                "Fecha de Muerte: " + fechaMuerte + "\n" +
                "Libros: " + libros + "\n" +
                "---------------" + "\n";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Integer fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getFechaMuerte() {
        return fechaMuerte;
    }

    public void setFechaMuerte(Integer fechaMuerte) {
        this.fechaMuerte = fechaMuerte;
    }

    public List<Libro> getLibro() {
        return libro;
    }

    public void setLibro(List<Libro> libro) {
        this.libro = libro;
    }
}
