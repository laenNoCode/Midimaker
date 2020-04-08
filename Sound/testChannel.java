package Sound;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;


public class testChannel {
	public static void main(String...strings) throws IOException, MidiUnavailableException, InvalidMidiDataException {
		FileInputStream FIS = new FileInputStream(new File(""));
		Channel c = new Channel(0);
		c = c.fromStringRep(new String(FIS.readAllBytes()));
		Sequencer player = MidiSystem.getSequencer();
		player.open();
		Sequence seq = new Sequence(Sequence.PPQ, 4);
		//on fait le f* prelude de Bach
		Track tra = seq.createTrack();
		c.addToTrack(tra);
		System.out.println("setSequence");
		player.setSequence(seq);
		System.out.println("start");
		player.start();
		System.out.println("test");
	}
}
