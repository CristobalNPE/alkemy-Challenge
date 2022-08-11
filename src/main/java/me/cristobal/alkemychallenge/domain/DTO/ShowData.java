package me.cristobal.alkemychallenge.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowData {


  private String img;
  private String title;
  private Date creationDate;
  private RATING rating;
  private List<Character> associatedCharacters;


}
