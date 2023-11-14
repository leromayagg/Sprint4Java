package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String cep;

    @NotEmpty
    private String logradouro;

    private String complemento;

    @NotEmpty
    private String bairro;

    @NotEmpty
    private String localidade;

    @NotEmpty
    private String uf;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

}
