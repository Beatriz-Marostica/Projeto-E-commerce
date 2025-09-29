package br.edu.utfpr.pb.pw44s.server.controller;

import br.edu.utfpr.pb.pw44s.server.dto.PedidoDTO;
import br.edu.utfpr.pb.pw44s.server.model.Pedido;
import br.edu.utfpr.pb.pw44s.server.service.ICrudService;
import br.edu.utfpr.pb.pw44s.server.service.impl.PedidoServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("pedido")
public class PedidoController extends  CrudController<Pedido, PedidoDTO, Long> {

    private final PedidoServiceImpl pedidoService;
    private final ModelMapper modelMapper;

    public PedidoController(PedidoServiceImpl pedidoService, ModelMapper modelMapper) {
        super(Pedido.class, PedidoDTO.class);
        this.pedidoService = pedidoService;
        this.modelMapper = modelMapper;
    }

    @Override
    protected ICrudService<Pedido, Long> getService() {
        return pedidoService;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return modelMapper;
    }

    @Override
    public ResponseEntity<List<PedidoDTO>> findAll() {
        return pedidoService.getPedidosByAuthenticatedUser();
    }

    @Override
    public ResponseEntity<PedidoDTO> create(PedidoDTO entity) {
        PedidoDTO savePedidoDTO = pedidoService.SavePedido(entity);
        PedidoDTO pedidoDTO = modelMapper.map(savePedidoDTO, PedidoDTO.class);

        return ResponseEntity.ok(pedidoDTO);
    }

}
