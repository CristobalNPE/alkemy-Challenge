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
public class Genero implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column(unique = true)
  private String nombre;
  private String imagen;

  @ManyToMany(mappedBy = "generos", cascade = CascadeType.MERGE)
  @ToString.Exclude
  private List<ShowEntity> listaShows = new ArrayList<>();

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Genero genero = (Genero) o;
    return id.equals(genero.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
