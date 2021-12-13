INSERT INTO users(id, username,name, password, email, enabled) VALUES (1, 'admin@email.com','Rogério Maria', '$2a$10$7INevadxq6pXgoHMsArb6u82RA6ef6LHibJb79LWWQe/Rma8zBw32', 'admin@email.com', true);
INSERT INTO users(id, username,name, password, email, enabled) VALUES (2, 'user@email.com','Carlos Matos', '$2a$10$bJk5prDUL0fWuhFxM68Ae.ABOC/QpLBOeqU24oZvrf0C2yPsVFRVS', 'user@email.com', true);
INSERT INTO user_roles(user_id, role) VALUES(1, 'ADMIN');
INSERT INTO user_roles(user_id, role) VALUES(2, 'USER');
INSERT INTO brand(id,marca) VALUES (1,'Fiat');
INSERT INTO brand(id,marca) VALUES (2,'Tesla');
INSERT INTO model(id,modelo,brand_id) VALUES (1 ,'Palio', 1);
INSERT INTO model(id,modelo,brand_id) VALUES (2 ,'Uno', 1);
INSERT INTO model(id,modelo,brand_id) VALUES (3 ,'Model S', 2);
INSERT INTO combustivel(t_combustivel) VALUES ('Gasolina');
INSERT INTO combustivel(t_combustivel) VALUES ('Energia');
INSERT INTO store(id,endereco,nome) VALUES (1, 'Avenida JK , 9091', 'Casa do Óleo');
INSERT INTO store(id,endereco,nome) VALUES (2, 'Centro , 5000', 'Casa do Óleo');
INSERT INTO type_service(id, nome) VALUES (1, 'Troca de Oleo');
INSERT INTO type_service(id, nome) VALUES (2, 'Manutenção');
INSERT INTO veiculo_condicao(condicao) VALUES ('Velho');
INSERT INTO veiculo_condicao(condicao) VALUES ('Novo');
INSERT INTO veiculo (id,ano, model_id, placa, user_id, veiculo_condicao_id) VALUES (1,2020, 1, 'BR1234' , 1 , 2);
INSERT INTO veiculo (id,ano, model_id, placa, user_id, veiculo_condicao_id) VALUES (2,2021, 2, 'EUA345' , 1 , 1);
INSERT INTO veiculo (id,ano, model_id, placa, user_id, veiculo_condicao_id) VALUES (3,2000, 3, 'CND123' , 1 , 2);
INSERT INTO services(data,valor_pago,loja_id,tp_recebe_servico_id,veiculo_id) VALUES ('2016-01-25',300.7, 1, 1, 1);
INSERT INTO services(data,valor_pago,loja_id,tp_recebe_servico_id,veiculo_id) VALUES ('2020-07-27',600.7, 1, 1, 2);
INSERT INTO services(data,valor_pago,loja_id,tp_recebe_servico_id,veiculo_id) VALUES ('2021-06-19',500.40, 1, 1, 3);
INSERT INTO services(data,valor_pago,loja_id,tp_recebe_servico_id,veiculo_id) VALUES ('2017-01-25',300.7, 1, 1, 1);
INSERT INTO services(data,valor_pago,loja_id,tp_recebe_servico_id,veiculo_id) VALUES ('2018-02-27',600.7, 1, 1, 2);
INSERT INTO services(data,valor_pago,loja_id,tp_recebe_servico_id,veiculo_id) VALUES ('2019-04-19',500.40, 1, 1, 3);
/*INSERT INTO abasteci(vlLitro , litros, data_time, combustivel_id, veiculos_id) VALUES (5.99, 13.6 , '2021-10-12',  1, 1);
INSERT INTO abasteci(vlLitro , litros, data_time, combustivel_id, veiculos_id) VALUES (4.60, 22.4 , '2021-10-12', 1, 1);
INSERT INTO abasteci(vlLitro , litros, data_time, combustivel_id, veiculos_id) VALUES (3.60, 16.9 , '2021-10-12', 1, 1);
INSERT INTO abasteci(data_time, litros, combustivel_id, veiculos_id) VALUES ('2021-10-12', 21.6 , 1, 1);
INSERT INTO abasteci(data_time, litros, combustivel_id, veiculos_id) VALUES ('2021-10-12', 98.4 , 1, 2);
INSERT INTO abasteci(data_time, litros, combustivel_id, veiculos_id) VALUES ('2021-10-12', 45.9 , 1, 3);
INSERT INTO abasteci(data_time, litros, combustivel_id, veiculos_id) VALUES ('2021-10-12', 21.6 , 1, 3);*/

INSERT INTO abasteci(data_time, litros, combustivel_id, veiculos_id) VALUES ('2021-10-12', 98.4 , 1, 2);

INSERT INTO abasteci(data_time, litros, combustivel_id, veiculos_id) VALUES ('2021-10-12', 45.9 , 1, 1);

