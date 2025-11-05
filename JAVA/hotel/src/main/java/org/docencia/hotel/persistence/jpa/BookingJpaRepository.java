package org.docencia.hotel.persistence.jpa;

import org.docencia.hotel.domain.model.Booking;
import org.docencia.hotel.repository.BookingRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BookingJpaRepository extends JpaRepository<Booking, String>, BookingRepository {

    @Override
    @Query("SELECT b FROM Booking b WHERE b.room.id = :roomId " +
            "AND b.checkOut > :startDate AND b.checkIn < :endDate")
    List<Booking> findByRoomIdAndDateRange(
            @Param("roomId") String roomId,
            @Param("startDate") Date startDate,
            @Param("endDate") Date endDate);
}
