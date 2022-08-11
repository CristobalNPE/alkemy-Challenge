package me.cristobal.alkemychallenge.persistence.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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

  @ManyToMany
  private List<ShowEntity> listaShows;
}
