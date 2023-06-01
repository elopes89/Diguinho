package com.projeto2.modulo3.input;

import com.projeto2.modulo3.model.Produto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CategoriaInput {

    private Long id;
    private String nome;
    private String descricao;

    //private List<ProdutoInput> produtos = new ArrayList<ProdutoInput>();
}
