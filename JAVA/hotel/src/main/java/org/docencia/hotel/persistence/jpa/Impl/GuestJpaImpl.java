package org.docencia.hotel.persistence.jpa.Impl;

import org.docencia.hotel.domain.model.Guest;
import org.docencia.hotel.persistence.jpa.GuestJpaRepository;
import org.docencia.hotel.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class GuestJpaImpl implements GuestRepository {
    
    @Autowired
    private GuestJpaRepository guestJpaRepository;
    
    @Override
    public boolean existsById(String id) {
        return guestJpaRepository.existsById(id);
    }
    
    @Override
    public Optional<Guest> findById(String id) {
        return guestJpaRepository.findById(id);
    }
    
    @Override
    public List<Guest> findAll() {
        return guestJpaRepository.findAll();
    }
    
    @Override
    public Guest save(Guest guest) {
        return guestJpaRepository.save(guest);
    }
    
    @Override
    public void deleteById(String id) {
        guestJpaRepository.deleteById(id);
    }
}
