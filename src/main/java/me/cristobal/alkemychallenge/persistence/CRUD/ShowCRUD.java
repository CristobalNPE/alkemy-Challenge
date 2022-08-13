package me.cristobal.alkemychallenge.persistence.CRUD;

import me.cristobal.alkemychallenge.persistence.entity.ShowEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShowCRUD extends JpaRepository<ShowEntity, Long> {

  Optional<ShowEntity> findByTitulo(String showTitle);
}
