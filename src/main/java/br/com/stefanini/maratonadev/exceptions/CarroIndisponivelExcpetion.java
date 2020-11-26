package br.com.stefanini.maratonadev.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class CarroIndisponivelExcpetion extends Exception implements
		ExceptionMapper<CarroIndisponivelExcpetion> {

	
	private static final long serialVersionUID = 1L;
	
	public CarroIndisponivelExcpetion() {
	        super("Carro Indisponivel");
	    }
	 
	@Override
	public Response toResponse(CarroIndisponivelExcpetion exception) {
		return Response.status(500).entity(exception.getMessage())
                .type("text/plain").build();
	}

}
