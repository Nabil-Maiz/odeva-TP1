package pool;
import java.util.*;

/**
 * 
 * @author agez, maiz
 */
public abstract class ResourcePool<R extends Resource> {
	
	// ATTRIBUTES
	protected final List<R> availableResources;
	protected final List<R> inUseResources;
	
	// CONSTRUCTOR
	/**
	 * 
	 * @param nbResource The number of resources managed by the pool
	 */
	public ResourcePool(int nbResource) {
		availableResources = new ArrayList<R>(nbResource);
		inUseResources = new ArrayList<R>(nbResource);
		for (int i = 0; i < nbResource; i++) {
			availableResources.add(createResource());
		}
	}
	
	
	// METHODS
	/**
	 * @return a new resource of the type managed by this pool
	 */
	public abstract R createResource();
	
	
	/**
	 * Provide a resource of the pool.
	 * @return The resource provided
	 * @throws NoSuchElementException
	 */
	public R provideResource() throws NoSuchElementException {
		if (!hasAvailableResource())
			throw new NoSuchElementException();
		R resource = availableResources.get(0);
		inUseResources.add(resource);
		availableResources.remove(resource);
		return resource;
	}
	
	/**
	 * Free a resource used of this pool
	 * @param resource The resource to free
	 * @throws IllegalArgumentException
	 */
	public void freeResource(R resource) throws IllegalArgumentException {
		int indUse = inUseResources.indexOf(resource);
		if (indUse == -1)
			throw new IllegalArgumentException("Resource " + resource + " was not part of this pool");
		inUseResources.remove(resource);
		availableResources.add(resource);
	}
	
	/**
	 * @return true only if the pool have at least one resource available
	 */
	public boolean hasAvailableResource() {
		return !availableResources.isEmpty();
	}

}
