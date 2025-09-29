package br.edu.utfpr.pb.pw44s.server.service.impl;

import br.edu.utfpr.pb.pw44s.server.dto.ItensDoPedidoDTO;
import br.edu.utfpr.pb.pw44s.server.dto.PedidoDTO;
import br.edu.utfpr.pb.pw44s.server.dto.ProdutoDTO;
import br.edu.utfpr.pb.pw44s.server.model.ItensDoPedido;
import br.edu.utfpr.pb.pw44s.server.model.Pedido;
import br.edu.utfpr.pb.pw44s.server.model.Produto;
import br.edu.utfpr.pb.pw44s.server.model.User;
import br.edu.utfpr.pb.pw44s.server.repository.ItensDoPedidoRepository;
import br.edu.utfpr.pb.pw44s.server.repository.PedidoRepository;
import br.edu.utfpr.pb.pw44s.server.service.AuthService;
import br.edu.utfpr.pb.pw44s.server.service.IItensDoPedidoService;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItensDoPedidoServiceImpl extends CrudServiceImpl<ItensDoPedido, Long> implements IItensDoPedidoService {
    private final ItensDoPedidoRepository itensDoPedidoRepository;
    private final AuthService authService;
    private final ModelMapper modelMapper;
    private final PedidoRepository pedidoRepository;

    public ItensDoPedidoServiceImpl(ItensDoPedidoRepository itensDoPedidoRepository, AuthService authService, ModelMapper modelMapper, PedidoRepository pedidoRepository) {
        this.itensDoPedidoRepository = itensDoPedidoRepository;
        this.authService = authService;
        this.modelMapper = modelMapper;
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    protected JpaRepository<ItensDoPedido, Long> getRepository() {return itensDoPedidoRepository;}

    @Override
    public ResponseEntity<List<ItensDoPedidoDTO>> returnItensDoPedidoByAuthUser(){
        User currentUser = authService.getAuthenticatedUser();

        List<Pedido> userPedidos = pedidoRepository.findByUser(currentUser);

        if (userPedidos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<ItensDoPedido> itensDoPedidos = userPedidos.stream()
                .flatMap(pedido -> itensDoPedidoRepository.findByPedido_Id(pedido.getId()).stream())
                .collect(Collectors.toList());

        List<ItensDoPedidoDTO> dtos = itensDoPedidos.stream()
                .map(item -> {
                    ItensDoPedidoDTO dto = new ItensDoPedidoDTO();
                    dto.setId(item.getId());
                    dto.setQuantidade(item.getQuantidade());
                    dto.setPreco(item.getPreco());
                    dto.setPedido(toPedidoDTO(item.getPedido()));
                    dto.setProduto(toProdutoDTO(item.getProduto()));

                    return dto;
                })
                .collect(Collectors.toList());

        return ResponseEntity.ok(dtos);
    }

    private PedidoDTO toPedidoDTO(Pedido p) {
        if (p == null) return null;
        PedidoDTO dto = new PedidoDTO();
        return modelMapper.map(p, PedidoDTO.class);

    }

    private ProdutoDTO toProdutoDTO(Produto prod) {
        if (prod == null) return null;
        ProdutoDTO dto = new ProdutoDTO();
        return modelMapper.map(prod, ProdutoDTO.class);
    }

}
