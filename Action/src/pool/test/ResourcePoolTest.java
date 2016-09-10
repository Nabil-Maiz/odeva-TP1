package pool.test;

import static org.junit.Assert.*;
import java.util.*;
import pool.*;
import org.junit.Test;

public class ResourcePoolTest {

	@Test (expected = IllegalArgumentException.class)
	public void canGiveResourceThatWasNotTaken() {
		ResourcePool<Basket> p1 = new BasketPool(1);
		ResourcePool<Basket> p2 = new BasketPool(1);
		p1.freeResource(p2.provideResource());
	}
	
	@Test (expected = NoSuchElementException.class)
	public void cantTakeResourceFromPoolWithNoResource() {
		ResourcePool<Cubicle> p = new CubiclePool(1);
		try {
			assertTrue(p.hasAvailableResource());
			p.provideResource();
			assertFalse(p.hasAvailableResource());
		}
		catch (NoSuchElementException e) {
			fail("There should have a free resource");
		}
		p.provideResource();
	}
	

	@Test 
	public void hasAvailableResourceTest() {
		ResourcePool<Cubicle> p = new CubiclePool(1);
		assertTrue(p.hasAvailableResource());
		Cubicle c = p.provideResource();
		assertFalse(p.hasAvailableResource());
		p.freeResource(c);
		assertTrue(p.hasAvailableResource());
	}

}
