package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Endereco;
import com.example.demo.repository.EnderecoRepository;

@Service
public class EnderecoService {
    
    @Autowired
    private EnderecoRepository repository;

    public Endereco salvarEndereco(Endereco endereco) {
        if(endereco == null){
            throw new RuntimeException("Endereço parameter is null!");
        }
        return repository.save(endereco);
    }

    public Endereco findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void excluirEndereco(Long id) {
        repository.deleteById(id);
    }

    public Endereco update(Long id, Endereco enderecoAtualizado) {
        Endereco enderecoExistente = repository.findById(id).orElse(null);

        if (enderecoExistente != null) {
            
            enderecoExistente.setCep(enderecoAtualizado.getCep());
            enderecoExistente.setLogradouro(enderecoAtualizado.getLogradouro());
            enderecoExistente.setComplemento(enderecoAtualizado.getComplemento());
            enderecoExistente.setBairro(enderecoAtualizado.getBairro());
            enderecoExistente.setLocalidade(enderecoAtualizado.getLocalidade());
            enderecoExistente.setUf(enderecoAtualizado.getUf());


            return repository.save(enderecoExistente);
        }

        return null;
    }
}
