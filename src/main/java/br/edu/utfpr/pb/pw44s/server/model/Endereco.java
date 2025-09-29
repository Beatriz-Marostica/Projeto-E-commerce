package br.edu.utfpr.pb.pw44s.server.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "tb_endereco")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @NotNull
    private User user;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return Objects.equals(id, endereco.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
