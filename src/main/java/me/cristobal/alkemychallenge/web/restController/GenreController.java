package me.cristobal.alkemychallenge.web.restController;

import lombok.RequiredArgsConstructor;
import me.cristobal.alkemychallenge.domain.DTO.Genre;
import me.cristobal.alkemychallenge.domain.service.GenreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/genre")
public class GenreController {

  private final GenreService service;

  @PostMapping("/save")
  public ResponseEntity<Genre> save(@RequestBody Genre genre) {
    return new ResponseEntity<>(service.save(genre), HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<List<Genre>> findAll() {
    return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
  }

}
