package br.basea.services;

import br.basea.models.dto.PersonDTO;
import br.basea.models.entities.Person;
import br.basea.repositories.PersonRepository;
import br.basea.core.exceptions.ObjectNotFound;
import br.basea.core.exceptions.WrongParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person save(Person person) {
        return personRepository.save(person);
    }

    public Person edit(Person person, String cpf) {
        if (!person.getCpf().equals(cpf)) {
            throw new WrongParameter("O campo CPF não pode ser alterado!");
        }
        findById(cpf);
        return personRepository.save(person);
    }

    public Page<PersonDTO> getPersonPerPage(int pageNumber, int pageSize) {
        if (pageSize > 10) pageSize = 10;
        Pageable page = PageRequest.of(pageNumber, pageSize);
        return personRepository.findAlldto(page);
    }

    public void deleteById(@PathVariable String cpf) {
        findById(cpf);
        personRepository.deleteById(cpf);
    }

    public Optional<Person> findById(String cpf) {
        Optional<Person> personOptional = personRepository.findById(cpf);
        validPersonOptional(personOptional);
        return personOptional;
    }

    private void validPersonOptional(Optional<Person> personOptional) {
        if (personOptional.isEmpty()) {
            throw new ObjectNotFound("CPF Inexistente!");
        }
    }
}