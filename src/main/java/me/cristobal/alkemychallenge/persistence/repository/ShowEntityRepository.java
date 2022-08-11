package me.cristobal.alkemychallenge.persistence.repository;

import lombok.RequiredArgsConstructor;
import me.cristobal.alkemychallenge.domain.DTO.Show;
import me.cristobal.alkemychallenge.domain.repository.ShowRepository;
import me.cristobal.alkemychallenge.persistence.CRUD.ShowCRUD;
import me.cristobal.alkemychallenge.persistence.entity.ShowEntity;
import me.cristobal.alkemychallenge.persistence.mapper.ShowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ShowEntityRepository implements ShowRepository {

  private final ShowCRUD crud;
  private final ShowMapper mapper;

  @Override
  public List<Show> findAll() {
    return mapper.toShows((List<ShowEntity>) crud.findAll());
  }

  @Override
  public Optional<Show> findByName(String showName) {
    return crud
            .findById(showName)
            .map(mapper::toShow);
  }

  @Override
  public Show save(Show show) {
    return mapper.toShow(crud.save(mapper.toShowEntity(show)));
  }

  @Override
  public void deleteByName(String showName) {
    crud.deleteById(showName);
  }
}
