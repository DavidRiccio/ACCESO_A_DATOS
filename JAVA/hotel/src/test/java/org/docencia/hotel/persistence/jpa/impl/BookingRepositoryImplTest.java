package org.docencia.hotel.persistence.jpa.impl;

import org.docencia.hotel.domain.model.Booking;
import org.docencia.hotel.domain.model.Guest;
import org.docencia.hotel.domain.model.Hotel;
import org.docencia.hotel.domain.model.Room;
import org.docencia.hotel.repository.BookingRepository;
import org.docencia.hotel.repository.GuestRepository;
import org.docencia.hotel.repository.HotelRepository;
import org.docencia.hotel.repository.RoomRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookingRepositoryImplTest {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private GuestRepository guestRepository;

    private Booking testBooking;
    private Hotel testHotel;
    private Room testRoom;
    private Guest testGuest;

    @BeforeEach
    void setUp() {
        testHotel = hotelRepository.save(new Hotel("h1", "Test Hotel", "Test City"));
        testRoom = roomRepository.save(new Room("r1", testHotel, 101, 100.0f, "Single"));
        testGuest = guestRepository.save(new Guest("g1", "John Doe", "john@example.com", "123456"));

        testBooking = bookingRepository.save(new Booking("B1", testRoom, testGuest, "2025-11-10", "2025-11-13"));
    }

    @AfterEach
    void tearDown() {
        bookingRepository.deleteById("B1");
        roomRepository.deleteById("r1");
        guestRepository.deleteById("g1");
        hotelRepository.deleteById("h1");
    }

    @Test
    void testSaveBooking() {
        Booking booking = new Booking("b2", testRoom, testGuest, "2025-11-15", "2025-11-17");
        Booking saved = bookingRepository.save(booking);
        assertNotNull(saved);
        assertEquals("b2", saved.getId());
        bookingRepository.deleteById("b2");
    }

    @Test
    void testFindBookingById() {
        Optional<Booking> found = bookingRepository.findById("B1");
        assertTrue(found.isPresent());
        assertEquals("B1", found.get().getId());
    }

    @Test
    void testFindAllBookings() {
        List<Booking> bookings = bookingRepository.findAll();
        assertNotNull(bookings);
        assertTrue(bookings.size() > 0);
    }

    @Test
    void testUpdateBooking() {
        testBooking.setCheckOut("2025-11-20");
        Booking updated = bookingRepository.save(testBooking);
        assertEquals("2025-11-20", updated.getCheckOut());
    }

    @Test
    void testExistsById() {
        assertTrue(bookingRepository.existsById("B1"));
        assertFalse(bookingRepository.existsById("nonexistent"));
    }

    @Test
    void testFindByRoomIdAndDateRange() {
        List<Booking> bookings = bookingRepository.findByRoomIdAndDateRange("r1", "2025-11-09", "2025-11-14");
        assertNotNull(bookings);
        assertTrue(bookings.size() > 0);
    }



}
