package com.rostikandrusiv.epamlab29.spring.mvc.rest.utils.dtoMapper.Impl;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.RoomDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Room;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.utils.dtoMapper.RoomMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class RoomMapperImpl implements RoomMapper {

    private ModelMapper mapper;

    @Autowired
    public RoomMapperImpl(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Room toRoom(RoomDto dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, Room.class);
    }

    @Override
    public RoomDto toRoomDto(Room entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, RoomDto.class);
    }
}
