package br.com.alura.adopet.api.validacoes;

import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDto;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.StatusAdocao;
import br.com.alura.adopet.api.repository.AdocaoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class ValidacaoPetComAdocaoEmAndamentoTest {

    @InjectMocks
    private ValidacaoPetComAdocaoEmAndamento validacaoPetComAdocaoEmAndamento;

    @Mock
    private AdocaoRepository adocaoRepository;

    @Mock
    private SolicitacaoAdocaoDto dto;

    @Test
    void validarAdocaoComSucesso() {
        //ARRANGE
        var petTemAdocaoEmAndamento = adocaoRepository.existsByPetIdAndStatus(this.dto.idPet()
        , StatusAdocao.AGUARDANDO_AVALIACAO);

        Mockito.when(petTemAdocaoEmAndamento).thenReturn(true);

        //ACT + ASSERT
        Assertions.assertThrows(ValidacaoException.class, () -> validacaoPetComAdocaoEmAndamento.validar(dto));
    }

    @Test
    void validarAdocaoComErro() {
        //ARRANGE
        var petTemAdocaoEmAndamento = adocaoRepository.existsByPetIdAndStatus(this.dto.idPet()
                    , StatusAdocao.AGUARDANDO_AVALIACAO);

        Mockito.when(petTemAdocaoEmAndamento).thenReturn(false);

        //ACT + ASSERT
        assertDoesNotThrow(() -> validacaoPetComAdocaoEmAndamento.validar(dto));
    }


}