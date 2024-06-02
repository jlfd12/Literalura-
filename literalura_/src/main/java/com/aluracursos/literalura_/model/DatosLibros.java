package com.aluracursos.literalura_.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibros(
        @JsonAlias("title")String titulo,
        @JsonAlias("authors") List<DatosAutores> autores,
        @JsonAlias("languages") List<String> idiomas,
        @JsonAlias("download_count")Double numeroDescargas
) {
public String toString(){
     return " -----LIBRO-----"+"\n"+
            "Titulo: " +titulo+"\n"+
            "Autor: " +autores+"\n"+
            "Idioma: " +idiomas+"\n"+
            "Número de descargas: " +numeroDescargas+"\n" +"-------------";

   }
}
