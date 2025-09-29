package br.edu.utfpr.pb.pw44s.server.controller;

import br.edu.utfpr.pb.pw44s.server.dto.ProdutoDTO;
import br.edu.utfpr.pb.pw44s.server.model.Produto;
import br.edu.utfpr.pb.pw44s.server.service.ICrudService;
import br.edu.utfpr.pb.pw44s.server.service.IProdutoService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("produto")
public class ProdutoController extends CrudController<Produto, ProdutoDTO, Long> {
    private static IProdutoService produtoService;
    private static ModelMapper modelMapper;

    public ProdutoController(IProdutoService productService, ModelMapper modelMapper) {
        super(Produto.class, ProdutoDTO.class);
        ProdutoController.produtoService = productService;
        ProdutoController.modelMapper = modelMapper;
    }

    @Override
    protected ICrudService<Produto, Long> getService() {
        return produtoService;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return modelMapper;
    }

}