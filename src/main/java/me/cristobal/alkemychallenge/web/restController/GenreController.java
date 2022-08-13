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
    Genre genreToSave = service.save(genre);

    if (genreToSave != null) {
      return new ResponseEntity<>(genreToSave, HttpStatus.OK);
    }
    return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);

  }

  @GetMapping
  public ResponseEntity<List<Genre>> findAll() {
    return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
  }

}
