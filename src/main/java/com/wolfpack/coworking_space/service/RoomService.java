package com.wolfpack.coworking_space.service;

import com.wolfpack.coworking_space.interfaces.IRoomService;
import com.wolfpack.coworking_space.model.Room;
import com.wolfpack.coworking_space.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomService implements IRoomService {

    private final RoomRepository repo;


    @Override
    public Room save(Room room) {
        return repo.save(room);
    }

    @Override
    public Room update(Long id, Room room) {
        if (repo.existsById(id)) {
            room.setId(id);
            return repo.save(room);
        } else {
            throw new RuntimeException("Room not found with id: " + id);
        }
    }

    @Override
    public List<Room> findAll() {
        return repo.findAll();

    }
    @Override
    public Optional<Room> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public void delete(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("Room not found with id: " + id);
        }
    }
}