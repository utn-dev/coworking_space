package com.wolfpack.coworking_space.service;

import com.wolfpack.coworking_space.interfaces.IBookingService;
import com.wolfpack.coworking_space.model.Booking;
import com.wolfpack.coworking_space.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingService implements IBookingService {

    private final BookingRepository repo;

    @Override
    public Booking save(Booking booking) {
        return repo.save(booking);
    }

    @Override
    public Booking update(Long id, Booking booking) {
        if (repo.existsById(id)) {
            booking.setId(id);
            return repo.save(booking);
        } else {
            throw new RuntimeException("Booking not found with id: " + id);
        }
    }

    @Override
    public List<Booking> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Booking> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public void delete(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("Booking not found with id: " + id);
        }
    }

}
