package me.cristobal.alkemychallenge.persistence.CRUD;

import me.cristobal.alkemychallenge.persistence.entity.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonajeCRUD extends JpaRepository<Personaje, Long> {

  Optional<Personaje> findByNombre(String nombre);

  List<Personaje> findByEdad(int edad);

  List<Personaje> findByPeso(Double edad);

  /*Falat metodo para filtrar por shows en las que participa */
}
