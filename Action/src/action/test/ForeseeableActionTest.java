package action.test;
import action.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class ForeseeableActionTest {


	@Test
	public void testStateOfAction() {
		ForeseeableAction action = new ForeseeableAction(2);
		assertTrue(action.isReady());
		assertFalse(action.isInProgress());
		assertFalse(action.isFinished());
		try {
			action.doStep();
			assertFalse(action.isReady());
			assertTrue(action.isInProgress());
			assertFalse(action.isFinished());
			action.doStep();
		}
		catch(ActionFinishedException e) {
			fail ("Action finished");
		}
		assertFalse(action.isReady());
		assertFalse(action.isInProgress());
		assertTrue(action.isFinished());
	}
		
		

	/*@Test
	public void testDoStep() {
		fail("Not yet implemented");
	}*/

	@Test (expected = ActionFinishedException.class)
	public void testDoStepWhenActionFinished() throws ActionFinishedException {
		ForeseeableAction action = new ForeseeableAction(1);
		try {
			action.doStep();
		}
		catch (ActionFinishedException e) {
			fail("Action should not be finished yet");
		}
		action.doStep();
	}
	
	@Test (expected = ActionFinishedException.class)
	public void testDoStepWhenActionHasNoStep() throws ActionFinishedException {
		ForeseeableAction action = new ForeseeableAction(0);
		action.doStep();
	}
}
