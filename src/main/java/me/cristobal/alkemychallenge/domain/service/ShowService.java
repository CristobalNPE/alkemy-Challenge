package me.cristobal.alkemychallenge.domain.service;

import lombok.RequiredArgsConstructor;
import me.cristobal.alkemychallenge.domain.DTO.Show;
import me.cristobal.alkemychallenge.domain.repository.ShowRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShowService {

  private final ShowRepository repository;

  public List<Show> findAll() {
    return repository.findAll();
  }

  public Optional<Show> findByName(String showName) {
    return repository.findByName(showName);
  }

  public Optional<Show> findById(Long showId) {
    return repository.findById(showId);
  }

  public Show save(Show show) {
    return repository.save(show);
  }

  public boolean delete(Long showId) {
    return findById(showId)
            .map(show -> {
              repository.deleteById(showId);
              return true;
            }).orElse(false);
  }
}
