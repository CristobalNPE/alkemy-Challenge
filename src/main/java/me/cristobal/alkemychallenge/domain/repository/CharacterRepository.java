package me.cristobal.alkemychallenge.domain.repository;

import me.cristobal.alkemychallenge.domain.DTO.Character;

import java.util.List;
import java.util.Optional;

public interface CharacterRepository {

  List<Character> findAll();

  Optional<Character> findById(Long characterId);

  Optional<Character> findByName(String characterName);

  Character save(Character character);

  void deleteById(Long characterId);

  List<Character> findByAge(int age);

  List<Character> findByWeight(Double age);
}
