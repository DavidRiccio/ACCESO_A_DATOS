package org.docencia.hotel.persistence.jpa.Impl;

import org.docencia.hotel.domain.model.Room;
import org.docencia.hotel.persistence.jpa.RoomJpaRepository;
import org.docencia.hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RoomJpaImpl implements RoomRepository {
    
    @Autowired
    private RoomJpaRepository roomJpaRepository;
    
    @Override
    public boolean existsById(String id) {
        return roomJpaRepository.existsById(id);
    }
    
    @Override
    public Optional<Room> findById(String id) {
        return roomJpaRepository.findById(id);
    }
    
    @Override
    public List<Room> findAll() {
        return roomJpaRepository.findAll();
    }
    
    @Override
    public Room save(Room room) {
        return roomJpaRepository.save(room);
    }
    
    @Override
    public void deleteById(String id) {
        roomJpaRepository.deleteById(id);
    }
    
    @Override
    public List<Room> findByHotelId(String hotelId) {
        return roomJpaRepository.findByHotelId(hotelId);
    }
}
