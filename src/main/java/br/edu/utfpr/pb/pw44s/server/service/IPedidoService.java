package br.edu.utfpr.pb.pw44s.server.service;


import br.edu.utfpr.pb.pw44s.server.dto.PedidoDTO;
import br.edu.utfpr.pb.pw44s.server.model.Pedido;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IPedidoService extends ICrudService<Pedido, Long>{
    PedidoDTO SavePedido(PedidoDTO pedidoDTO);
    ResponseEntity<List<PedidoDTO>> getPedidosByAuthenticatedUser();



}
