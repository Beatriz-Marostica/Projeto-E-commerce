package br.edu.utfpr.pb.pw44s.server.service.impl;

import br.edu.utfpr.pb.pw44s.server.model.Endereco;
import br.edu.utfpr.pb.pw44s.server.model.User;
import br.edu.utfpr.pb.pw44s.server.repository.EnderecoRepository;
import br.edu.utfpr.pb.pw44s.server.service.AuthService;
import br.edu.utfpr.pb.pw44s.server.service.IEnderecoService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoServiceImpl extends CrudServiceImpl<Endereco, Long> implements IEnderecoService {

    private EnderecoRepository enderecoRepository;
    private final AuthService authService;


    public EnderecoServiceImpl(EnderecoRepository enderecoRepository, AuthService authService) {
        this.enderecoRepository = enderecoRepository;
        this.authService = authService;
    }

    @Override
    protected JpaRepository<Endereco, Long> getRepository() {
        return enderecoRepository;
    }

    @Override
    public Endereco save(Endereco entity) {
        entity.setUser(authService.getAuthenticatedUser());
        return super.save(entity);
    }

    @Override
    public List<Endereco> findByAuthenticatedUser() {
        User user = authService.getAuthenticatedUser();
        return enderecoRepository.findByUser(user);
    }
}
