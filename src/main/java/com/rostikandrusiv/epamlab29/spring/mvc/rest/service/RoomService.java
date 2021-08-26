package com.rostikandrusiv.epamlab29.spring.mvc.rest.service;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.RoomDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Room;

import java.util.List;

public interface RoomService {

    RoomDto getRoom(long id);

    List<RoomDto> getAllRooms();

    RoomDto createRoom(RoomDto roomDto);

    RoomDto updateRoom(long id, RoomDto roomDto);

    void deleteRoom(long id);

    Room findById(long id);


}