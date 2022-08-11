package me.cristobal.alkemychallenge.web.restController;

import lombok.RequiredArgsConstructor;
import me.cristobal.alkemychallenge.domain.DTO.Character;
import me.cristobal.alkemychallenge.domain.service.CharacterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/characters")
public class CharacterController {

  private final CharacterService service;

  @PostMapping("/save")
  public ResponseEntity<Character> save(@RequestBody Character character) {
    return new ResponseEntity<>(service.save(character), HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<List<Character>> findAll() {
    return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
  }


}
