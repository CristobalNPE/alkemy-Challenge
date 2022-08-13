package me.cristobal.alkemychallenge.persistence.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Personaje implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String imagen;
  private String nombre;
  private Integer edad;
  private Double peso;
  private String historia;



  @ManyToMany(mappedBy = "personajesAsociados", cascade = CascadeType.MERGE)
  @ToString.Exclude
  private List<ShowEntity> showsAsociados = new ArrayList<>();


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Personaje personaje = (Personaje) o;
    return id.equals(personaje.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }




}
