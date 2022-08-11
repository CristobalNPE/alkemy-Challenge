package me.cristobal.alkemychallenge.domain.service;

import lombok.RequiredArgsConstructor;
import me.cristobal.alkemychallenge.domain.DTO.Character;
import me.cristobal.alkemychallenge.domain.DTO.Show;
import me.cristobal.alkemychallenge.domain.repository.CharacterRepository;
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

  public Show save(Show show) {
    return repository.save(show);
  }

  public boolean delete(String showName) {
    return findByName(showName)
            .map(show -> {
              repository.deleteByName(showName);
              return true;
            }).orElse(false);
  }
}
