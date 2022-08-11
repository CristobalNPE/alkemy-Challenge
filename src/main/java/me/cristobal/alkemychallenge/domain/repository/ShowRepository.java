package me.cristobal.alkemychallenge.domain.repository;

import me.cristobal.alkemychallenge.domain.DTO.Show;

import java.util.List;
import java.util.Optional;

public interface ShowRepository {

  List<Show> findAll();

  Optional<Show> findByName(String showName);

  Show save(Show show);

  void deleteByName(String showName);


}
