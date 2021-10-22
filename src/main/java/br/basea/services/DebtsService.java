package br.basea.services;

import br.basea.models.entities.Debts;
import br.basea.repositories.DebtsRepository;
import br.basea.core.exceptions.ObjectNotFound;
import br.basea.core.exceptions.WrongParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class DebtsService {

    @Autowired
    private DebtsRepository debtsRepository;

    @Autowired
    private PersonService personService;

    public Debts save(Debts debtList) {
        personService.findById(debtList.getPerson().getCpf());
        return debtsRepository.save(debtList);
    }

    public Debts edit(Debts debtList, int id) {
        if (debtList.getId() != id) {
            throw new WrongParameter("O campo ID não pode ser alterado");
        }
        findById(id);
        return debtsRepository.save(debtList);
    }

    public Iterable<Debts> getDebtsPerPage(int pageNumber, int pageSize) {
        if (pageSize > 10) pageSize = 10;
        Pageable page = PageRequest.of(pageNumber, pageSize);
        return debtsRepository.findAll(page);
    }

    public void deleteById(@PathVariable int id) {
        findById(id);
        debtsRepository.deleteById(id);
    }

    public Optional<Debts> findById(int id) {
        Optional<Debts> debtsOptional = debtsRepository.findById(id);
        validDebtsOptional(debtsOptional);
        return debtsOptional;
    }

    private void validDebtsOptional(Optional<Debts> debtsOptional) {
        if (debtsOptional.isEmpty()) {
            throw new ObjectNotFound("Id Inexistente");
        }
    }
}