//package com.br.cooapi.veiculotest;
//
//import com.br.cooapi.brand.Brand;
//import com.br.cooapi.brand.BrandDTO;
//import com.br.cooapi.brand.BrandForm;
//import com.br.cooapi.brand.BrandRepository;
//import com.br.cooapi.model.Model;
//import com.br.cooapi.model.ModelDTO;
//import com.br.cooapi.model.ModelForm;
//import com.br.cooapi.model.ModelRepository;
//import com.br.cooapi.services.Services;
//import com.br.cooapi.services.ServicesDTO;
//import com.br.cooapi.services.ServicesForm;
//import com.br.cooapi.services.ServicesRepository;
//import com.br.cooapi.store.*;
//import com.br.cooapi.typeservice.TypeService;
//import com.br.cooapi.typeservice.TypeServiceDTO;
//import com.br.cooapi.typeservice.TypeServiceForm;
//import com.br.cooapi.typeservice.TypeServiceRepository;
//import com.br.cooapi.veiculo.Veiculo;
//import com.br.cooapi.veiculo.VeiculoForm;
//import com.br.cooapi.veiculo.VeiculoRepository;
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.Test;
//import org.junit.jupiter.api.BeforeEach;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.awt.*;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class VeiculoTestInt {
//
//    @Autowired
//    private ModelRepository modelRepository;
//
//    @Autowired
//    private ServicesRepository servicesRepository;
//
//    @Autowired
//    private StoreRepository storeRepository;
//
//    @Autowired
//    private TypeServiceRepository typeServiceRepository;
//
//    @Autowired
//    private BrandRepository brandRepository;
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @BeforeEach
//    public void init( ) {
//
//        BrandForm brandForm = new BrandForm ("Chevrolet");
//        Brand brand = brandRepository.save(Brand.from(brandForm));
//
//        ModelForm modelForm = new ModelForm("Onix", BrandDTO.from(brand));
//        Model model = modelRepository.save(Model.from(modelForm));
//
//        TypeServiceForm typeServiceForm = new TypeServiceForm("limpeza");
//        TypeService typeService = typeServiceRepository.save(TypeService.from(typeServiceForm));
//
//        StoreForm storeForm = new StoreForm("Casa do òleo","JK");
//        Store store = storeRepository.save(Store.from(storeForm));
//
//        ServicesForm servicesForm = new ServicesForm(1.5, LocalDateTime.now(),TypeServiceDTO.from(typeService), StoreDTO.from(store));
//        Services services = servicesRepository.save(Services.from(servicesForm));
//
//    }
//
//    @Test
//    public void VeiculoCreate () throws Exception {
//
//        VeiculoForm veiculoForm = VeiculoForm.builder().placa("123-mkda").ano(2001).model(ModelDTO.from(modelRepository.getById(1L))).services(ServicesDTO.from(servicesRepository.getById(1L))).build();
//        mockMvc.perform(post("/veiculo").contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(veiculoForm)))
//                .andExpect(status().isOk())
//                .andReturn();
//
//
//    }
//
//}
