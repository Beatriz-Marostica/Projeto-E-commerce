package br.edu.utfpr.pb.pw44s.server.controller;

import br.edu.utfpr.pb.pw44s.server.dto.EnderecoDTO;
import br.edu.utfpr.pb.pw44s.server.model.Endereco;
import br.edu.utfpr.pb.pw44s.server.service.ICrudService;
import br.edu.utfpr.pb.pw44s.server.service.IEnderecoService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("endereco")
public class EnderecoController extends  CrudController<Endereco, EnderecoDTO, Long> {

    private final IEnderecoService enderecoService;
    private final ModelMapper modelMapper;

    public EnderecoController(IEnderecoService enderecoService, ModelMapper modelMapper) {
        super(Endereco.class, EnderecoDTO.class);
        this.enderecoService = enderecoService;
        this.modelMapper = modelMapper;
    }

    @Override
    protected ICrudService<Endereco, Long> getService() {
        return enderecoService;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return modelMapper;
    }

    @GetMapping("meus_enderecos")
    public ResponseEntity<List<Endereco>> findByAuthenticatedUser() {
        List<Endereco> endereco = enderecoService.findByAuthenticatedUser();
        if (endereco == null || endereco.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(endereco);
    }

}
