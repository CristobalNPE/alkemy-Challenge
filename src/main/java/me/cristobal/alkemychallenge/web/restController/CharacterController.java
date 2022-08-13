package me.cristobal.alkemychallenge.web.restController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.cristobal.alkemychallenge.domain.DTO.Character;
import me.cristobal.alkemychallenge.domain.service.CharacterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/characters")
public class CharacterController {

  private final CharacterService service;

  @PostMapping("/save")
  public ResponseEntity<Character> save(@RequestBody Character character) {


    character.setAssociatedShows(new ArrayList<>()); //Should this be a SET?

    return new ResponseEntity<>(service.save(character), HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<List<Character>> findAll() {
    return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Character> findById(@PathVariable("id") Long characterId) {
    if (service.findByID(characterId).isPresent()) {
      return new ResponseEntity<>(service.findByID(characterId).get(), HttpStatus.OK);
    }
    return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
  }

  @GetMapping(params = "name")
  @ResponseBody
  public ResponseEntity<Character> findByName(@RequestParam String name) {
    if (service.findByName(name).isPresent()) {
      return new ResponseEntity<>(service.findByName(name).get(), HttpStatus.OK);
    }
    return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
  }

  @GetMapping(params = "weight")
  @ResponseBody
  public ResponseEntity<List<Character>> findByWeight(@RequestParam Double weight) {
    List<Character> foundChars = service.findByWeight(weight);
    if (!foundChars.isEmpty()) {
      return new ResponseEntity<>(service.findByWeight(weight), HttpStatus.OK);
    }
    return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
  }

  @GetMapping(params = "age")
  @ResponseBody
  public ResponseEntity<List<Character>> findByAge(@RequestParam Integer age) {
    List<Character> foundChars = service.findByAge(age);
    if (!foundChars.isEmpty()) {
      return new ResponseEntity<>(service.findByAge(age), HttpStatus.OK);
    }
    return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteCharacterById(@PathVariable("id") Long characterId) {
    if (service.delete(characterId)) {
      return new ResponseEntity<>("Character deleted successfully", HttpStatus.OK);
    }
    return new ResponseEntity<>("Character not found", HttpStatus.NOT_FOUND);
  }


}
