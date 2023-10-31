package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.dto.AbrigoDto;
import br.com.alura.adopet.api.dto.CadastroAbrigoDto;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.repository.AbrigoRepository;
import br.com.alura.adopet.api.repository.AdocaoRepository;
import br.com.alura.adopet.api.repository.PetRepository;
import br.com.alura.adopet.api.repository.TutorRepository;
import br.com.alura.adopet.api.validacoes.ValidacaoSolicitacaoAdocao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class AbrigoServiceTest {

    @InjectMocks
    private AbrigoService abrigoService;

    @Mock
    private AbrigoRepository abrigoRepository;

    @Mock
    private PetRepository petRepository;

    @Mock
    private CadastroAbrigoDto dto;

    @Mock
    private Abrigo abrigo;


    @Test
    void deveriaChamarListaDeTodosAbrigos() {
        //ACT
        abrigoService.listar();

        //ASSERT
        then(abrigoRepository).should().findAll();
    }

    @Test
    void deveriaNaoCadastrarAbrigoExistente() {
        //ARRANGE
        var cadastrado = abrigoRepository.existsByNomeOrTelefoneOrEmail(dto.nome(), dto.telefone(), dto.email());

        //ACT
        when(cadastrado).thenReturn(true);

        //ASSERT
        assertThrows(ValidacaoException.class, () -> abrigoService.cadatrar(dto));

    }

    @Test
    void deveriaCadastrarAbrigo() {
        //ARRANGE
        var cadastrado = abrigoRepository.existsByNomeOrTelefoneOrEmail(dto.nome(), dto.telefone(), dto.email());

        //ACT
        when(cadastrado).thenReturn(false);
        abrigoService.cadatrar(dto);
        //ASSERT
        then(abrigoRepository).should().save(new Abrigo(dto));

    }

    @Test
    void deveriaChamarListaPetsDoAbrigo() {
        //ARRANGE
        String nome = "Miau";
        given(abrigoRepository.findByNome(nome)).willReturn(Optional.of(abrigo));
        //ACT
        abrigoService.listarPetsDoAbrigo(nome);
        //ASSERT
        then(petRepository).should().findByAbrigo(abrigo);
    }


}