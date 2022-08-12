package me.cristobal.alkemychallenge.persistence.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Personaje {

  private String imagen;
  @Id
  private String nombre;
  private Integer edad;
  private Double peso;
  private String historia;

  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @ToString.Exclude
  private List<ShowEntity> showsAsociados;

}
