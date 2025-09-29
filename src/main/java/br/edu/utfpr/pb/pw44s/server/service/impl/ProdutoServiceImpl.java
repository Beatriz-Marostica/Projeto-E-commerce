package br.edu.utfpr.pb.pw44s.server.service.impl;

import br.edu.utfpr.pb.pw44s.server.model.Produto;
import br.edu.utfpr.pb.pw44s.server.repository.ProdutoRepository;
import br.edu.utfpr.pb.pw44s.server.service.IProdutoService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl extends CrudServiceImpl<Produto, Long> implements IProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    protected JpaRepository<Produto, Long> getRepository() {
        return produtoRepository;
    }

}