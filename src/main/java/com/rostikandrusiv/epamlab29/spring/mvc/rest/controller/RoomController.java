package com.rostikandrusiv.epamlab29.spring.mvc.rest.controller;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.api.RoomApi;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.controller.assembler.RoomAssembler;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.controller.model.RoomModel;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.RoomDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class RoomController implements RoomApi {
    private final RoomService roomService;
    private final RoomAssembler roomAssembler;


    @Override
    public RoomModel getRoom(long id) {
        RoomDto outRoomDto = roomService.getRoom(id);
        return roomAssembler.toModel(outRoomDto);
    }

    public List<RoomModel> getAllRooms() {
        List<RoomDto> outAllRoomDtos = roomService.getAllRooms();
        return outAllRoomDtos.stream()
                .map(roomAssembler::toModel)
                .collect(Collectors.toList());
    }


    public RoomModel createRoom(RoomDto roomDto) {
        RoomDto outRoomDto = roomService.createRoom(roomDto);
        return roomAssembler.toModel(outRoomDto);
    }

    public RoomModel updateRoom(long id, RoomDto roomDto) {
        RoomDto outRoomDto = roomService.updateRoom(id, roomDto);
        return roomAssembler.toModel(outRoomDto);
    }

    public ResponseEntity<Void> deleteRoom(long id) {
        roomService.deleteRoom(id);
        return ResponseEntity.noContent().build();
    }
}
