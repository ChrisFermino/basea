package br.basea.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "address")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "Campo ID vazio")
    @Column(name = "ID")
    private int id;

    @NotNull(message = "Campo CEP vazio")
    @NotBlank(message = "Campo CEP em branco")
    @Column(name = "CEP")
    private String cep;

    @NotNull(message = "Campo nome da rua vazio")
    @NotBlank(message = "Campo nome da rua em branco")
    @Column(name = "streetName")
    private String streetName;

    @NotNull(message = "Campo number vazio")
    @Column(name = "number")
    private int number;
}