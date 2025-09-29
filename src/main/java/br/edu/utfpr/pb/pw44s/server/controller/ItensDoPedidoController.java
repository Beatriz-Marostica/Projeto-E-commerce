package br.edu.utfpr.pb.pw44s.server.controller;

import br.edu.utfpr.pb.pw44s.server.dto.ItensDoPedidoDTO;
import br.edu.utfpr.pb.pw44s.server.model.ItensDoPedido;
import br.edu.utfpr.pb.pw44s.server.service.ICrudService;
import br.edu.utfpr.pb.pw44s.server.service.IItensDoPedidoService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("itens_pedido")
public class ItensDoPedidoController extends  CrudController<ItensDoPedido, ItensDoPedidoDTO, Long>{

    private final IItensDoPedidoService itensDoPedidoService;
    private final ModelMapper modelMapper;

    public ItensDoPedidoController(IItensDoPedidoService itensDoPedidoService, ModelMapper modelMapper) {
        super(ItensDoPedido.class, ItensDoPedidoDTO.class);
        this.itensDoPedidoService = itensDoPedidoService;
        this.modelMapper = modelMapper;
    }

    @Override
    protected ICrudService<ItensDoPedido, Long> getService() {
        return itensDoPedidoService;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return modelMapper;
    }

    @Override
    public ResponseEntity<List<ItensDoPedidoDTO>> findAll() {
        return itensDoPedidoService.returnItensDoPedidoByAuthUser();
    }

}
