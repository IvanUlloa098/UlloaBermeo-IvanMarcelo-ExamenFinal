package rest;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ejb.ReservaFacade;
import ejb.RestauranteFacade;
import entity.Reserva;
import entity.Restaurante;

@Path("/restaurante/")
public class RestauranteResource {

	@EJB
	private RestauranteFacade restauranteFacade;
	
	@EJB
	private ReservaFacade reservaFacade;
	
	@POST
    @Path("/list/")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public Response registerZero(@FormParam("nombre") String nombre, @FormParam("fecha") String fecha){
		Jsonb jsonb = JsonbBuilder.create();
		Restaurante restaurante;
		List<Reserva> reservas;
		
        try{
        	restaurante = restauranteFacade.nombreRestaurante(nombre);
        	reservas = reservaFacade.fechaReserva(restaurante,fecha);
        	System.out.println(">>>> "+ reservas);
        	
        	//personaFacade.create(persona);
        	return Response.ok(jsonb.toJson(reservas))
					.header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
					.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
        }catch (Exception e){
        	return Response.status(Response.Status.CONFLICT).entity("No se pudo hacer la busqueda")
                    .header("Access-Control-Allow-Origins", "*")
                    .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                    .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE")
                    .build();
        }
        
    }
	
	
}
