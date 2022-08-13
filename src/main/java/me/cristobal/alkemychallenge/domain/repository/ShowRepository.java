package me.cristobal.alkemychallenge.domain.repository;

import me.cristobal.alkemychallenge.domain.DTO.Show;

import java.util.List;
import java.util.Optional;

public interface ShowRepository {

  List<Show> findAll();

  Optional<Show> findByName(String showName);

  Optional<Show> findById(Long showId);

  Show save(Show show);

  void deleteById(Long showId);


}
