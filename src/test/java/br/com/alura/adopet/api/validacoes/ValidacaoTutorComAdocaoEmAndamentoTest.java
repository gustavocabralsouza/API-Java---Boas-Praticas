//package br.com.alura.adopet.api.validacoes;
//
//import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDto;
//import br.com.alura.adopet.api.repository.AdocaoRepository;
//import br.com.alura.adopet.api.repository.TutorRepository;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.BDDMockito;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//@ExtendWith(MockitoExtension.class)
//class ValidacaoTutorComAdocaoEmAndamentoTest {
//
//    @InjectMocks
//    private ValidacaoTutorComAdocaoEmAndamento validacao;
//
//    @Mock
//    private AdocaoRepository adocaoRepository;
//
//    @Mock
//    private TutorRepository tutorRepository;
//
//    @Mock
//    private SolicitacaoAdocaoDto dto;
//
//    @Test
//    void validarComSucessoTutorEmAndamento() {
//        //ARRANGE
//        var adocao = adocaoRepository.existsByPetIdAndStatus(dto.idTutor());
//        BDDMockito.given(tutor).willReturn(true);
//    }
//
//}