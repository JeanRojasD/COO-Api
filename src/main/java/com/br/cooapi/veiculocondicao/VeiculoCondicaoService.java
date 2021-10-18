package com.br.cooapi.veiculocondicao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VeiculoCondicaoService {

    @Autowired
    private final VeiculoCondicaoRepository veiculoCondicaoRepository;

    public VeiculoCondicaoService(VeiculoCondicaoRepository veiculoCondicaoRepository) {
        this.veiculoCondicaoRepository = veiculoCondicaoRepository;
    }

    public List<VeiculoCondicaoDTO> findAll() {
        List<VeiculoCondicao> veiculoCondicao = veiculoCondicaoRepository.findAll();
        return veiculoCondicao.stream().map(VeiculoCondicaoDTO::from).collect(Collectors.toList());
    }

    public VeiculoCondicaoDTO create(VeiculoCondicaoForm veiculoCondicaoForm) {
        return VeiculoCondicaoDTO.from(veiculoCondicaoRepository.save(VeiculoCondicao.from(veiculoCondicaoForm)));
    }

    public VeiculoCondicaoDTO update(Long id, VeiculoCondicaoForm veiculoCondicaoForm) {
        VeiculoCondicao veiculoCondicao = veiculoCondicaoRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
        veiculoCondicao.setCondicao(veiculoCondicaoForm.getCondicao());
        return VeiculoCondicaoDTO.from(veiculoCondicaoRepository.save(veiculoCondicao));
    }

    public void delete(Long id) {
        VeiculoCondicao veiculoCondicao = veiculoCondicaoRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
        veiculoCondicaoRepository.delete(veiculoCondicao);
    }
}