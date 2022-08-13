package me.cristobal.alkemychallenge.persistence.mapper;

import me.cristobal.alkemychallenge.domain.DTO.Genre;
import me.cristobal.alkemychallenge.persistence.entity.Genero;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ShowMapper.class})
public interface GenreMapper {

  @Mappings({
          @Mapping(source = "id", target = "id"),
          @Mapping(source = "nombre", target = "name"),
          @Mapping(source = "imagen", target = "img"),
          @Mapping(source = "listaShows", target = "showList")
  })
  Genre toGenre(Genero genero);

  List<Genre> toGenres(List<Genero> generos);

  @InheritInverseConfiguration
  Genero toGenero(Genre genre);
}
