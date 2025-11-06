package org.docencia.hotel.persistence.jpa.Impl;

import org.docencia.hotel.domain.model.Booking;
import org.docencia.hotel.persistence.jpa.BookingJpaRepository;
import org.docencia.hotel.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class BookingJpaImpl implements BookingRepository {

    @Autowired
    private BookingJpaRepository bookingJpaRepository;

    @Override
    public boolean existsById(String id) {
        return bookingJpaRepository.existsById(id);
    }

    @Override
    public Optional<Booking> findById(String id) {
        return bookingJpaRepository.findById(id);
    }

    @Override
    public List<Booking> findAll() {
        return bookingJpaRepository.findAll();
    }

    @Override
    public Booking save(Booking booking) {
        return bookingJpaRepository.save(booking);
    }

    @Override
    public void deleteById(String id) {
        bookingJpaRepository.deleteById(id);
    }

    @Override
    public List<Booking> findByRoomIdAndDateRange(String roomId, String startDate, String endDate) {
        return bookingJpaRepository.findByRoomIdAndDateRange(roomId, startDate, endDate);
    }

}
