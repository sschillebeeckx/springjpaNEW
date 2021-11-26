package be.abis.springbootreview.service;

import be.abis.springbootreview.model.Guest;

public interface HelloService {
    Guest findGuest(int id);

    String sayHelloTo(Guest guest);
}