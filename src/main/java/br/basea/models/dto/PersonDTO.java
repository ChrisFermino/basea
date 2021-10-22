package br.basea.models.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonDTO {

    private String cpf;
    private String name;

    public PersonDTO(String cpf, String name) {
        this.cpf = cpf;
        this.name = name;
    }
}
