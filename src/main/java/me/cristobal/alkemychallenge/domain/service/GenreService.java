package me.cristobal.alkemychallenge.domain.service;

import lombok.RequiredArgsConstructor;
import me.cristobal.alkemychallenge.domain.DTO.Genre;
import me.cristobal.alkemychallenge.domain.repository.GenreRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class GenreService {

  private final GenreRepository repository;

  public List<Genre> findAll() {
    return repository.findAll();
  }

  public Optional<Genre> findByName(String genreName) {
    return repository.findByName(genreName);
  }

  public Optional<Genre> findById(Long genreId) {
    return repository.findById(genreId);
  }

  public Genre save(Genre genre) {
    if (repository.findByName(genre.getName()).isPresent()) {
      return null;
    }
    return repository.save(genre);
  }

  public boolean delete(Long genreId) {
    return findById(genreId)
            .map(genre -> {
              repository.deleteById(genreId);
              return true;
            }).orElse(false);
  }
}
