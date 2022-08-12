package me.cristobal.alkemychallenge.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Genero {

  @Id
  private String nombre;
  private String imagen;

  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @ToString.Exclude
  private List<ShowEntity> listaShows;
}
