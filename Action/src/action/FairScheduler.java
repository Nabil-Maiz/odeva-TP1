package action;
import java.util.*;

/**
 * A fair scheduler realize all the action in a fair time. For each call to the doStep method,
 * the scheduler will realize a step of the first non-terminated action which follow <code>a</code>,
 * where <code>a</code> is the current action  
 * @author agez, maiz
 */
public class FairScheduler extends Scheduler {

	public FairScheduler(List<Action> actions) {
		super(actions);
		ready = nextAction();
		finished = !ready;
	}
	
	
	// METHODS
	/**
	 * Verify if the scheduler is not finished
	 * If the scheduler is finished, set the <code>finished</code> attribute to true
	 * else, set the <code>currentAction</code> attribute to the next not finished action
	 * @return true if the scheduler is not finished
	 */
	protected boolean nextAction() {
		if (!link())
			finished = true;
		else {
			while (currentAction == null || currentAction.isFinished()) {
				if (!link()) { 
					finished = true;
					return false;
				}
			}
		}
		return !finished;
	}
	
	private boolean link() {
		if (it.hasNext())
			currentAction = it.next();
		else if (!allFinished()) {
			it = actions.iterator();
			currentAction = it.next();
		}
		else
			return false;
		return true;
	}
	
	private boolean allFinished() {
		boolean found = false;
		Iterator<Action> i = actions.iterator();
		while (!found && i.hasNext()) {
			if (!i.next().isFinished())
				found = true;
		}
		return !found;
	}
	
	
}
