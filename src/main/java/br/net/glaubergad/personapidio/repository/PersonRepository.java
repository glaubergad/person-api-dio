package br.net.glaubergad.personapidio.repository;


import br.net.glaubergad.personapidio.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {

}
