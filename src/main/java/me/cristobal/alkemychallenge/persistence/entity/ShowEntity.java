package me.cristobal.alkemychallenge.persistence.entity;

import lombok.*;
import me.cristobal.alkemychallenge.domain.DTO.Show;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class ShowEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String imagen;
  private String titulo;
  private Date fechaCreacion;
  private Show.RATING calificacion;

  @ManyToMany(cascade = CascadeType.ALL)
  @ToString.Exclude
  private List<Personaje> personajesAsociados;

  @ManyToMany(cascade = CascadeType.ALL)
  @ToString.Exclude
  private List<Genero> generos;


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

}