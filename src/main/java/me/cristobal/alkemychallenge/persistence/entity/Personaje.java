package me.cristobal.alkemychallenge.persistence.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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

  @ManyToMany
  private List<ShowEntity> showsAsociados;

}
