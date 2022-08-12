package me.cristobal.alkemychallenge.web.restController;

import lombok.RequiredArgsConstructor;
import me.cristobal.alkemychallenge.domain.DTO.Show;
import me.cristobal.alkemychallenge.domain.service.ShowService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shows")
public class ShowController {

  private final ShowService service;

  @PostMapping("/save")
  public ResponseEntity<Show> save(@RequestBody Show show) {
    return new ResponseEntity<>(service.save(show), HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<List<Show>> findAll() {
    return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
  }
}
