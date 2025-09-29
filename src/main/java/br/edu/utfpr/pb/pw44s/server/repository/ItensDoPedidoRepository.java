package br.edu.utfpr.pb.pw44s.server.repository;

import br.edu.utfpr.pb.pw44s.server.model.ItensDoPedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItensDoPedidoRepository extends JpaRepository<ItensDoPedido,Long> {

    List<ItensDoPedido> findByPedido_Id(Long pedidoId);
    Optional<ItensDoPedido> findByPedidoIdAndProdutoId(Long pedidoId, Long produtoId);
}
