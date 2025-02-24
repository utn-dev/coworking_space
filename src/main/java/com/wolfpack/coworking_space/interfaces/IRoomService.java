package com.wolfpack.coworking_space.interfaces;

import com.wolfpack.coworking_space.model.Room;

import java.util.List;
import java.util.Optional;

public interface IRoomService {
    Room save(Room room);

    Room update(Long id, Room room);

    List<Room> findAll();

    Optional<Room> findById(Long id);

    void delete(Long id);
}
