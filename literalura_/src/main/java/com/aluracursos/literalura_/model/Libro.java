package com.aluracursos.literalura_.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "libro")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String titulo;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(
            name="autores_libro",
            joinColumns = @JoinColumn(name="libro_id"),
            inverseJoinColumns = @JoinColumn(name="autores_id")
    )
    private List<Autores> autores = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "libro_idiomas", joinColumns = @JoinColumn(name = "libro_id"))
    @Column(name = "idioma")
    private List<String> idiomas;

    private Double numeroDescargas;

    public Libro(){ }

    public Libro(DatosLibros datosLibros) {
        this.titulo = datosLibros.titulo();
        this.autores = datosLibros.autores().stream()
                .map(d -> new Autores(d.nombre(), d.fechaNacimiento(), d.fechaMuerte()))
                .collect(Collectors.toList());
        this.idiomas = datosLibros.idiomas();
        this.numeroDescargas = datosLibros.numeroDescargas();
    }

    public String toString(){
        String nombreAutor = autores.stream()
                .map(Autores::nombreAutor)
                .collect(Collectors.joining(", "));
        return " -----LIBRO-----"+"\n"+
                "Titulo: " +titulo+"\n"+
                "Autor: " +nombreAutor+"\n"+
                "Idioma: " +idiomas+"\n"+
                "Número de descargas: " +numeroDescargas+"\n" +"-------------";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autores> getAutores() {
        return autores;
    }

    public void setAutores(List<Autores> autor) {
        this.autores = autor;
    }

    public List<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<String> idiomas) {
        this.idiomas = idiomas;
    }

    public Double getNumeroDescargas() {
        return numeroDescargas;
    }

    public void setNumeroDescargas(Double numeroDescargas) {
        this.numeroDescargas = numeroDescargas;
    }
}
