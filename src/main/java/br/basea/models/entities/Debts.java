package br.basea.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "debts")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Debts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "Campo ID vazio")
    @Column(name = "ID")
    private int id;

    @NotNull(message = "Campo debtName está vazio")
    @NotBlank(message = "Campo debtName em branco")
    @Column(name = "debtName")
    private String debtName;

    @NotNull(message = "Campo value vazio")
    @Column(name = "value")
    private int value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person")
    private Person person;

}
