package com.jpaf.jpaformation;

import com.fasterxml.classmate.util.ClassStack;
import com.jpaf.jpaformation.dao.Address;
import com.jpaf.jpaformation.dao.Person;
import com.jpaf.jpaformation.dao.SuplimentInformation;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import java.util.Arrays;

@SpringBootApplication
public class JpaFormationApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaFormationApplication.class, args);
    }
   // SuplimentInformation clePersonne = new SuplimentInformation("nom1", "prenom1");
   // private EntityManager entityManager;
   // Person personne = entityManager.find(Person.class, clePersonne);
    @Test
    public void whenParentSavedThenChildSaved() {

        Person person = new Person( );
        Address address = new Address();
        address.setPerson(person);
        person.setAddresses(Arrays.asList(address));
        EntityManager session = null;
        session.persist(person);
        session.flush();
        session.clear();
    }

    @Test
    public void whenParentSavedThenMerged() {
        int addressId;
        Person person = buildPerson("devender");
        Address address = buildAddress(person);
        person.setAddresses(Arrays.asList(address));
        EntityManager session = null;
        session.persist(person);
        session.flush();
        addressId = address.getId();
        session.clear();

        Address savedAddressEntity = session.find(Address.class, addressId);
        Person savedPersonEntity = savedAddressEntity.getPerson();
        savedPersonEntity.setNom("devender kumar");
        savedAddressEntity.setHouseNumber(24);
        session.merge(savedPersonEntity);
        session.flush();
    }

    private Address buildAddress(Person person) {

        return null;
    }

    private Person buildPerson(String devender) {
        return null;
    }


}
