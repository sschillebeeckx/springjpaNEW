package be.abis.demo.service;


import be.abis.demo.model.Guest;
import be.abis.demo.repository.GuestJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbisHelloService implements HelloService {

    @Autowired
    GuestJpaRepository guestRepository;

    @Override
    public Guest findGuest(int id) {
        return guestRepository.findById(id);
    }

    @Override
    public Guest findGuest(String name) {
        return guestRepository.findByName(name);
    }

    @Override
    public List<Guest> findGuestsByAge(int age) {
        return guestRepository.findByAge(age);
    }

    @Override
    public List<Guest> findAllGuests() {
        return (List<Guest>)guestRepository.findAll();
    }

    @Override
    public void addGuest(String name, int age) {
        Guest guest = new Guest(name,age);
        guestRepository.saveAndFlush(guest);
    }

}
