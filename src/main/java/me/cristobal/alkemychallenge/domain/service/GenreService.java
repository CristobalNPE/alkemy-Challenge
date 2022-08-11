package me.cristobal.alkemychallenge.domain.service;

import lombok.RequiredArgsConstructor;
import me.cristobal.alkemychallenge.domain.DTO.Genre;
import me.cristobal.alkemychallenge.domain.repository.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GenreService {

  private final GenreRepository repository;

  public List<Genre> findAll() {
    return repository.findAll();
  }

  public Optional<Genre> findByName(String genreName) {
    return repository.findByName(genreName);
  }

  public Genre save(Genre genre) {
    return repository.save(genre);
  }

  public boolean delete(String genreName) {
    return findByName(genreName)
            .map(genre -> {
              repository.deleteByName(genreName);
              return true;
            }).orElse(false);
  }
}
