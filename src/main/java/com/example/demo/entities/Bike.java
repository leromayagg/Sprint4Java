package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class Bike {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String marca;
    
    @NotEmpty
    private String modelo;

    private int ano;

    @NotEmpty
    private String serie;
    
    private Double valor;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    
}
