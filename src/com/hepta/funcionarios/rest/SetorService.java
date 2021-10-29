package com.hepta.funcionarios.rest;

import com.hepta.funcionarios.entity.Setor;
import com.hepta.funcionarios.persistence.SetorDAO;
import org.hibernate.HibernateError;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/setores")
public class SetorService {

    @Context
    private HttpServletRequest request;

    @Context
    private HttpServletResponse response;

    private SetorDAO dao;

    public SetorService() {
        dao = new SetorDAO();
    }

    /**
     * Lista todos os Setores
     *
     * @return response 200 (OK) - Conseguiu listar
     */
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response SetorRead() {
        List<Setor> Setores = new ArrayList<>();
        try {
            Setores = dao.getAll();
        } catch (HibernateError e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
        catch (Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao buscar os setores!").build();
        }

        GenericEntity<List<Setor>> entity = new GenericEntity<List<Setor>>(Setores) {
        };
        return Response.status(Response.Status.OK).entity(entity).build();
    }

    protected void setRequest(HttpServletRequest request) {
        this.request = request;
    }

}
