package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entities.Endereco;
import com.example.demo.service.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping("/salvar")
    public ResponseEntity<Endereco> salvarEndereco(@RequestBody Endereco endereco) {
        Endereco enderecoSalvo = enderecoService.salvarEndereco(endereco);

        if (enderecoSalvo != null) {
            return new ResponseEntity<>(enderecoSalvo, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    //é uma linha que cria um objeto do tipo RestTemplate, que é uma classe que facilita o consumo de serviços web RESTful. Esse objeto será usado para fazer uma requisição HTTP ao API ViaCEP
    @GetMapping("/{cep}")
    public Endereco validarCep (@PathVariable ("cep") String cep){
    RestTemplate obj = new RestTemplate();
    ResponseEntity<Endereco> resp = obj.getForEntity(
        String.format("https://viacep.com.br/ws/%s/json", cep),
        Endereco.class);
    System.out.println(resp.getBody());
    return resp.getBody();
    }

    @PutMapping("{id}")
    public ResponseEntity<Endereco> atualizarEndereco(@PathVariable Long id, @RequestBody Endereco endereco) {
        Endereco enderecoAtualizadoResult = enderecoService.update(id, endereco);

        if (enderecoAtualizadoResult != null) {
            return ResponseEntity.ok().body(enderecoAtualizadoResult);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirEndereco(@PathVariable Long id) {
        Endereco endereco = enderecoService.findById(id);

        if (endereco != null) {
            enderecoService.excluirEndereco(id);
            return new ResponseEntity<>("Endereço excluído com sucesso", HttpStatus.OK);
        }

        return new ResponseEntity<>("Endereço não encontrado", HttpStatus.NOT_FOUND);
    }
}