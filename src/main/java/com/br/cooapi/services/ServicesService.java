package com.br.cooapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicesService {

    @Autowired
    private final ServicesRepository servicesRepository;

    public ServicesService(ServicesRepository servicesRepository){this.servicesRepository = servicesRepository;}

    public List<ServicesDTO> findAll(){
        List<Services> services = servicesRepository.findAll();
        return services.stream().map(ServicesDTO::from).collect(Collectors.toList());
    }

    public ServicesDTO create(ServicesForm servicesForm) {return ServicesDTO.from(servicesRepository.save(Services.from(servicesForm)));}

    public ServicesDTO update(Long id, ServicesForm servicesForm){
        Services services = servicesRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
        services.setValorPago(servicesForm.getValorPago());
        services.setData(servicesForm.getData());
        return ServicesDTO.from(servicesRepository.save(services));
    }

    public void delete(Long id){
        Services services = servicesRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
        servicesRepository.delete(services);
    }
}
