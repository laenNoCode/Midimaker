package Sound;

import java.util.Vector;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.Track;

import Utils.SerializableTrackEvent;
import Utils.StringRep;
import Utils.TrackEvent;

public class Channel implements StringRep {
	Vector<SerializableTrackEvent> Events;
	int channelNumber;
	Channel(int c){
		this.channelNumber = c;
		this.Events = new Vector<SerializableTrackEvent>();
	}
	@Override
	public String toStringRep() {
		String toRet = "C:" + channelNumber+";\r\n";
		for (SerializableTrackEvent te:Events) {
			toRet = "" + te.getTrackID() + ":" + te.toStringRep() + ";\n\r";
		}
		return toRet;
	}

	@Override
	public Channel fromStringRep(String rep) {
		// TODO Auto-generated method stub
		Channel chan = new Channel(0);
		Note n = new Note();
		InstrumentShift is = new InstrumentShift(0, 0);
		for (String line : rep.split(";\r\n")) {
			System.out.println(line);
			if (line.startsWith("C:")) {
				chan.channelNumber = Integer.parseInt(line.split("C:")[1].split(";")[0]);
			}else if (line.startsWith("N:")) {
				chan.Events.add(n.fromStringRep(line.split("N:")[1]));
			}else if (line.startsWith("I:")) {
				chan.Events.add(is.fromStringRep(line.split("I:")[1]));
			}
		}
		return chan;
	}
	void addToTrack(Track t) throws InvalidMidiDataException {
		for (SerializableTrackEvent te:Events) 
		{
			te.addToTrack(t, this.channelNumber);
		}
	}
}

