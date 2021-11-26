package be.abis.demo.service;

import be.abis.demo.model.Guest;

import java.util.List;

public interface HelloService {

    Guest findGuest(int id);

    Guest findGuest(String name);

    List<Guest> findGuestsByAge(int age);

    List<Guest> findAllGuests();

    void addGuest(String name, int age);

}