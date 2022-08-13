package me.cristobal.alkemychallenge.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Show {

  private Long id;
  private String img;
  private String title;
  private Date creationDate;
  private RATING rating;
  private List<Character> associatedCharacters;

  private List<Genre> genres;


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
