package be.abis.springjpahelloworld.repository;

import be.abis.springjpahelloworld.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface GuestJpaRepository extends JpaRepository<Guest, Long> {

    Guest findById(long id);

     Guest findByName(String name);

     List<Guest> findByAge(int age);

}
