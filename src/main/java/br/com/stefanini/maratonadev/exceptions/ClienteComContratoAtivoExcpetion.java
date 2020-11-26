package br.com.stefanini.maratonadev.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ClienteComContratoAtivoExcpetion extends Exception implements
		ExceptionMapper<ClienteComContratoAtivoExcpetion> {

	
	private static final long serialVersionUID = 1L;
	
	public ClienteComContratoAtivoExcpetion() {
	        super("Cliente com contrato ativo");
	    }

	@Override
	public Response toResponse(ClienteComContratoAtivoExcpetion exception) {
		return Response.status(500).entity(exception.getMessage())
                .type("text/plain").build();
	}

}
