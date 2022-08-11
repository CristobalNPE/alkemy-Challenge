package me.cristobal.alkemychallenge.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Genre {


  private String name;
  private String img;
  private List<Show> showList;
}
