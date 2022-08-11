package me.cristobal.alkemychallenge.persistence.CRUD;

import me.cristobal.alkemychallenge.persistence.entity.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneroCRUD extends JpaRepository<Genero, String> {

}
