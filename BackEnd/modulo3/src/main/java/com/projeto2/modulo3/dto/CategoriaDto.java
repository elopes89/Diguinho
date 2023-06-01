package com.projeto2.modulo3.dto;

import com.projeto2.modulo3.model.Produto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class CategoriaDto {
    private Long id;
    private String nome;
    private String descricao;

    //private List<ProdutoDto> produtosDto = new ArrayList<ProdutoDto>();

}
