package me.cristobal.alkemychallenge.persistence.mapper;

import me.cristobal.alkemychallenge.domain.DTO.Show;
import me.cristobal.alkemychallenge.persistence.entity.ShowEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")//, uses = {GenreMapper.class, CharacterMapper.class}
public interface ShowMapper {

  @Mappings({
          @Mapping(source = "id", target = "id"),
          @Mapping(source = "imagen", target = "img"),
          @Mapping(source = "titulo", target = "title"),
          @Mapping(source = "fechaCreacion", target = "creationDate"),
          @Mapping(source = "calificacion", target = "rating"),
          @Mapping(source = "personajesAsociados", target = "associatedCharacters"),
          @Mapping(source = "generos", target = "genres")
  })
  Show toShow(ShowEntity showEntity);

  List<Show> toShows(List<ShowEntity> showEntities);

  @InheritInverseConfiguration
  ShowEntity toShowEntity(Show show);
}
