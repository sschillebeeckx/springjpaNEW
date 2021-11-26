package be.abis.basicmapping.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="GUESTS" /*, schema="SPRINGJPA"*/)
//@SequenceGenerator(name="mySeqGen", sequenceName="guestsequence",
//  allocationSize=1)
public class Guest {

    @Id
    //@GeneratedValue (strategy=GenerationType.SEQUENCE, generator="mySeqGen")
    @GeneratedValue (strategy=GenerationType.IDENTITY, generator="native")
    @Column(name="gno")
    private Long id;
    @Column(name="gname")
    private String name;
    @Column(name="gage")
    private int age;

    public Guest() {
    }

    public Guest(String name) {
        this.name = name;
    }

    public Guest(String name, int age) {
        this(name);
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString(){
        return name +  " is " + age + " years old.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Guest)) return false;
        Guest guest = (Guest) o;
        return Objects.equals(id, guest.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
