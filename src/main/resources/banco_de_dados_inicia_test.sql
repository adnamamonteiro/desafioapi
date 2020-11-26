insert into Carro(placa,ano,modelo,marca) values('BQW0877',1990,'SONIC Sed. LTZ 1.6 16V FlexPower 4p Aut.','GM - Chevrolet');
insert into Carro(placa,ano,modelo,marca) values('GWK8629',2015,'Bonanza S  Luxe 4.1','GM - Chevrolet');
insert into Cliente (contato, cpf, email, nome) values ('21956679098', '38466546464', 'esimonot0@apple.com', 'Elnore Simonot');
insert into Cliente (contato, cpf, email, nome) values ('21998299755', '09987674056', 'jann1@amazon.de', 'Jo ann Arger');
insert into Endereco (bairro, cep, cidade, complemento, logradouro, uf, cliente_id) values ('phasellus in', '21857863', 'Sterling', 'tincidunt', '9068 Anniversary Road', 'VA', 1);
insert into Endereco (bairro, cep, cidade, complemento, logradouro, uf, cliente_id) values ('erat', '21514256', 'Vero Beach', 'nulla', '8327 Rowland Court', 'FL', 2);
insert into Contrato (id, data_ativacao, data_desativacao, status, carro_placa, cliente_id) values (1, GETDATE(), NULL, 'ATIVADO', 'BQW0877', 1);
insert into Contrato (id, data_ativacao, data_desativacao, status, carro_placa, cliente_id) values (2, GETDATE(), GETDATE(), 'DESATIVADO', 'BQW0877', 1);
