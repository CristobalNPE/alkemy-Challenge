package me.cristobal.alkemychallenge.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Character {

  private String img;
  private String name;
  private Integer age;
  private Double weight;
  private String history;
  private List<ShowData> associatedShows;  //Show es interfaz para peliculas/series(movies/series/)

}
