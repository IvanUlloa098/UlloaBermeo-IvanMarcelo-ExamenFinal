package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Restaurante;

@Stateless
public class RestauranteFacade  extends AbstractFacade<Restaurante> {

	@PersistenceContext(unitName = "UlloaBermeo-IvanMarcelo-ExamenFinal")
	private EntityManager entityManager;
	
	public RestauranteFacade() {
		super(Restaurante.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return entityManager;
	}
	
	
	
}
