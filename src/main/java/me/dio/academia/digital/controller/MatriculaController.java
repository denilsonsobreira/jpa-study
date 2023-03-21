package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.service.impl.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaService matriculaService;

    @PostMapping
    public Matricula create(@RequestBody MatriculaForm form) {
        return this.matriculaService.create(form);
    }

    @GetMapping
    public List<Matricula> getAll(){
        return this.matriculaService.getAll();
    }

    @GetMapping("/{id}")
    public Matricula get(@PathVariable("id") UUID id) {
        return this.matriculaService.get(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id) {
        this.matriculaService.delete(id);
    }
}
