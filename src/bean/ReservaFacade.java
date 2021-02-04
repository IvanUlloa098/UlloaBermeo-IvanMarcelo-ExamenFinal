package bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ejb.PersonaFacade;
import ejb.RestauranteFacade;
import entity.Persona;
import entity.Reserva;
import entity.Restaurante;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class ReservaFacade implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	
	private String fecha;
	private String hora;
	private String numPersonas;
	private String cedula;
	private String restauranteSL;
	
	@EJB
	private ReservaFacade reservaFacade;
	
	@EJB
	private RestauranteFacade restauranteFacade;
	
	@EJB
	private PersonaFacade personaFacade;
	
	
	Persona persona;
	
	Restaurante restaurante;
	
	Reserva reserva; 
	
	public ReservaFacade() {
		
	}
	
	@PostConstruct
    public void init(){
        
		System.out.println("***ReservaFacade INICIALIZADO***");
		
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getNumPersonas() {
		return numPersonas;
	}

	public void setNumPersonas(String numPersonas) {
		this.numPersonas = numPersonas;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
	
	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getRestauranteSL() {
		return restauranteSL;
	}

	public void setRestauranteSL(String restauranteSL) {
		this.restauranteSL = restauranteSL;
	}

	public void crearReserva() {
		
		try {
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
