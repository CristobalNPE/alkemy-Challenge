package me.cristobal.alkemychallenge.domain.repository;

import me.cristobal.alkemychallenge.domain.DTO.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreRepository {

  List<Genre> findAll();

  Optional<Genre> findByName(String genre);

  Genre save(Genre genre);

  void deleteByName(String genre);

}
