package br.basea.repositories;

import br.basea.models.entities.Address;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AddressRepository extends PagingAndSortingRepository<Address, Integer> {
}
