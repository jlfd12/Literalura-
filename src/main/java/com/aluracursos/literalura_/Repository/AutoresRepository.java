package com.aluracursos.literalura_.Repository;

import com.aluracursos.literalura_.model.Autores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutoresRepository extends JpaRepository<Autores, Long> {

    @Query("SELECT a FROM Autores a WHERE a.fechaNacimiento <= :fecha AND (a.fechaMuerte IS NULL OR a.fechaMuerte >= :fecha)")
    List<Autores> obtenerAutoresVivos(int fecha);

    List<Autores> findByNombre(String nombre);
}
