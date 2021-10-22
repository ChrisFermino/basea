package br.basea.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "person")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Person {

    @Id
    @NotNull(message = "Campo CPF vazio")
    @NotBlank(message = "Campo CPF em branco")
    @Column(name = "cpf")
    private String cpf;

    @NotNull(message = "Campo nome vazio")
    @NotBlank(message = "Campo nome em branco")
    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

}
