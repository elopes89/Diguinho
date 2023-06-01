package com.projeto2.modulo3.service;

import com.projeto2.modulo3.dto.CategoriaDto;
import com.projeto2.modulo3.model.Categoria;
import com.projeto2.modulo3.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Transactional
    public Categoria salvar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Transactional
    public void delete(Long idCategoria) {
        categoriaRepository.deleteById(idCategoria);
    }
    @Transactional
    public Categoria getCategoriaById(Long idCategoria){
        return categoriaRepository.findById(idCategoria).get();
    }

    @Transactional
    public List<Categoria> listar(){
        List<Categoria> categoria = categoriaRepository.findAll();
        return categoria;
    }
}
