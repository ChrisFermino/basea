package br.basea.services;

import br.basea.models.entities.Address;
import br.basea.repositories.AddressRepository;
import br.basea.core.exceptions.ObjectNotFound;
import br.basea.core.exceptions.WrongParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Address save(Address address) {
        return addressRepository.save(address);
    }

    public Address edit(Address address, int id) {
        if (address.getId() != id) {
            throw new WrongParameter("O Id não pode ser alterado");
        }
        findById(id);
        return addressRepository.save(address);
    }

    public Iterable<Address> getAddressPerPage(int pageNumber, int pageSize) {
        if (pageSize > 10) pageSize = 10;
        Pageable page = PageRequest.of(pageNumber, pageSize);
        return addressRepository.findAll(page);
    }

    public Optional<Address> findById(int id) {
        Optional<Address> addressOptional = addressRepository.findById(id);
        validAddressOptional(addressOptional);
        return addressOptional;
    }

    private void validAddressOptional(Optional<Address> addressOptional) {
        if (addressOptional.isEmpty()) {
            throw new ObjectNotFound("Id Inexistente");
        }
    }
}