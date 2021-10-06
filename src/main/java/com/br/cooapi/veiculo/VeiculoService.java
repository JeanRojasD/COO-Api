package com.br.cooapi.veiculo;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class VeiculoService {

    private final Logger logger = LoggerFactory.getLogger(VeiculoService.class);

    private final VeiculoRepository veiculoRepository;

    public VeiculoService ( VeiculoRepository veiculoRepository ){
        this.veiculoRepository = veiculoRepository;
    }

    public Page<VeiculoDTO> findAll(Pageable pageable) {
        Page<Veiculo> veiculoList = veiculoRepository.findAll(pageable);
        return veiculoList.map(VeiculoDTO::from);
    }

    public VeiculoDTO findById(Long id){
        return VeiculoDTO.from(veiculoRepository.findById(id).orElseThrow(() -> {
            logger.error("Veiculo not found {}", id);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }));
    }


    public VeiculoDTO findByTextContaining(String placa){
        return VeiculoDTO.from(veiculoRepository.findByPlacaContaining(placa).orElseThrow(() -> {
            logger.error("Veiculo not found {}", placa);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }));
    }


    public VeiculoDTO Create  (VeiculoForm veiculoForm){

        Veiculo veiculoCreate = Veiculo.from(veiculoForm);

        return VeiculoDTO.from(veiculoRepository.save(veiculoCreate));

    }

    public VeiculoDTO update(VeiculoForm veiculoForm, Long id){

        var modelMapper = new ModelMapper();
        var veiculoFound = veiculoRepository.findById(id).orElseThrow(() -> {
            logger.error("Veiculo not found {}", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });

        modelMapper.map(veiculoForm, veiculoFound);

        return VeiculoDTO.from(veiculoRepository.save(veiculoFound));
    }

    public void delete (Long id ){

        Veiculo veiculo = veiculoRepository.findById(id).orElseThrow(() -> {
            logger.error("ID not Found");
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        });

        veiculoRepository.delete(veiculo);
    }
    
}
