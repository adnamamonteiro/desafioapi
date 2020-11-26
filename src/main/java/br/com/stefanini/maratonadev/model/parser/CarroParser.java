package br.com.stefanini.maratonadev.model.parser;

import java.util.List;

import br.com.stefanini.maratonadev.dto.CarroDto;
import br.com.stefanini.maratonadev.model.Carro;
import br.com.stefanini.maratonadev.model.Contrato;
import br.com.stefanini.maratonadev.model.dominio.StatusEnum;

/**
 * @author danilodorgam
 * @version 0.1.0
 * @created 29/10/2020 on 18:33
 */
public class CarroParser {

    public static CarroParser get(){
        return  new CarroParser();
    }

    public CarroDto dto(Carro entidade){
        CarroDto dto = new CarroDto();

        dto.setPlaca(entidade.getPlaca());
        dto.setAno(entidade.getAno());
        dto.setModelo(entidade.getModelo());
        dto.setMarca(entidade.getMarca());
        dto.setDisponivel(!verificaDisponibilidade(entidade.getContratos()));
        return dto;
    }
    
    public Carro entidade(CarroDto dto){
        Carro entidade = new Carro();

        entidade.setAno(dto.getAno());
        entidade.setPlaca(dto.getPlaca());
        entidade.setModelo(dto.getModelo());
        entidade.setMarca(dto.getMarca());
        return entidade;
    }
    
    private Boolean verificaDisponibilidade(List<Contrato> contratos){
    	
    	return contratos.stream()
    			.anyMatch(c -> c.getStatus().equals(StatusEnum.ATIVADO));
    }
}
