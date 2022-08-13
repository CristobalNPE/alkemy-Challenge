package me.cristobal.alkemychallenge.domain.repository;

import me.cristobal.alkemychallenge.domain.DTO.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreRepository {

  List<Genre> findAll();

  Optional<Genre> findById(Long genreId);
  Optional<Genre> findByName(String genreName);

  Genre save(Genre genre);

  void deleteById(Long Id);

}
