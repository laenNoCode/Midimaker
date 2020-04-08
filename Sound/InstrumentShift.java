package Sound;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

import Utils.SerializableTrackEvent;
import Utils.StringRep;
import Utils.TrackEvent;

public class InstrumentShift implements SerializableTrackEvent {

	int time;
	int instrumentID;
	public InstrumentShift(int time, int instumentID) {
		this.time = time;
		this.instrumentID = instumentID;
	}
	
	public int getTime() {
		return time;
	}
	
	public int getInstrumentID() {
		return instrumentID;
	}
	@Override
	public String toStringRep() {
		// TODO Auto-generated method stub
		return "" + instrumentID + " " + time;
	}

	@Override
	public InstrumentShift fromStringRep(String rep) {
		// TODO Auto-generated method stub
		int ID = Integer.parseInt(rep.split(" ")[0]);
		int time = Integer.parseInt(rep.split(" ")[1]);
		InstrumentShift toRet = new InstrumentShift(time, ID);
		return toRet;
	}

	@Override
	public void addToTrack(Track tra, int channel) throws InvalidMidiDataException {
		// TODO Auto-generated method stub
		ShortMessage evt = new ShortMessage();
		evt.setMessage(ShortMessage.PROGRAM_CHANGE, channel, this.instrumentID, 0);
		MidiEvent mevt = new MidiEvent(evt, this.time);
		tra.add(mevt);
	}

	@Override
	public char getTrackID() {
		// TODO Auto-generated method stub
		return 'I';// I for Instrument
	}

}
