package com.rostikandrusiv.epamlab29.spring.mvc.rest.service.impl;

import com.rostikandrusiv.epamlab29.spring.mvc.rest.dto.RoomDto;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.exception.RoomNotFoundException;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Room;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.model.Seat;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.repository.RoomRepository;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.repository.SeatRepository;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.service.RoomService;
import com.rostikandrusiv.epamlab29.spring.mvc.rest.utils.dtoMapper.RoomMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;
    private final SeatRepository seatRepository;
    private final RoomMapper roomMapper;

    @Override
    public RoomDto getRoom(long id) {
        log.info("getRoom by id {} ", id);
        Room room = roomRepository.findById(id)
                .orElseThrow(RoomNotFoundException::new);
        return roomMapper.toRoomDto(room);
    }

    @Override
    public RoomDto createRoom(RoomDto roomDto) {
        log.info("createRoom id {}", roomDto.getId());
        Room room = roomMapper.toRoom(roomDto);
        List<Seat> seats = new ArrayList<>();
        room.setSeats(seats);
        roomRepository.save(room);
        //initializing seats after room is created
        for (int i = 0; i < room.getNumberOfSeats(); i++) {
            Seat seat = new Seat();
            seat.setNumber(i + 1);
            room.getSeats().add(seat);
        }
        roomRepository.save(room);
        return roomMapper.toRoomDto(room);
    }

    @Override
    public RoomDto updateRoom(long id, RoomDto roomDto) {
        log.info("updateRoom id= {}", id);
        Room persistedRoom = roomRepository.findById(id)
                .orElseThrow(RoomNotFoundException::new);
        Room storedRoom = roomRepository.save(persistedRoom);
        log.info("Room id = {} was successfully changed", storedRoom.getId());
        return roomMapper.toRoomDto(persistedRoom);
    }

    @Override
    public void deleteRoom(long id) {
        log.info("deleteRoom id {} ", id);
        Room room = roomRepository.findById(id)
                .orElseThrow(RoomNotFoundException::new);
        roomRepository.delete(room);
    }

    @Override
    public List<RoomDto> getAllRooms() {
        log.info("getAllRooms");
        List<Room> rooms = roomRepository.findAll();
        return rooms.stream()
                .map(roomMapper::toRoomDto)
                .collect(Collectors.toList());
    }

    @Override
    public Room findById(long id) {
        log.info("getRoom by id {} ", id);
        return roomRepository.findById(id)
                .orElseThrow(RoomNotFoundException::new);
    }


}
