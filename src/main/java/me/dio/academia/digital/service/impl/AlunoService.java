package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.exception.NotFoundException;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.AvaliacaoFisicaRepository;
import me.dio.academia.digital.service.IAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AlunoService implements IAlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public Aluno create(AlunoForm form) {
        Aluno aluno = Aluno.builder()
                .nome(form.getNome())
                .cpf(form.getCpf())
                .bairro(form.getBairro())
                .dataDeNascimento(form.getDataDeNascimento()).build();

        return alunoRepository.save(aluno);
    }

    @Override
    public Aluno get(UUID id) throws NotFoundException{
        return alunoRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public List<Aluno> getAll() {
        return alunoRepository.findAll();
    }

    @Override
    public List<AvaliacaoFisica> getAvalicaoesFisicasByAlunoId(UUID alunoId) throws NotFoundException {
        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow(NotFoundException::new);
        return aluno.getAvaliacoes();
    }

    @Override
    public Aluno update(UUID id, AlunoUpdateForm formUpdate) {
        Aluno aluno = get(id);
        aluno.setNome(formUpdate.getNome());
        aluno.setBairro(formUpdate.getBairro());
        aluno.setDataDeNascimento(formUpdate.getDataDeNascimento());
        return alunoRepository.save(aluno);
    }

    @Override
    public void delete(UUID id) {
        get(id);
        alunoRepository.deleteById(id);
    }
}
