package com.br.cooapi.veiculo;

import com.br.cooapi.config.ModelMapperConf;
import com.br.cooapi.user.User;
import com.br.cooapi.user.UserService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VeiculoService {

    private final Logger logger = LoggerFactory.getLogger(VeiculoService.class);

    private final VeiculoRepository veiculoRepository;
    private final UserService userService;
    private final ModelMapperConf modelMapperConf;

    public VeiculoService(VeiculoRepository veiculoRepository, UserService userService, ModelMapperConf modelMapperConf) {
        this.veiculoRepository = veiculoRepository;
        this.userService = userService;
        this.modelMapperConf = modelMapperConf;
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

    public VeiculoDTO update(Long id, VeiculoForm veiculoForm){
       Veiculo veiculo  = veiculoRepository.findById(id).orElseThrow(() -> {
            logger.error("Veiculo not found {}", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });

        modelMapperConf.modelMapper().map(veiculoForm, veiculo);

        return VeiculoDTO.from(veiculoRepository.save(veiculo));
    }

    public void delete (Long id){
        Veiculo veiculo = veiculoRepository.findById(id).orElseThrow(() -> {
            logger.error("ID not Found");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
        veiculoRepository.delete(veiculo);
    }

    public List<VeiculoDTO> findByUser(Principal principal) {

        User user = userService.findByCredential(principal.getName()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not Found"));

        List<Veiculo> veiculoList = veiculoRepository.findAllByUser(user);

        return veiculoList.stream().map(VeiculoDTO :: from).collect(Collectors.toList());
    }
}
