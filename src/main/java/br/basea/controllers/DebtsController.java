package br.basea.controllers;

import br.basea.models.entities.Debts;
import br.basea.services.DebtsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@Validated
@RequestMapping("api/debts")
public class DebtsController {

    @Autowired
    private DebtsService debtsService;

    @PostMapping
    public ResponseEntity<Debts> saveDebts(@Valid @RequestBody Debts debtList) {
        Debts debtListDTO = debtsService.save(debtList);
        return ResponseEntity.ok().body(debtListDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Debts> editDebts(@PathVariable int id, @RequestBody Debts debts) {
        Debts debtListDTO = debtsService.edit(debts, id);
        return ResponseEntity.ok().body(debtListDTO);
    }

    @GetMapping(path = "/page/{pageNumber}/{pageSize}")
    public ResponseEntity<Iterable<Debts>> getDebtsPerPage(@PathVariable int pageNumber, @PathVariable int pageSize) {
        return ResponseEntity.ok().body(debtsService.getDebtsPerPage(pageNumber, pageSize));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Debts>> getDebtsById(@PathVariable int id) {
        return ResponseEntity.ok().body(debtsService.findById(id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteDebts(@PathVariable int id) {
        debtsService.deleteById(id);
        return ResponseEntity.ok().body("Registro<Debts> excluído");
    }
}