package br.basea.repositories;

import br.basea.models.dto.PersonDTO;
import br.basea.models.entities.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PersonRepository extends PagingAndSortingRepository<Person, String> {

    @Query("SELECT new br.basea.models.dto.PersonDTO(p.cpf, p.name) FROM Person p")
    public Page<PersonDTO> findAlldto(Pageable page);
}
