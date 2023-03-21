package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.exception.NotFoundException;
import me.dio.academia.digital.repository.AvaliacaoFisicaRepository;
import me.dio.academia.digital.service.IAvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class AvaliacaoFisicaService implements IAvaliacaoFisicaService {

    @Autowired
    private AvaliacaoFisicaRepository avaliacaoRepository;
    @Autowired
    private AlunoService alunoService;

    @Override
    public AvaliacaoFisica create(AvaliacaoFisicaForm form) throws NotFoundException {
        AvaliacaoFisica avaliacaoFisica = AvaliacaoFisica.builder()
                .aluno(alunoService.get(form.getAlunoId()))
                .peso(form.getPeso())
                .altura(form.getAltura())
                .dataDaAvaliacao(LocalDateTime.now())
                .build();
        return avaliacaoRepository.save(avaliacaoFisica);
    }

    @Override
    public AvaliacaoFisica get(UUID id) throws NotFoundException {
        return avaliacaoRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public List<AvaliacaoFisica> getAll() {
        return avaliacaoRepository.findAll();
    }

    @Override
    public AvaliacaoFisica update(UUID id, AvaliacaoFisicaUpdateForm formUpdate) {
        AvaliacaoFisica avaliacaoFisica = get(id);
        avaliacaoFisica.setPeso(formUpdate.getPeso());
        avaliacaoFisica.setAltura(formUpdate.getAltura());
        return avaliacaoRepository.save(avaliacaoFisica);
    }

    @Override
    public void delete(UUID id) {
        get(id);
        avaliacaoRepository.deleteById(id);
    }
}
