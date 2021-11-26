package be.abis.basicmapping;

import be.abis.basicmapping.model.Guest;
import be.abis.basicmapping.service.HelloService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BasicmappingApplicationTests {

    @Autowired
    private HelloService helloService;

    @Test
    void guest1IsJohn() {
        assertEquals("John",helloService.findGuest(1).getName());
    }

    @Test
    void dbSizeIs3() {
        List<Guest> allGuests=helloService.findAllGuests();
        //allGuests.forEach(System.out::println);
        assertEquals(3,allGuests.size());
    }

    @Test
    void guestsAge42() {
        assertEquals(2,helloService.findGuestsByAge(42).size());
    }

    @Test
    void guests3Is40() {
        assertEquals(40,helloService.findGuest("Jim").getAge());
    }

    @Test
    @Transactional
    void addGuest() {
        helloService.addGuest("Sandy",43);
        assertNotNull(helloService.findGuest("Sandy"));
    }

}
