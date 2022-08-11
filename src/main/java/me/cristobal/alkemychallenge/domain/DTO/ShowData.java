package me.cristobal.alkemychallenge.domain.DTO;

import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
public class ShowData {


  private String img;
  private String title;
  private Date creationDate;
  private RATING rating;
  private List<Character> associatedCharacters;


}
