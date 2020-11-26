package br.com.stefanini.maratonadev.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class CpfCadastradoExcpetion extends Exception implements
		ExceptionMapper<CpfCadastradoExcpetion> {

	
	private static final long serialVersionUID = 1L;
	
	public CpfCadastradoExcpetion() {
	        super("Este CPF já está cadastrado");
	    }
	 
	@Override
	public Response toResponse(CpfCadastradoExcpetion exception) {
		return Response.status(400).entity(exception.getMessage())
                .type("text/plain").build();
	}

}
