package rest;

import java.util.List;

import javax.ejb.EJB;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ejb.PersonaFacade;
import ejb.ReservaFacade;
import entity.Persona;
import entity.Reserva;

@Path("/cliente/")
public class ClienteResource {
	
	@EJB
	private PersonaFacade personaFacade;
	
	@EJB
	private ReservaFacade reservaFacade;
	
	@GET
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getCliente(@PathParam("id") String id) {
		
		Jsonb jsonb = JsonbBuilder.create();
		Persona p;
		
		List<Reserva> reservas;
		try {
			
			 p = personaFacade.searchPerson(id);
			 System.out.println("!!!!!!!!");
			 
			 reservas = reservaFacade.clienteReserva(p);
			 System.out.println(">>>> "+ reservas);
			 System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			
			 return Response.ok(jsonb.toJson(reservas))
						.header("Access-Control-Allow-Origin", "*")
						.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
						.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
			
		} catch (Exception e) {
			return Response.status(Response.Status.CONFLICT).entity("No se pudo hacer la busqueda")
                    .header("Access-Control-Allow-Origins", "*")
                    .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                    .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE")
                    .build();
		}
		
    }
	
}
