package me.cristobal.alkemychallenge.persistence.entity;

import lombok.*;
import me.cristobal.alkemychallenge.domain.DTO.Show;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class ShowEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String imagen;
  private String titulo;
  private Date fechaCreacion;
  private Show.RATING calificacion;

  public enum RATING {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5);

    private final int numValue;

    RATING(int numValue) {
      this.numValue = numValue;
    }

    public int getNumValue() {
      return numValue;
    }
  }


  @ManyToMany(cascade = CascadeType.MERGE)
  @ToString.Exclude
  @JoinTable(
          name = "shows_personajes",
          joinColumns = @JoinColumn(name = "id_show", nullable = false),
          inverseJoinColumns = @JoinColumn(name = "id_personaje", nullable = true))
  private List<Personaje> personajesAsociados = new ArrayList<>();

  @ManyToMany(cascade = CascadeType.MERGE)
  @ToString.Exclude
  @JoinTable(
          name = "shows_generos",
          joinColumns = @JoinColumn(name = "id_show", nullable = false),
          inverseJoinColumns = @JoinColumn(name = "id_genero", nullable = false))
  private List<Genero> generos = new ArrayList<>();


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ShowEntity that = (ShowEntity) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}