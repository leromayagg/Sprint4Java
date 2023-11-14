package com.example.demo.entities;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String nome;

    @NotEmpty
    private String sobrenome;

    @NotEmpty
    private String email;

    @NotEmpty
    private String cpf;

    @NotNull
    private int idade;

    
    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Bike> bikes;

    @OneToMany(mappedBy = "cliente")
    private List<Endereco> enderecos = new ArrayList<>();
}

