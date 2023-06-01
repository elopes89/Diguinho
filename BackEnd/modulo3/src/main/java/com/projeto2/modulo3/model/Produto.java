package com.projeto2.modulo3.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity
@Table(name = "produtos")
public class Produto implements Serializable {
    @EqualsAndHashCode.Include

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Preencha")
    @NotNull(message = " O valor não pode ser nulo!")
    @Column(unique = true, nullable = false)
    private String nome;

    @NotNull(message = " O valor não pode ser nulo!")
    private Double valorProduto;


}


