package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.exception.NotFoundException;
import me.dio.academia.digital.repository.MatriculaRepository;
import me.dio.academia.digital.service.IMatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class MatriculaService implements IMatriculaService {
    @Autowired
    private MatriculaRepository matriculaRepository;
    @Autowired
    private AlunoService alunoService;

    @Override
    public Matricula create(MatriculaForm form) {
        Matricula matricula = Matricula.builder()
                        .aluno(alunoService.get(form.getAlunoId()))
                        .dataDaMatricula(LocalDateTime.now()).build();
        return matriculaRepository.save(matricula);
    }

    @Override
    public Matricula get(UUID id) throws NotFoundException{
        return matriculaRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public List<Matricula> getAll() {
        return matriculaRepository.findAll();
    }

    @Override
    public void delete(UUID id) {
        get(id);
        matriculaRepository.deleteById(id);
    }
}
