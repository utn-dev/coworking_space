package com.wolfpack.coworking_space.service;

import com.wolfpack.coworking_space.model.Booking;
import com.wolfpack.coworking_space.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository repo;
    Booking save(Booking booking) {
        return repo.save(booking);
    }

    Booking update(Long id, Booking booking) {
        booking.setId(id);
        return repo.save(booking);
    }

    List<Booking> findAll() {
        return repo.findAll();
    }

    Booking findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    void delete(Long id) {
        repo.deleteById(id);
    }

}
