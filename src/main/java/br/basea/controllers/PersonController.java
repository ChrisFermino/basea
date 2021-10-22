package br.basea.controllers;

import br.basea.models.dto.PersonDTO;
import br.basea.models.entities.Person;
import br.basea.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@Validated
@RequestMapping("api/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public ResponseEntity<Person> savePerson(@Valid @RequestBody Person person) {
        return ResponseEntity.ok().body(personService.save(person));
    }

    @PutMapping(value = "/{cpf}")
    public ResponseEntity<Person> editPerson(@PathVariable String cpf ,@RequestBody Person person) {
        Person personDTO = personService.edit(person, cpf);
        return ResponseEntity.ok().body(personDTO);
    }

    @GetMapping(path = "/page/{pageNumber}/{pageSize}")
    public ResponseEntity<Page<PersonDTO>> getPersonPerPage(@PathVariable int pageNumber, @PathVariable int pageSize) {
        return ResponseEntity.ok().body(personService.getPersonPerPage(pageNumber, pageSize));
    }

    @GetMapping(path = "/{cpf}")
    public ResponseEntity<Optional<Person>> getPersonByCpf(@PathVariable String cpf) {
        return ResponseEntity.ok().body(personService.findById(cpf));
    }

    @DeleteMapping(path = "/{cpf}")
    public ResponseEntity<String> deletePerson(@PathVariable String cpf) {
        personService.deleteById(cpf);
        return ResponseEntity.ok().body("Registro<Person> excluído!");
    }
}