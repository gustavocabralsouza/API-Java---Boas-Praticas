package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.dto.AbrigoDTO;
import br.com.alura.adopet.api.excpetion.ValidacaoExcpetion;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.repository.AbrigoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbrigoService {

    @Autowired
    private AbrigoRepository repository;

    public List<Abrigo> listar() {
        return repository.findAll();
    }

    public ResponseEntity<?> cadastrar(AbrigoDTO dto)  {
        boolean nomeJaCadastrado = repository.existsByNome(dto.nome());
        boolean telefoneJaCadastrado = repository.existsByTelefone(dto.telefone());
        boolean emailJaCadastrado = repository.existsByEmail(dto.email());

        if (nomeJaCadastrado || telefoneJaCadastrado || emailJaCadastrado) {
          throw new ValidacaoExcpetion("Abrigo ja cadastrado, tente novamente");
        } else {
            Abrigo abrigo = new Abrigo(dto.nome(), dto.telefone(), dto.email());
            repository.save(abrigo);
            return ResponseEntity.ok().build();
        }

    }


}
