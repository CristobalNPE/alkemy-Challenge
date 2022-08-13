package me.cristobal.alkemychallenge.persistence.repository;

import lombok.RequiredArgsConstructor;
import me.cristobal.alkemychallenge.domain.DTO.Show;
import me.cristobal.alkemychallenge.domain.repository.ShowRepository;
import me.cristobal.alkemychallenge.persistence.CRUD.ShowCRUD;
import me.cristobal.alkemychallenge.persistence.entity.ShowEntity;
import me.cristobal.alkemychallenge.persistence.mapper.ShowMapper;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
@RequiredArgsConstructor
public class ShowEntityRepository implements ShowRepository {

  private final ShowCRUD crud;
  private final ShowMapper mapper;

  @Override
  public List<Show> findAll() {
    return mapper.toShows(crud.findAll());
  }

  @Override
  public Optional<Show> findByName(String showTitle) {
    return crud
            .findByTitulo(showTitle)
            .map(mapper::toShow);
  }

  @Override
  public Optional<Show> findById(Long showId) {
    return crud
            .findById(showId)
            .map(mapper::toShow);
  }

  @Override
  public Show save(Show show) {
    return mapper.toShow(crud.save(mapper.toShowEntity(show)));
  }

  @Override
  public void deleteById(Long showId) {
    crud.deleteById(showId);

  }
}
