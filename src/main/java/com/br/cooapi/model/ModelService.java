package com.br.cooapi.model;

import com.br.cooapi.config.ModelMapperConf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModelService {

    private ModelRepository modelRepository;
    private ModelMapperConf modelMapper;

    Logger logger = LoggerFactory.getLogger(ModelService.class);

    public ModelService(ModelRepository modelRepository, ModelMapperConf modelMapper) {
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
    }

    public ModelDTO create(ModelForm modelForm){
        if (modelRepository.findByModeloContaining(modelForm.getModelo()).isPresent()) {
            logger.error("Model already exists {}", modelForm.getModelo());
        }
        return ModelDTO.from(modelRepository.save(Model.from(modelForm)));
    }
    public ModelDTO update(Long id, ModelForm modelForm){
        Model modelFound = modelRepository.findById(id).orElseThrow(() -> {
            logger.error("Id not found {}", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
        modelMapper.modelMapper().map(modelForm, modelFound);
        return ModelDTO.from(modelRepository.save(modelFound));
    }
    public void delete(Long id){
        Model model = modelRepository.findById(id).orElseThrow(() -> {
            logger.error("Id not found {}", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                });
        modelRepository.delete(model);
    }
    public List<ModelDTO> findAll(){
        List<Model> models = modelRepository.findAll();
        return models.stream().map(ModelDTO::from).collect(Collectors.toList());
    }
}
