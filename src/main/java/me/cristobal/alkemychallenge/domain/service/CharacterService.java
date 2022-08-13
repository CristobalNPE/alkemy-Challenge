package me.cristobal.alkemychallenge.domain.service;

import lombok.RequiredArgsConstructor;
import me.cristobal.alkemychallenge.domain.DTO.Character;
import me.cristobal.alkemychallenge.domain.repository.CharacterRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CharacterService {

  private final CharacterRepository repository;

  public List<Character> findAll() {
    return repository.findAll();
  }

  public Optional<Character> findByID(Long characterId) {
    return repository.findById(characterId);
  }

  public Optional<Character> findByName(String characterName) {
    return repository.findByName(characterName);
  }

  public Character save(Character character) {


    return repository.save(character);
  }

  public boolean delete(Long characterId) {
    return findByID(characterId)
            .map(character -> {
              repository.deleteById(characterId);
              return true;
            }).orElse(false);
  }

  public List<Character> findByAge(int age) {
    return repository.findByAge(age);
  }

  public List<Character> findByWeight(Double weight) {
    return repository.findByWeight(weight);
  }
}
