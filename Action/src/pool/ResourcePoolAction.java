package pool;

import action.Action;

public abstract class ResourcePoolAction<R extends Resource> extends Action {

	// ATTRIBUTES
	protected final ResourcePool<R> pool;
	protected final ResourcefulUser<R> user;
	protected boolean isReady;
	protected boolean isFinished;
	
	// CONSTRUCTOR
	public ResourcePoolAction(ResourcePool<R> pool, ResourcefulUser<R> user) {
		this.pool = pool;
		this.user = user;
		isReady = true;
		isFinished = false;
	}
	
	
	
	@Override
	public boolean isReady() {
		return isReady;
	}

	@Override
	public boolean isFinished() {
		return isFinished;
	}

}
