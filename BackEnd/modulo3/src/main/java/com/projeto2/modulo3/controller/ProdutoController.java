package com.projeto2.modulo3.controller;

import com.projeto2.modulo3.dto.ProdutoDto;
import com.projeto2.modulo3.input.ProdutoInput;
import com.projeto2.modulo3.model.Produto;
import com.projeto2.modulo3.service.CategoriaService;
import com.projeto2.modulo3.service.ProdutoService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@Api(tags = "Produtos")
@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @Autowired
    CategoriaService categoriaService;

    @ApiOperation("LISTAR")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Produtos listados")
            , @ApiResponse(code = 401, message = "Usuário sem permissão para acessar o recurso")
            , @ApiResponse(code = 404, message = "Recurso não encontrado")})
    @GetMapping
    public ResponseEntity<List<ProdutoDto>> listar() {
        List<Produto> produtos = produtoService.list();
        return new ResponseEntity<List<ProdutoDto>>(toCollection(produtos), HttpStatus.OK);
    }

    @ApiOperation("CADASTRAR")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Produto cadastrado")
            , @ApiResponse(code = 201, message = "Produto cadastrado com sucesso")
            , @ApiResponse(code = 401, message = "Usuário sem permissão para acessar o recurso")
            , @ApiResponse(code = 403, message = "Proibido")
            , @ApiResponse(code = 404, message = "Recurso não encontrado")})
    @PostMapping
    public ResponseEntity<ProdutoDto> cadastrar(@ApiParam(value = "Produto cadastrado") @RequestBody @Valid ProdutoInput produto) {
        Produto prod = toDomain(produto);
        produtoService.salvar(prod);
        return new ResponseEntity<ProdutoDto>(toModel(prod), HttpStatus.CREATED);
    }

    @ApiOperation("ALTERAR")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Produto alterado")
            , @ApiResponse(code = 401, message = "Usuário sem permissão para acessar o recurso")
            , @ApiResponse(code = 403, message = "Proibido")
            , @ApiResponse(code = 404, message = "Recurso não encontrado")})
    @PutMapping
    public ResponseEntity<ProdutoDto> alterar(@ApiParam(value = "Produto editado: ", example = "1") @RequestBody ProdutoInput produto) {
        Produto prod = toDomain(produto);
        produtoService.salvar(prod);
        return new ResponseEntity<ProdutoDto>(toModel(prod), HttpStatus.OK);
    }

    @ApiOperation("DELETAR")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Produto deletado")
            , @ApiResponse(code = 401, message = "Usuário sem permissão para acessar o recurso")
            , @ApiResponse(code = 403, message = "Proibido")
            , @ApiResponse(code = 404, message = "Recurso não encontrado")})
    @DeleteMapping("/{idProduto}")
    @ResponseBody
    public ResponseEntity<String> delete(@ApiParam(value = "Id deletado com sucesso", example = "1") @PathVariable Long idProduto) {
        produtoService.delete(idProduto);
        return new ResponseEntity<String>("Id do Produto Deletado: " + idProduto, HttpStatus.OK);
    }

    @ApiOperation("LISTAR TOTAL DE COMPRADOS")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Total dos produtos com Status True")
            , @ApiResponse(code = 401, message = "Usuário sem permissão para acessar o recurso")
            , @ApiResponse(code = 403, message = "Proibido")
            , @ApiResponse(code = 404, message = "Recurso não encontrado")})
    @GetMapping(value = "/total")
    public ResponseEntity<String> getTotal() {
        return new ResponseEntity<String>("Total comprado: " + produtoService.getTotal(), HttpStatus.OK);
    }
    private Produto toDomain(ProdutoInput input) {
        Produto produto = new Produto();
        produto.setId(input.getId());
        produto.setValorProduto(input.getValorProduto());
        produto.setNome(input.getNome());

        return produto;
    }

    private ProdutoDto toModel(Produto produto) {
        ProdutoDto dto = new ProdutoDto();
        dto.setId(produto.getId());
        dto.setNome(produto.getNome());
        dto.setValor(produto.getValorProduto());
        return dto;
    }

    private List<ProdutoDto> toCollection(List<Produto> produtos) {
        return produtos.stream().map(Produto -> toModel(Produto)).collect(Collectors.toList());
    }

}
