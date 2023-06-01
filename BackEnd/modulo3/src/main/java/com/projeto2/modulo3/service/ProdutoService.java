package com.projeto2.modulo3.service;

import com.projeto2.modulo3.model.Produto;
import com.projeto2.modulo3.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import java.awt.Desktop;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    @Transactional
    public List<Produto> list() {
        List<Produto> produtos = produtoRepository.findAll();
        return produtos;
    }

    @Transactional
    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Transactional
    public void delete(Long idProduto) {
        produtoRepository.deleteById(idProduto);
    }

    @Transactional
    public Produto getItemProdutoById(Long idProduto) {
        return produtoRepository.findById(idProduto).get();
    }

    Double totalLista = 0.0;

    @Transactional
    public Double getTotal() {
        List<Produto> lista = produtoRepository.findAll();
        for (Produto produto : lista) {
            totalLista += produto.getValorProduto();
        }
        return totalLista;
    }

    Double totalPedidosDiario = 0.0;

    @Transactional
    public Double getTotalDiario() {
        totalPedidosDiario += totalLista;
        return totalPedidosDiario;
    }

    public void imprimir(String caminhoArquivo) {
            Desktop desktop = Desktop.getDesktop();

            File arquivoAImprimir = new File(caminhoArquivo);

            try{
                File arquivoAImprimir = new File(caminhoArquivo);
                desktop.print(arquivoAImprimir);
                            catch{
                                (IOException ex){
                                   ex.printStackTrace();
                                }
                    
                            }

          }

        //   "C:\Users\Sofia\Desktop\testeDiguingo.pdf"
          imprimir

          

}
