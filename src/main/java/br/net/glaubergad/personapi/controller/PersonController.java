package br.net.glaubergad.personapi.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/people")
public class PersonController {

    @GetMapping
    public String getPeople(){
        return "API Test";
    }

    @GetMapping("/{id}")
    public String getPersonById(){
        return "API Test";
    }

    @PostMapping
    public String postPerson(){
        return "API Test";
    }

    @PutMapping("/{id}")
    public String putPerson() {
        return "API Test";
    }

    @DeleteMapping("/{id}")
    public String deletePerson() {
        return "API Test";
    }

}
