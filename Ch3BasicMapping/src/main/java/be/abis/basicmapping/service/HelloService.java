package be.abis.basicmapping.service;

import be.abis.basicmapping.model.Guest;
import java.util.List;

public interface HelloService {

    Guest findGuest(int id);

    Guest findGuest(String name);

    List<Guest> findGuestsByAge(int age);

    List<Guest> findAllGuests();

    void addGuest(String name, int age);

}