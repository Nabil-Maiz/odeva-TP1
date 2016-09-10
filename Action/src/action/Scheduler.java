package action;
import java.util.*;

/**
 * 
 * @author agez, maiz
 *
 */
public abstract class Scheduler extends Action {

	// ATTRIBUTES
	protected List<Action> actions;
	protected boolean ready;
	protected boolean finished;
	protected Iterator<Action> it;
	protected Action currentAction;
	
	// CONSTRUCTOR
	public Scheduler(List<Action> actions) {
		this.actions = actions;
		finished = false;
		this.it = this.actions.iterator();
	}
	

	// METHODS
	/**
	 * Add a new action to the scheduler
	 * @param a The new action
	 */
	public void addAction(Action a) {
		actions.add(a);
	}
	
	@Override
	/**
	 * @see Action#IsReady()
	 */
	public boolean isReady() {
		return ready;
	}

	@Override
	/**
	 * @see Action#isFinished()
	 */
	public boolean isFinished() {
		return finished;
	}
	
	protected abstract boolean nextAction();
	
	@Override
	protected void reallyDoStep() {
		this.ready = false;
		try {
			currentAction.doStep();
		} catch (ActionFinishedException e) {
			throw new IllegalStateException();
		}
		nextAction();
	}
	
	public Action getCurrentAction() {
		return currentAction;
	}
}
