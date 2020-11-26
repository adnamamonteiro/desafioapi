package br.com.stefanini.maratonadev.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;

import br.com.stefanini.maratonadev.dao.CarroDao;
import br.com.stefanini.maratonadev.dto.CarroDto;
import br.com.stefanini.maratonadev.dto.ContratoDto;
import br.com.stefanini.maratonadev.model.Carro;
import br.com.stefanini.maratonadev.model.parser.CarroParser;
import br.com.stefanini.maratonadev.model.parser.ContratoParser;

/**
 * @author danilodorgam
 * @version 0.1.0
 * @created 29/10/2020 on 18:32
 */
@RequestScoped
public class CarroService {
    @Inject
    CarroDao dao;

    @Inject
    ContratoService contratoService;

    public List<CarroDto> listar(){
   	
    	return dao.listar().stream().map(CarroParser.get()::dto)
    			.collect(Collectors.toList());
    }
    
    public Carro buscarPorPlaca(String placa) {
		Carro carro =  dao.buscarPorPlaca(placa);
		if (carro == null) {
			throw new NotFoundException();
		}
		return carro;
	}
    
    public List<ContratoDto> historicoCarro(String placa){
		
		List<ContratoDto> historico = buscarPorPlaca(placa).getContratos()
		.stream().map(ContratoParser.get()::dto)
		.collect(Collectors.toList());
		
		return historico;
	}
}
