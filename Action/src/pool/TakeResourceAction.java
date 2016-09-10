package pool;
import java.util.*;

/**
 * Represent the action of taking a resource. The number of steps cannot be known, 
 * because the action is finished only when the resource is really taken
 * @author agez, maiz
 * @param <R>
 */
public class TakeResourceAction<R extends Resource> extends ResourcePoolAction<R> {

	
	// CONSTRUCTOR
	public TakeResourceAction(ResourcePool<R> pool, ResourcefulUser<R> user) {
		super(pool, user);
	}
	
	@Override
	protected void reallyDoStep() {
		isReady = false;
		System.out.print(" try to take resource from pool " + pool + "... ");
		try {
			R r = pool.provideResource();
			user.setResource(r);
			isFinished = true;
			System.out.println("success");
		}
		catch (NoSuchElementException e) {
			System.out.println("failed");
		}
	}
}
