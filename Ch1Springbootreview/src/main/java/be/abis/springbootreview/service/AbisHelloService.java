package be.abis.springbootreview.service;

import be.abis.springbootreview.model.Guest;
import org.springframework.stereotype.Service;

@Service
public class AbisHelloService implements HelloService {
    @Override
    public Guest findGuest(int id) {
        return new Guest("John");
    }

    @Override
    public String sayHelloTo(Guest guest) {
        return "Welcome at ABIS, " + guest.getName();
    }
}
