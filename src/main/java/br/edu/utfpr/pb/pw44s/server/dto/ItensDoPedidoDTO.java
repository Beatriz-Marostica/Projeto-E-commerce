package br.edu.utfpr.pb.pw44s.server.dto;

import br.edu.utfpr.pb.pw44s.server.model.Pedido;
import jakarta.validation.constraints.NotNull;
import jdk.jfr.DataAmount;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItensDoPedidoDTO {

    private Long id;

    private PedidoDTO pedido;

    private ProdutoDTO produto;

    @NotNull
    private BigDecimal preco;

    @NotNull
    private Integer quantidade;
}
