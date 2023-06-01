package com.projeto2.modulo3.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {
    @EqualsAndHashCode.Include

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Preencha")
    @NotNull(message = " O valor não pode ser nulo!")
    @Column(unique = true)
    private String nome;

    private String descricao;
    

}

