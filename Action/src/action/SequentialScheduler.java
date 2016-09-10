package action;
import java.util.*;

/**
 * A sequential scheduler will completely realize an action before he begin the next action
 * @author agez, maiz
 */
public class SequentialScheduler extends Scheduler {
	
	// CONSTRUCTOR

	/**
	 * Create a new sequential scheduler, who start an action only after the previous action has been finished
	 * @param actions The list of action the scheduler have to complete
	 */
	public SequentialScheduler(List<Action> actions) {
		super(actions);
		ready = nextAction();
		finished = !ready;
	}
	
	// METHODS
	@Override
	/**
	 * Verify if the scheduler is not finished
	 * If the scheduler is finished, set the <code>finished</code> attribute to true
	 * else, set the <code>currentAction</code> attribute to the next not finished action
	 * @return true if the scheduler is NOT finished
	 */
	protected boolean nextAction() {
		while (currentAction == null || currentAction.isFinished() && !finished) {
			if (it.hasNext())
				currentAction = it.next();
			else 
				finished = true;
		}
		return !finished;
	}
	
}
