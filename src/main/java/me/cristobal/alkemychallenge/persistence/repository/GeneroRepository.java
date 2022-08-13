package me.cristobal.alkemychallenge.persistence.repository;

import lombok.RequiredArgsConstructor;
import me.cristobal.alkemychallenge.domain.DTO.Genre;
import me.cristobal.alkemychallenge.domain.repository.GenreRepository;
import me.cristobal.alkemychallenge.persistence.CRUD.GeneroCRUD;
import me.cristobal.alkemychallenge.persistence.entity.Genero;
import me.cristobal.alkemychallenge.persistence.mapper.GenreMapper;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
@RequiredArgsConstructor
public class GeneroRepository implements GenreRepository {

  private final GeneroCRUD crud;
  private final GenreMapper mapper;

  @Override
  public List<Genre> findAll() {
    return mapper.toGenres((List<Genero>) crud.findAll());
  }

  @Override
  public Optional<Genre> findById(Long genreId) {
    return crud.findById(genreId).map(mapper::toGenre);
  }

  @Override
  public Optional<Genre> findByName(String genreName) {
    return crud
            .findByNombre(genreName)
            .map(mapper::toGenre);
  }

  @Override
  public Genre save(Genre genre) {
    return mapper.toGenre(crud.save(mapper.toGenero(genre)));
  }

  @Override
  public void deleteById(Long genreId) {
    crud.deleteById(genreId);
  }
}
