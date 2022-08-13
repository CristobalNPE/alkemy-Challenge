package me.cristobal.alkemychallenge.persistence.mapper;

import me.cristobal.alkemychallenge.domain.DTO.Character;
import me.cristobal.alkemychallenge.persistence.entity.Personaje;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ShowMapper.class})
public interface CharacterMapper {

  @Mappings({
          @Mapping(source = "id", target = "id"),
          @Mapping(source = "imagen", target = "img"),
          @Mapping(source = "nombre", target = "name"),
          @Mapping(source = "edad", target = "age"),
          @Mapping(source = "peso", target = "weight"),
          @Mapping(source = "historia", target = "history"),
          @Mapping(source = "showsAsociados", target = "associatedShows")
  })
  Character toCharacter(Personaje personaje);

  List<Character> toCharacters(List<Personaje> personajes);

  @InheritInverseConfiguration
  Personaje toPersonaje(Character character);

}
