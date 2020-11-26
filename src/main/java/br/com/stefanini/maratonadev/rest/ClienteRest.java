package br.com.stefanini.maratonadev.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import br.com.stefanini.maratonadev.dto.ClienteEnderecoDto;
import br.com.stefanini.maratonadev.dto.ContratoDto;
import br.com.stefanini.maratonadev.exceptions.CpfCadastradoExcpetion;
import br.com.stefanini.maratonadev.service.ClienteService;
import br.com.stefanini.maratonadev.service.EnderecoService;

@Path("cliente")
@Tag(name="Cliente", description="Cadastrar cliente, Listar clientes e Exibir histórico do cliente")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteRest {

	@Inject
    ClienteService service;
	
	@Inject
    EnderecoService enderecoService;
	
	@POST
	@Path("")
	@Operation(summary = "Cadastrar cliente",
    description = "Cadastra um cliente")
	@APIResponse(responseCode = "201",
	    description = "cliente")
    public Response incluir(ClienteEnderecoDto clienteEndDto) throws CpfCadastradoExcpetion {
		Long id  = service.inserir(clienteEndDto);
		enderecoService.incluir(clienteEndDto, id);
        return Response
                .status(Response.Status.CREATED)
                .build();
    }
	
	@GET
    @Operation(summary = "Listar clientes",
            description = "Lista de clientes com endereço")
    @APIResponse(responseCode = "200",
            description = "cliente com endereço",
            content = {
                    @Content(mediaType =  "application/json",
                            schema = @Schema(implementation = ClienteEnderecoDto.class))
            }
    )
    public Response listar(){
        return Response
                .status(Response.Status.OK)
                .entity(service.listarClienteEndereco())
                .build();
    }
	
	@GET
	@Path("/historico/{id}")
    @Operation(summary = "Gerar histórico do cliente",
            description = "Exibe histórico de alugueis do cliente")
    @APIResponse(responseCode = "200",
            description = "histórico de alugueis do cliente",
            content = {
                    @Content(mediaType =  "application/json",
                            schema = @Schema(implementation = ContratoDto.class))
            }
    )
    public Response gerarHistorico(@PathParam("id") Long id){
        return Response
                .status(Response.Status.OK)
                .entity(service.historicoCliente(id))
                .build();
    }

}
	
	

