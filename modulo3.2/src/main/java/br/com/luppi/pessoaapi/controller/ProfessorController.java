package br.com.luppi.pessoaapi.controller;

import br.com.luppi.pessoaapi.entity.ProfessorEntity;
import br.com.luppi.pessoaapi.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
@Validated
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    @PostMapping
    public ProfessorEntity post(@RequestBody ProfessorEntity professor) {
        return professorRepository.save(professor);
    }

    @GetMapping
    public List<ProfessorEntity> get() {
        return professorRepository.findAll();
    }
}
