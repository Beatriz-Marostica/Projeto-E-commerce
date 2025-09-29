package br.edu.utfpr.pb.pw44s.server.service.impl;

import br.edu.utfpr.pb.pw44s.server.dto.*;
import br.edu.utfpr.pb.pw44s.server.model.ItensDoPedido;
import br.edu.utfpr.pb.pw44s.server.model.Pedido;
import br.edu.utfpr.pb.pw44s.server.model.Produto;
import br.edu.utfpr.pb.pw44s.server.model.User;
import br.edu.utfpr.pb.pw44s.server.repository.ItensDoPedidoRepository;
import br.edu.utfpr.pb.pw44s.server.repository.PedidoRepository;
import br.edu.utfpr.pb.pw44s.server.service.AuthService;
import br.edu.utfpr.pb.pw44s.server.service.IPedidoService;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PedidoServiceImpl extends CrudServiceImpl<Pedido, Long> implements IPedidoService {

    private final PedidoRepository pedidoRepository;
    private final ModelMapper modelMapper;
    private final AuthService authService;
    private final ItensDoPedidoRepository itensDoPedidoRepository;
    private final ProdutoServiceImpl produtoService;

    public PedidoServiceImpl(PedidoRepository pedidoRepository, ModelMapper modelMapper,AuthService authService, ItensDoPedidoRepository itensDoPedidoRepository,  ProdutoServiceImpl produtoService) {
        this.pedidoRepository = pedidoRepository;
        this.modelMapper = modelMapper;
        this.authService = authService;
        this.itensDoPedidoRepository = itensDoPedidoRepository;
        this.produtoService = produtoService;
    }

    @Override
    protected JpaRepository<Pedido, Long> getRepository() {
        return pedidoRepository;
    }

    @Override
    public PedidoDTO SavePedido(PedidoDTO entity) {
        Pedido pedido;
        if (entity.getId() != null) {
            pedido = pedidoRepository.findById(entity.getId())
                    .orElseThrow(() -> new RuntimeException("Pedido não encontrado: " + entity.getId()));
        } else {
            pedido = new Pedido();
            pedido.setData(LocalDateTime.now());
            pedido.setUser(authService.getAuthenticatedUser());
            pedido = pedidoRepository.save(pedido);
        }

        for (ItensDoPedidoDTO dtoItem : entity.getPedidoItens()) {
            Produto produto = produtoService.findOne(dtoItem.getProduto().getId());

            ItensDoPedido item = itensDoPedidoRepository.findByPedidoIdAndProdutoId(pedido.getId(), produto.getId())
                    .orElse(new ItensDoPedido());

            item.setPedido(pedido);
            item.setProduto(produto);
            item.setPreco(produto.getPreco());
            item.setQuantidade(dtoItem.getQuantidade());

            itensDoPedidoRepository.save(item);
        }
        pedidoRepository.save(pedido);

        entity.setId(pedido.getId());
        return entity;
    }


    @Override
    public ResponseEntity<List<PedidoDTO>> getPedidosByAuthenticatedUser() {
        User currentUser = authService.getAuthenticatedUser();

        List<Pedido> userPedidos = pedidoRepository.findByUser(currentUser);

        List<PedidoDTO> pedidos= userPedidos.stream()
                .map(pedido -> {
                    PedidoDTO pedidoDTO = modelMapper.map(pedido, PedidoDTO.class);

                    List<ItensDoPedido> itensDoPedidos = itensDoPedidoRepository.findByPedido_Id(pedido.getId());
                    List<ItensDoPedidoDTO> itensDoPedidoDTO = itensDoPedidos.stream()
                            .map(item -> {

                                ItensDoPedidoDTO itemDTO = new ItensDoPedidoDTO();
                                itemDTO.setId(item.getId());
                                itemDTO.setPreco(item.getPreco());
                                itemDTO.setQuantidade(item.getQuantidade());
                                itemDTO.setProduto(toProdutoDTO(item.getProduto()));
                                return itemDTO;
                            })
                            .collect(Collectors.toList());

                    pedidoDTO.setPedidoItens(itensDoPedidoDTO);
                    return pedidoDTO;
                })
                .collect(Collectors.toList());

        return ResponseEntity.ok(pedidos);
    }

    private ProdutoDTO toProdutoDTO(Produto prod) {
        if (prod == null) return null;
        ProdutoDTO dto = new ProdutoDTO();
        return modelMapper.map(prod, ProdutoDTO.class);
    }

}
