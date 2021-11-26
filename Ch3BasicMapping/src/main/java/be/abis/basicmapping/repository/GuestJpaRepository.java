package be.abis.basicmapping.repository;

import be.abis.basicmapping.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuestJpaRepository extends JpaRepository<Guest, Long> {

    Guest findById(long id);

    Guest findByName(String name);

    List<Guest> findByAge(int age);

}
