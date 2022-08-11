package me.cristobal.alkemychallenge.persistence.CRUD;

import me.cristobal.alkemychallenge.persistence.entity.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonajeCRUD extends JpaRepository<Personaje, String> {
}
