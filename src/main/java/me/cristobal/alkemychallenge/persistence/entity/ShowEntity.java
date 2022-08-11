package me.cristobal.alkemychallenge.persistence.entity;

import lombok.*;
import me.cristobal.alkemychallenge.domain.DTO.Show;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.sql.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class ShowEntity {

  private String imagen;

  @Id
  private String titulo;
  private Date fechaCreacion;
  private Show.RATING calificacion;

  @ManyToMany
  private List<Personaje> personajesAsociados;

  @ManyToMany
  private List<Genero> generos;


  public enum RATING {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5);

    private int numValue;

    RATING(int numValue) {
      this.numValue = numValue;
    }

    public int getNumValue() {
      return numValue;
    }
  }

}