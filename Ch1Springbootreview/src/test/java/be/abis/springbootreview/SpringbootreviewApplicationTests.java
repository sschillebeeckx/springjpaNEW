package be.abis.springbootreview;

import be.abis.springbootreview.model.Guest;
import be.abis.springbootreview.service.HelloService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SpringbootreviewApplicationTests {

    @Autowired
    private HelloService helloService;

    private Guest guest;

    @BeforeEach
    public void init(){
        guest=new Guest("Jane");
    }

    @Test
    void guestAgeIs() {
        assertEquals(42,helloService.findGuest(1).getAge());
    }

    @Test
    void sayHelloToJane() {
        assertThat(helloService.sayHelloTo(guest), startsWith("Welcome"));
    }

}
