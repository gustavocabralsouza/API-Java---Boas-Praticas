package br.com.alura.adopet.api.controller;

import br.com.alura.adopet.api.dto.TutorDTO;
import br.com.alura.adopet.api.excpetion.ValidacaoExcpetion;
import br.com.alura.adopet.api.service.TutorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tutores")
public class TutorController {

    @Autowired
    private TutorService tutorService;

    @PostMapping
    @Transactional
    public ResponseEntity<String> cadastrar(@RequestBody @Valid TutorDTO dto) {
        try {
             tutorService.cadastrar(dto);
             return ResponseEntity.ok("Tutor cadastrado com sucesso!");
        } catch (ValidacaoExcpetion e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    @Transactional
    public ResponseEntity<String> atualizar(@RequestBody @Valid TutorDTO dto) {
        tutorService.atualizar(dto);
        return ResponseEntity.ok().build();
    }

}
