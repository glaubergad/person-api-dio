package br.net.glaubergad.personapidio.controller.v1;

import br.net.glaubergad.personapidio.dto.MessageResponseDto;
import br.net.glaubergad.personapidio.dto.PersonDto;
import br.net.glaubergad.personapidio.exception.PersonNotFoundException;
import br.net.glaubergad.personapidio.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin
@RestController
@Api(value = "Person")
@RequestMapping("v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired) )
public class PersonController {

    private final PersonService personService;

    @ApiOperation(value ="List all registered people")
    @GetMapping
    public List<PersonDto> getPersonList() {
        return personService.getPersonList();
    }

    @ApiOperation(value ="Get person by given Id")
    @GetMapping("/{id}")
    public PersonDto getPersonById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.getPersonById(id);
    }
    @ApiOperation(value ="Register new person")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDto postPerson(@RequestBody @Valid PersonDto personDto) {
        return personService.createPerson(personDto);
    }

    @ApiOperation(value ="Alter person data")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDto putPerson(@PathVariable Long id, @RequestBody @Valid PersonDto personDto) throws PersonNotFoundException{

        return personService.putPerson(id,personDto);
    }

    @ApiOperation(value ="Delete person data")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePerson(@PathVariable Long id) throws PersonNotFoundException {
        personService.deletePerson(id);
    }

}
