package org.docencia.hotel.persistence.jpa;

import java.util.Date; 
import java.util.List;

import org.docencia.hotel.domain.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


public interface BookingJpaRepository extends JpaRepository<Booking, String> {
    @Query("SELECT b FROM Booking b WHERE b.room.id = :roomId " +
           "AND b.checkOut > :startDate AND b.checkIn < :endDate")
    List<Booking> findByRoomIdAndDateRange(String roomId, String startDate, String endDate);
}


