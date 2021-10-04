package com.br.cooapi.brand;

import com.br.cooapi.config.ModelMapperConf;
import com.br.cooapi.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandService {

    private BrandRepository brandRepository;
    private ModelMapperConf modelMapper;

    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    public BrandService(BrandRepository brandRepository, ModelMapperConf modelMapper){
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
    }

    public BrandDTO create(BrandForm brandForm){
        if (brandRepository.findByMarcaContaining(brandForm.getMarca()).isPresent()) {
            logger.error("Brand already exists {}", brandForm.getMarca());
        }
        return BrandDTO.from(brandRepository.save(Brand.from(brandForm)));
    }
    public BrandDTO update(Long id, BrandForm brandForm){
        Brand brandFound = brandRepository.findById(id).orElseThrow(() -> {
            logger.error("Id not found {}", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
        modelMapper.modelMapper().map(brandForm, brandFound);
        return BrandDTO.from(brandRepository.save(brandFound));
    }
    public void delete(Long id){
        Brand brand = brandRepository.findById(id).orElseThrow(() -> {
            logger.error("Id not found {}", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
        brandRepository.delete(brand);
    }
    public List<BrandDTO> findAll() {
        List<Brand> brands = brandRepository.findAll();
        return brands.stream().map(BrandDTO::from).collect(Collectors.toList());
    }
}
