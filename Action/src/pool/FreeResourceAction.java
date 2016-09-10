package pool;

/**
 * Represent the action of freeing a resource
 * @author agez, maiz
 * @param <R> The resource that should be free
 */
public class FreeResourceAction<R extends Resource> extends	ResourcePoolAction<R> {

	
	// CONSTRUCTOR
	public FreeResourceAction(ResourcePool<R> pool, ResourcefulUser<R> user) {
		super(pool, user);
	}

	@Override
	protected void reallyDoStep() {
		System.out.println(" freeing resource from pool " + pool);
		isReady = false;
		R r = user.getResource();
		pool.freeResource(r);
		user.resetResource();
		isFinished = true;
	}

}
