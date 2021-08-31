package com.rostikandrusiv.epamlab29.spring.mvc.rest.utils.dtoMapper;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.RoomDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.RoomDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Room;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Room;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

public interface RoomMapper {

    Room toRoom(RoomDto dto);

    RoomDto toRoomDto(Room entity);

}
