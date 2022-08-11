package me.cristobal.alkemychallenge.persistence.CRUD;

import me.cristobal.alkemychallenge.persistence.entity.ShowEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowCRUD extends JpaRepository<ShowEntity, String> {
}
