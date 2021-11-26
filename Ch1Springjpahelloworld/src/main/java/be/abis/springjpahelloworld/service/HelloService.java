package be.abis.springjpahelloworld.service;


import be.abis.springjpahelloworld.model.Guest;

import java.util.List;

public interface HelloService {

    Guest findGuest(long id);

    Guest findGuest(String name);

    List<Guest> findGuestsByAge(int age);

    List<Guest> findAllGuests();

    void addGuest(String name, int age);

}