package org.docencia.hotel.persistence.jpa.Impl;
import org.docencia.hotel.domain.model.Hotel;
import org.docencia.hotel.persistence.jpa.HotelJpaRepository;
import org.docencia.hotel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class HotelJpaImpl implements HotelRepository {
    
    @Autowired
    private HotelJpaRepository hotelJpaRepository;
    
    @Override
    public boolean existsById(String id) {
        return hotelJpaRepository.existsById(id);
    }
    
    @Override
    public Optional<Hotel> findById(String id) {
        return hotelJpaRepository.findById(id);
    }
    
    @Override
    public List<Hotel> findAll() {
        return hotelJpaRepository.findAll();
    }
    
    @Override
    public Hotel save(Hotel hotel) {
        return hotelJpaRepository.save(hotel);
    }
    
    @Override
    public void deleteById(String id) {
        hotelJpaRepository.deleteById(id);
    }
}
