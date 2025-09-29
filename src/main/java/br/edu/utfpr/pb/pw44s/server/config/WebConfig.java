package br.edu.utfpr.pb.pw44s.server.config;

import br.edu.utfpr.pb.pw44s.server.dto.EnderecoDTO;
import br.edu.utfpr.pb.pw44s.server.model.Endereco;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.addMappings(new PropertyMap<EnderecoDTO, Endereco>() {
            @Override
            protected void configure() {
                map(source.getUser().getId(), destination.getUser().getId());
            }
        });

        return modelMapper;
    }
}


