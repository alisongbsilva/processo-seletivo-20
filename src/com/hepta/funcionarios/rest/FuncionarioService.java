package com.hepta.funcionarios.rest;

import com.hepta.funcionarios.entity.Funcionario;
import com.hepta.funcionarios.persistence.FuncionarioDAO;
import org.hibernate.HibernateError;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.ArrayList;
import java.util.List;

@Path("/funcionarios")
public class FuncionarioService {

	@Context
	private HttpServletRequest request;

	@Context
	private HttpServletResponse response;

	private FuncionarioDAO dao;

	public FuncionarioService() {
		dao = new FuncionarioDAO();
	}

	protected void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * Adiciona novo Funcionario
	 * 
	 * @param Funcionario: Novo Funcionario
	 * @return response 200 (OK) - Conseguiu adicionar
	 */
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@POST
	public Response FuncionarioCreate(Funcionario Funcionario) {
		try {
			dao.save(Funcionario);
		} catch (Exception e){
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Erro ao adicionar funcionário!").build();
		}
		return Response.status(Status.OK).entity("Funcionário cadastrado com sucesso!").build();
	}

	/**
	 * Lista todos os Funcionarios
	 * 
	 * @return response 200 (OK) - Conseguiu listar
	 */
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response FuncionarioRead() {
		List<Funcionario> Funcionarios = new ArrayList<>();
		try {
			Funcionarios = dao.getAll();
		} catch (HibernateError e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
		catch (Exception e){
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Erro ao buscar funcionário!").build();
		}

		GenericEntity<List<Funcionario>> entity = new GenericEntity<List<Funcionario>>(Funcionarios) {
		};
		return Response.status(Status.OK).entity(entity).build();
	}

	/**
	 * Busca um Funcionario
	 *
	 * @return response 200 (OK) - Conseguiu listar
	 */
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response FuncionarioReadOne(@PathParam("id") Integer id) {
		Funcionario funcionario;
		try {
			funcionario = dao.find(id);
		} catch (HibernateError e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
		catch (Exception e){
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Erro ao buscar funcionário!").build();
		}
		return Response.status(Status.OK).entity(funcionario).build();
	}

	/**
	 * Atualiza um Funcionario
	 * 
	 * @param id:          id do Funcionario
	 * @param Funcionario: Funcionario atualizado
	 * @return response 200 (OK) - Conseguiu atualizar
	 */
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@PUT
	public Response FuncionarioUpdate(@PathParam("id") Integer id, Funcionario Funcionario) {
		try {
			dao.update(Funcionario);
		} catch (Exception e){
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Erro ao atualizar funcionário!").build();
		}
		return Response.status(Status.OK).entity("Funcionário atualizado com sucesso!").build();
	}

	/**
	 * Remove um Funcionario
	 * 
	 * @param id: id do Funcionario
	 * @return response 200 (OK) - Conseguiu remover
	 */
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@DELETE
	public Response FuncionarioDelete(@PathParam("id") Integer id) {
		try {
			dao.delete(id);
		} catch (Exception e){
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Erro ao excluir funcionário.").build();
		}
		return Response.status(Status.OK).entity("Funcionário excluído com sucesso!").build();
	}

}
