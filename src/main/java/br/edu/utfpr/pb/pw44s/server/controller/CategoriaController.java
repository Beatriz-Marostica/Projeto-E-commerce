package br.edu.utfpr.pb.pw44s.server.controller;

import br.edu.utfpr.pb.pw44s.server.dto.CategoriaDTO;
import br.edu.utfpr.pb.pw44s.server.model.Categoria;
import br.edu.utfpr.pb.pw44s.server.service.ICategoriaService;
import br.edu.utfpr.pb.pw44s.server.service.ICrudService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("categoria")
public class CategoriaController extends CrudController<Categoria, CategoriaDTO, Long> {
    private static ICategoriaService categoryService;
    private static ModelMapper modelMapper;

    public CategoriaController(ICategoriaService categoryService, ModelMapper modelMapper) {
        super(Categoria.class, CategoriaDTO.class);
        CategoriaController.categoryService = categoryService;
        CategoriaController.modelMapper = modelMapper;
    }

    @Override
    protected ICrudService<Categoria, Long> getService() {
        return CategoriaController.categoryService;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return CategoriaController.modelMapper;
    }
}