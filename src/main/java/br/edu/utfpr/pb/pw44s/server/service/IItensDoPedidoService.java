package br.edu.utfpr.pb.pw44s.server.service;

import br.edu.utfpr.pb.pw44s.server.dto.ItensDoPedidoDTO;
import br.edu.utfpr.pb.pw44s.server.model.ItensDoPedido;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IItensDoPedidoService extends ICrudService<ItensDoPedido, Long>{
    ResponseEntity<List<ItensDoPedidoDTO>> returnItensDoPedidoByAuthUser();

}
