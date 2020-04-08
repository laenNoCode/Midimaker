package Test.Sound;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Sound.Note;
import Utils.TrackEvent;

class NoteTest {
	static Note n;
	static Random r;
	@BeforeAll
	static void initAll() {
		r = new Random();
	}
	@BeforeEach
	void initNoteTest() {
		n = new Note(48, r.nextInt(127), r.nextInt(), r.nextInt());
	}

	@Test
	void test() {
		Note n2 = n.fromStringRep(n.toStringRep());
		assertEquals(n.getDuree() , n2.getDuree() );
		assertEquals(n.getQuand() , n2.getQuand() );
		assertEquals(n.getTon()   , n2.getTon()   );
		assertEquals(n.getVolume(), n2.getVolume());
		n = new Note(49, r.nextInt(127), r.nextInt(), r.nextInt());
		n2 = n.fromStringRep(n.toStringRep());
		assertEquals(n.getDuree() , n2.getDuree() );
		assertEquals(n.getQuand() , n2.getQuand() );
		assertEquals(n.getTon()   , n2.getTon()   );
		assertEquals(n.getVolume(), n2.getVolume());
	}
	@Test
	void testGetterSetters() {
		n = new Note();
		n.setDuree(5);
		n.setQuand(5);
		n.setTon(5);
		n.setVolume(5);
		assertEquals(n.getDuree() , 5);
		assertEquals(n.getQuand() , 5);
		assertEquals(n.getTon()   , 5);
		assertEquals(n.getVolume(), 5);
	}
	@Test
	void checkTrackId() {
		assertEquals('N', n.getTrackID());
	}

}
