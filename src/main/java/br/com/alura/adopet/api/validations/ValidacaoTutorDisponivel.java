package br.com.alura.adopet.api.validations;

import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDto;
import br.com.alura.adopet.api.excpetion.ValidacaoExcpetion;
import br.com.alura.adopet.api.model.Adocao;
import br.com.alura.adopet.api.model.StatusAdocao;
import br.com.alura.adopet.api.model.Tutor;
import br.com.alura.adopet.api.repository.AdocaoRepository;
import br.com.alura.adopet.api.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ValidacaoTutorDisponivel implements ValidacaoSolicitacaoAdocao {

    @Autowired
    private TutorRepository tutorRepository;
    @Autowired
    private AdocaoRepository repository;

    @Override
    public void validar(SolicitacaoAdocaoDto dto) {
        Tutor tutor = tutorRepository.getReferenceById(dto.idTutor());
        List<Adocao> adocoes = repository.findAll();
        for (Adocao a : adocoes) {
            if (a.getTutor() == tutor && a.getStatus() == StatusAdocao.AGUARDANDO_AVALIACAO) {
                throw new ValidacaoExcpetion("Tutor já possui outra adoção aguardando avaliação!");
            }
        }
    }

}
