package br.edu.utfpr.pb.pw44s.server.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnderecoDTO {

    private Long id;

    @NotNull
    private UserDTO user;

    @NotNull
    @Size(max = 150)
    private String logradouro;

    @Size(max = 100)
    private String complemento;

    @NotNull
    @Size(max = 9)
    private String cep;

    @NotNull
    @Size(max = 80)
    private String bairro;

    @NotNull
    @Size(max = 80)
    private String cidade;

    @NotNull
    @Size(max = 2)
    private String estado;

    @NotNull
    @Size(max = 10)
    private String numero;
}
