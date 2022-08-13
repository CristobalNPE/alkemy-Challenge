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

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String imagen;
  private String nombre;
  private Integer edad;
  private Double peso;
  private String historia;

  @ManyToMany(cascade = CascadeType.ALL)
  @ToString.Exclude

  private List<ShowEntity> showsAsociados;

}
