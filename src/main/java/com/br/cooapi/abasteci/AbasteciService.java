package com.br.cooapi.abasteci;

import com.br.cooapi.config.ModelMapperConf;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AbasteciService {
    @Autowired
    private AbasteciRepositories repositories;

    @Autowired
    private ModelMapperConf modelMapperConf;

    public List<AbasteciDto> findAll () {
        List<Abasteci> result = repositories.findAll();
        return result.stream().map(AbasteciDto::from).collect(Collectors.toList());
    }

    public AbasteciDto create (AbasteciForm obj) {
        Abasteci abasteci = Abasteci.from(obj);
        return AbasteciDto.from(repositories.save(abasteci));
    }

    public AbasteciDto findById (Integer id) {
        Optional<Abasteci> obj = repositories.findById(id);
        return AbasteciDto.from(obj.get());
    }

    public AbasteciDto update (int id, AbasteciForm abasteci) {
        Abasteci abasteci1 = repositories.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
        modelMapperConf.modelMapper().map(abasteci, abasteci1);
        return AbasteciDto.from(repositories.save(abasteci1));
    }

    public void delete (Integer idAbasteci) {
        findById(idAbasteci);
        try {
            repositories.deleteById(idAbasteci);
        } catch (DataAccessException e) {
            throw new DataIntegrityViolationException("Objeto não pode ser deletado!!!");
        }

    }
}
