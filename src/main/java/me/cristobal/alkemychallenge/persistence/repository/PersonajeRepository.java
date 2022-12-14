package me.cristobal.alkemychallenge.persistence.repository;

import lombok.RequiredArgsConstructor;
import me.cristobal.alkemychallenge.domain.DTO.Character;
import me.cristobal.alkemychallenge.domain.repository.CharacterRepository;
import me.cristobal.alkemychallenge.persistence.CRUD.PersonajeCRUD;
import me.cristobal.alkemychallenge.persistence.mapper.CharacterMapper;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
@RequiredArgsConstructor
public class PersonajeRepository implements CharacterRepository {

  private final PersonajeCRUD crud;
  private final CharacterMapper mapper;

  @Override
  public List<Character> findAll() {
    return mapper.toCharacters(crud.findAll());
  }

  @Override
  public Optional<Character> findById(Long characterId) {
    return crud
            .findById(characterId)
            .map(mapper::toCharacter);
  }

  @Override
  public Optional<Character> findByName(String characterName) {
    return crud
            .findByNombre(characterName)
            .map(mapper::toCharacter);
  }

  @Override
  public Character save(Character character) {
    return mapper.toCharacter(crud.save(mapper.toPersonaje(character)));
  }

  @Override
  public void deleteById(Long characterId) {
    crud.deleteById(characterId);
  }

  @Override
  public List<Character> findByAge(int age) {
    return mapper.toCharacters(crud.findByEdad(age));
  }

  @Override
  public List<Character> findByWeight(Double weight) {
    return mapper.toCharacters(crud.findByPeso(weight));
  }
}
