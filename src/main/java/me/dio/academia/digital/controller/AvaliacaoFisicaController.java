package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.exception.NotFoundException;
import me.dio.academia.digital.service.impl.AvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {

    @Autowired
    private AvaliacaoFisicaService avalicaoService;

    @GetMapping
    public List<AvaliacaoFisica> getAll() {
        return avalicaoService.getAll();
    }

    @PostMapping
    public AvaliacaoFisica create(@RequestBody AvaliacaoFisicaForm avaliacaoForm) throws NotFoundException {
        return avalicaoService.create(avaliacaoForm);
    }

    @GetMapping("/{id}")
    public AvaliacaoFisica get(@PathVariable("id") UUID avaliacaoId) {
        return avalicaoService.get(avaliacaoId);
    }

    @PutMapping("/{id}")
    public AvaliacaoFisica update(@PathVariable("id") UUID avaliacaoId, @RequestBody AvaliacaoFisicaUpdateForm form) {
        return avalicaoService.update(avaliacaoId, form);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID avaliacaoId) {
        avalicaoService.delete(avaliacaoId);
    }
}
