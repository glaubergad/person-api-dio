package br.net.glaubergad.personapidio.service;

import br.net.glaubergad.personapidio.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;


}
