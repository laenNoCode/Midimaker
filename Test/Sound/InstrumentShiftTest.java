package Test.Sound;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Sound.InstrumentShift;

class InstrumentShiftTest {

	@Test
	void testSerialization() {
		InstrumentShift i = new InstrumentShift(5, 100);
		InstrumentShift i2 = i.fromStringRep(i.toStringRep());
		assertEquals(i.getInstrumentID(), i2.getInstrumentID());
		assertEquals(i.getTime(), i2.getTime());
	}
	@Test 
	void testTrackID() {
		InstrumentShift i = new InstrumentShift(0, 0);
		assertEquals('I', i.getTrackID());
	}

}
