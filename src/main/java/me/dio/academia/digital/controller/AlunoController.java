package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.exception.NotFoundException;
import me.dio.academia.digital.service.impl.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<Aluno> getAll() {
        return alunoService.getAll();
    }

    @PostMapping
    public Aluno create(@Valid @RequestBody AlunoForm alunoForm) {
        return alunoService.create(alunoForm);
    }

    @GetMapping("/{alunoId}")
    public Aluno get(@PathVariable("alunoId") UUID alunoId) throws NotFoundException {
        return alunoService.get(alunoId);
    }

    @GetMapping("/avaliacoes/{alunoId}")
    public List<AvaliacaoFisica> getAvalicaoesFisicasByAlunoId(@PathVariable("alunoId") UUID alunoId) throws NotFoundException{
        return alunoService.getAvalicaoesFisicasByAlunoId(alunoId);
    }

    @PutMapping("/{alunoId}")
    public Aluno update(@PathVariable("alunoId") UUID alunoId, @RequestBody AlunoUpdateForm updateForm) {
        return alunoService.update(alunoId, updateForm);
    }

    @DeleteMapping("/{alunoId}")
    public void delete(@PathVariable("alunoId") UUID alunoId) {
        alunoService.delete(alunoId);
    }


}
