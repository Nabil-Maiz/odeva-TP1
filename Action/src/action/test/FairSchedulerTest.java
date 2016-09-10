package action.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import action.*;

public class FairSchedulerTest {

	@Test
	public void testStateOfScheduler() {
		List<Action> list = new ArrayList<Action>();
		list.add(new ForeseeableAction(6));
		list.add(new ForeseeableAction(1));
		list.add(new ForeseeableAction(3));
		list.add(new ForeseeableAction(5));

		
		FairScheduler schedul = new FairScheduler(list);
		assertTrue(schedul.isReady());
		assertFalse(schedul.isInProgress());
		assertFalse(schedul.isFinished());
		try {
			for (int i = 0; i < 14; i++) {
				schedul.doStep();
				assertFalse(schedul.isReady());
				assertTrue(schedul.isInProgress());
				assertFalse(schedul.isFinished());
			}
			schedul.doStep();
		}
		catch(ActionFinishedException e) {
			fail ("Action finished");
		}
		assertFalse(schedul.isReady());
		assertFalse(schedul.isInProgress());
		assertTrue(schedul.isFinished());
	}

}
