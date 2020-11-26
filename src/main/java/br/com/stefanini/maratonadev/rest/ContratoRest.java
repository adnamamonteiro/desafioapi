package br.com.stefanini.maratonadev.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import br.com.stefanini.maratonadev.service.ContratoService;

@Path("contrato")
@Tag(name="Contrato", description="Exibir todos os contratos ativos, Criar ou Desativar um contrato de aluguel")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ContratoRest {

	@Inject
	ContratoService service;
	
	
	@POST
	@Path("/{placa}")
	@Operation(summary = "Criar um contrato de aluguel",
    description = "Cria um contrato de aluguel")
	@APIResponse(responseCode = "201",
	    description = "contrato")
    public Response incluir(@PathParam("placa") String placa, String cpf) throws Exception {
			service.ativarContrato(cpf, placa);
			return Response
                .status(Response.Status.CREATED)
                .build();
    }
	
	@PUT
	@Path("/{id}")
	@Operation(summary = "Desativar um contrato de aluguel",
    description = "Desativa um contrato de aluguel")
	@APIResponse(responseCode = "200",
	    description = "contrato")
    public Response desativar(@PathParam("id") Long id){
		service.desativarContrato(id);
        return Response
                .status(Response.Status.OK)
                .build();
    }
	
	@GET
	@Operation(summary = "Exibir todos os contratos ativos",
    description = "Exibe todos os contratos ativos")
	@APIResponse(responseCode = "200",
	    description = "lista de contratos ativos")
    public Response listar(){
			return Response
                .status(Response.Status.OK)
                .entity(service.listarContratosAtivos())
                .build();
    }
	
}
