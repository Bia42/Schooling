/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import modelo.Usuario;
import bd.BD;

/**
 * REST Web Service
 *
 * @author 17137175
 */
@Path("usuarios")
public class UsuariosResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of FilmesResource
     */
  
    
    public UsuariosResource() {

    }

    /**
     * Retrieves representation of an instance of servicos.FilmesResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/{nome}/{senha}")
    @Produces("application/json")
    public  String  getUsuario(
    @PathParam("nome")  String  nome, @PathParam("senha") String senha) throws Exception
    {//bia
      Usuario user = BD.USUARIOS.getAluno(nome, senha);
         Gson  gson  =  new  Gson();
      if(user != null){
            return  gson.toJson("Logado");  
      }else{
          return  gson.toJson("Não logado");  
      }

    }
   
    @GET
    @Produces("application/json") 
    public  String  getJson() {
  //      Gson  gson  =  new  Gson(); 
  //  return  gson.toJson(filmes);
  return null;
    }

    /**
     * PUT method for updating or creating an instance of FilmesResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
        
    }
}
