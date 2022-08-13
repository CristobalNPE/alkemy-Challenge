package me.cristobal.alkemychallenge.persistence.CRUD;

import me.cristobal.alkemychallenge.persistence.entity.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GeneroCRUD extends JpaRepository<Genero, Long> {

  Optional<Genero> findByNombre(String nombreGenero);

}
