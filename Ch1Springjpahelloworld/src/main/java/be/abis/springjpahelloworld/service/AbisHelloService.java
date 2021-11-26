package be.abis.springjpahelloworld.service;


import be.abis.springjpahelloworld.repository.GuestJpaRepository;
import be.abis.springjpahelloworld.model.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AbisHelloService implements HelloService {

    @Autowired
    GuestJpaRepository guestRepository;

    @Override
    public Guest findGuest(long id) {
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
        List<Guest> guests=new ArrayList<Guest>();
        guestRepository.findAll().forEach(guests::add);
        return guests;
    }

    @Override
    public void addGuest(String name, int age) {
        guestRepository.saveAndFlush(new Guest(name,age));
    }

}
