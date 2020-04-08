package Test.Sound;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Sound.Channel;

class ChannelTest {
	Channel c;
	@BeforeEach
	void init() {
		c = new Channel(0);
	}
	@Test
	void test() {
		String values="C:0;\r\nI:0 10;\r\nN:C 7 20 100 100;\r\nN:D 4 20 100 100";
		c = c.fromStringRep(values);
		System.out.println(values);
		System.out.println(c.toStringRep());
		assertTrue(c.toStringRep().contentEquals(values));
	}

}
