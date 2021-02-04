package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Reserva;

@Stateless
public class ReservaFacade extends AbstractFacade<Reserva> {

	@PersistenceContext(unitName = "UlloaBermeo-IvanMarcelo-ExamenFinal")
	private EntityManager entityManager;
	
	public ReservaFacade() {
		super(Reserva.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return entityManager;
	}
	
	
}
