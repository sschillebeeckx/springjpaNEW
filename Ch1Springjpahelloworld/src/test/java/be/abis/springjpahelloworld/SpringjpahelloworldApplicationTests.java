package be.abis.springjpahelloworld;

import be.abis.springjpahelloworld.model.Guest;
import be.abis.springjpahelloworld.service.HelloService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class SpringjpahelloworldApplicationTests {

    @Autowired
    private HelloService helloService;

    @Test
    void guest1IsJohn() {
        assertEquals("John",helloService.findGuest(1).getName());
    }

    @Test
    @Order(1)
    void addGuest() {
        helloService.addGuest("Sandy",43);
    }

    @Test
    @Order(2)
    void dbSizeIs4() {
        List<Guest> allGuests=helloService.findAllGuests();
        allGuests.forEach(System.out::println);
        assertEquals(4,allGuests.size());
    }

    @Test
    void guestsAge42() {
        assertEquals(2,helloService.findGuestsByAge(42).size());
    }

    @Test
    void guests3Is40() {
        assertEquals(40,helloService.findGuest("Jim").getAge());
    }


}
