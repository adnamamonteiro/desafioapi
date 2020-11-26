package br.com.stefanini.maratonadev.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ClienteNaoCadastradoExcpetion extends Exception implements
		ExceptionMapper<ClienteNaoCadastradoExcpetion> {

	
	private static final long serialVersionUID = 1L;
	
	public ClienteNaoCadastradoExcpetion() {
	        super("Cliente não cadastrado");
	    }
	 
	@Override
	public Response toResponse(ClienteNaoCadastradoExcpetion exception) {
		return Response.status(404).entity(exception.getMessage())
                .type("text/plain").build();
	}

}
