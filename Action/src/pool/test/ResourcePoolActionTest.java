package pool.test;

import static org.junit.Assert.*;
import org.junit.Test;
import pool.*;
import action.*;


/**
 * @author agez, maiz
 *
 */
public class ResourcePoolActionTest {

	@Test
	public void takeResourceTest() {
		ResourcePool<Basket> pool = new BasketPool(1);
		ResourcefulUser<Basket> user = new ResourcefulUser<Basket>();
		
		assertTrue(pool.hasAvailableResource());
		assertNull(user.getResource());
		
		Action takeBasket = new TakeResourceAction<Basket>(pool, user);
		try {
			takeBasket.doStep();
		}
		catch (ActionFinishedException e) {
			fail("The action Take Resource should not be finished");
		}
		assertNotNull(user.getResource());
		assertFalse(pool.hasAvailableResource());
		
		Action freeBasket = new FreeResourceAction<Basket>(pool, user);
		try {
			freeBasket.doStep();
		}
		catch (ActionFinishedException e) {
			fail("The action Free Resource should not be finished");
		}
		
		assertNull(user.getResource());
		assertTrue(pool.hasAvailableResource());
	}

}
