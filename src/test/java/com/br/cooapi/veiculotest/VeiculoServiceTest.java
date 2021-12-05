package com.br.cooapi.veiculotest;

import com.br.cooapi.abasteci.Abasteci;
import com.br.cooapi.abasteci.AbasteciForm;
import com.br.cooapi.abasteci.AbasteciRepositories;
import com.br.cooapi.brand.Brand;
import com.br.cooapi.brand.BrandDTO;
import com.br.cooapi.brand.BrandForm;
import com.br.cooapi.brand.BrandRepository;
import com.br.cooapi.combustivel.Combustivel;
import com.br.cooapi.combustivel.CombustivelDto;
import com.br.cooapi.combustivel.CombustivelForm;
import com.br.cooapi.combustivel.CombustivelRepositories;
import com.br.cooapi.model.Model;
import com.br.cooapi.model.ModelForm;
import com.br.cooapi.model.ModelRepository;
import com.br.cooapi.services.Services;
import com.br.cooapi.services.ServicesForm;
import com.br.cooapi.services.ServicesRepository;
import com.br.cooapi.store.Store;
import com.br.cooapi.store.StoreDTO;
import com.br.cooapi.store.StoreForm;
import com.br.cooapi.store.StoreRepository;
import com.br.cooapi.typeservice.TypeService;
import com.br.cooapi.typeservice.TypeServiceDTO;
import com.br.cooapi.typeservice.TypeServiceForm;
import com.br.cooapi.typeservice.TypeServiceRepository;
import com.br.cooapi.user.User;
import com.br.cooapi.user.UserForm;
import com.br.cooapi.user.UserRepository;
import com.br.cooapi.veiculo.Veiculo;
import com.br.cooapi.veiculo.VeiculoForm;
import com.br.cooapi.veiculo.VeiculoRepository;
import com.br.cooapi.veiculocondicao.VeiculoCondicao;
import com.br.cooapi.veiculocondicao.VeiculoCondicaoForm;
import com.br.cooapi.veiculocondicao.VeiculoCondicaoRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.internal.junit.ExceptionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@DataJpaTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class VeiculoServiceTest {

    @Autowired
    VeiculoRepository veiculoRepository;

    @Autowired
    CombustivelRepositories combustivelRepository;

    @Autowired
    AbasteciRepositories abasteciRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    VeiculoCondicaoRepository veiculoCondicaoRepository;

    @Autowired
    private ModelRepository modelRepository;

    @Autowired
    private ServicesRepository servicesRepository;

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private TypeServiceRepository typeServiceRepository;

    @Autowired
    private BrandRepository brandRepository;

    @BeforeEach
    public void init( ) {

        BrandForm brandForm = new BrandForm ("Chevrolet");
        Brand brand = brandRepository.save(Brand.from(brandForm));

        ModelForm modelForm = new ModelForm("Onix", BrandDTO.from(brand));
        Model model = modelRepository.save(Model.from(modelForm));

        TypeServiceForm typeServiceForm = new TypeServiceForm("limpeza");
        TypeService typeService = typeServiceRepository.save(TypeService.from(typeServiceForm));

        StoreForm storeForm = new StoreForm("Casa do òleo","JK");
        Store store = storeRepository.save(Store.from(storeForm));

        CombustivelForm combustivelForm = new CombustivelForm("gasolina");
        Combustivel combustivel = combustivelRepository.save(Combustivel.from(combustivelForm));

//        AbasteciForm abasteciForm = new AbasteciForm(12.5, 10.0, CombustivelDto.from(combustivel));
//        Abasteci abasteci = abasteciRepository.save(Abasteci.from(abasteciForm));

        UserForm userForm = new UserForm("624.274.409-06","Robson João Cleber","clebinhoRobi@hotmail.com","(45)98415-2806","gkh4gf6");
        User user = userRepository.save(User.from(userForm));

        VeiculoCondicaoForm veiculoCondicaoForm = new VeiculoCondicaoForm("Bom");
        VeiculoCondicao veiculoCondicao = veiculoCondicaoRepository.save(VeiculoCondicao.from(veiculoCondicaoForm));

        ServicesForm servicesForm = new ServicesForm(1.5, LocalDateTime.now(), TypeServiceDTO.from(typeService), StoreDTO.from(store));
        Services services = servicesRepository.save(Services.from(servicesForm));

    }

    @Test
    public void placatest () {

        VeiculoForm veiculoForm = new VeiculoForm("123-abcd", 2001 );
        veiculoRepository.save(Veiculo.from(veiculoForm));

        VeiculoForm veiculoForm1 = new VeiculoForm("123-abgd", 2010);

        if (veiculoRepository.findByPlacaContaining(veiculoForm1.getPlaca()).isPresent()) {

            veiculoForm1 = null;
            ResponseEntity.internalServerError();

        } else {
            veiculoRepository.save(Veiculo.from(veiculoForm1));
        }

            Assert.assertEquals( veiculoRepository.findById(2L).get().getPlaca(), veiculoForm1.getPlaca() );
    }

}

