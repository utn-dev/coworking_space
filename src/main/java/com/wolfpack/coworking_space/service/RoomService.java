package com.wolfpack.coworking_space.service;

import com.wolfpack.coworking_space.model.Room;
import com.wolfpack.coworking_space.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository repo;

    Room save(Room room) {
        return repo.save(room);
    }

    Room update(Long id, Room room) {
        room.setId(id);
        return repo.save(room);

    }
    List<Room> findAll() {
        return repo.findAll();

    }
    Room findById(Long id) {
        return repo.findById(id).orElse(null);

    }
    void delete(Long id) {
        repo.deleteById(id);
    }
}
