package br.net.glaubergad.personapi.repository;


import br.net.glaubergad.personapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {

}
