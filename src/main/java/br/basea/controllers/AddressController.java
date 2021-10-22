package br.basea.controllers;

import br.basea.models.entities.Address;
import br.basea.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@Validated
@RequestMapping("/api/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping
    public ResponseEntity<Address> saveAddress(@Valid @RequestBody Address address) {
        return ResponseEntity.ok().body(addressService.save(address));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Address> editAddress(@PathVariable int id, @RequestBody Address address) {
        return ResponseEntity.ok().body(addressService.edit(address, id));
    }

    @GetMapping(path = "/page/{pageNumber}/{pageSize}")
    public ResponseEntity<Iterable<Address>> getAddressPerPage(@PathVariable int pageNumber, @PathVariable int pageSize) {
        return ResponseEntity.ok().body(addressService.getAddressPerPage(pageNumber, pageSize));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Address>> getAddressById(@PathVariable int id) {
        return ResponseEntity.ok().body(addressService.findById(id));
    }
}