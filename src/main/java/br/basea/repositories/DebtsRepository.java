package br.basea.repositories;

import br.basea.models.entities.Debts;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DebtsRepository extends PagingAndSortingRepository<Debts, Integer> {
}
