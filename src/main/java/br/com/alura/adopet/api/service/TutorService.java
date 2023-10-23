package br.com.alura.adopet.api.service;


import br.com.alura.adopet.api.dto.TutorDTO;
import br.com.alura.adopet.api.excpetion.ValidacaoExcpetion;
import br.com.alura.adopet.api.model.Tutor;
import br.com.alura.adopet.api.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TutorService {

    @Autowired
    private TutorRepository repository;

    public void cadastrar(TutorDTO dto) {
        boolean telefoneJaCadastrado = repository.existsByTelefone(dto.telefone());
        boolean emailJaCadastrado = repository.existsByEmail(dto.email());

        if (telefoneJaCadastrado || emailJaCadastrado) {
            throw new ValidacaoExcpetion("Dados já cadastrados para outro tutor!");
        } else {
            Tutor tutor = new Tutor(dto.nome(), dto.telefone(), dto.email());
            repository.save(tutor);
        }
    }

    public void atualizar(TutorDTO dto) {
        Tutor tutor = new Tutor(dto.nome(), dto.telefone(), dto.email(), dto.id());
        repository.save(tutor);
    }


}
