package Sound;

import java.io.Serializable;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

import Utils.SerializableTrackEvent;
import Utils.StringRep;
import Utils.TrackEvent;

public class Note implements SerializableTrackEvent{
	public int getTon() {
		return ton;
	}
	public void setTon(int ton) {
		this.ton = ton;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public int getQuand() {
		return quand;
	}
	public void setQuand(int quand) {
		this.quand = quand;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}

	int ton;
	int volume;
	int quand;
	int duree;
	public Note() {}
	public Note(int ton, int volume, int quand, int duree) {
		this.ton = ton;
		this.volume = volume;
		this.quand = quand;
		this.duree = duree;
	}
	public Note(String not) 
	{
		String notes = "C D EF G A B";
		// model"A 7 volume date duration"
		String nom = not.charAt(0) + "" + not.charAt(1);
		int octave = Integer.parseInt("" + not.charAt(2));
		this.ton = 12*octave + notes.indexOf(not.charAt(0)) + (not.charAt(1) == '#' ? 1:0);
		not = not.substring(4);
		this.volume = Integer.parseInt(not.split(" ")[0]);
		this.quand = Integer.parseInt(not.split(" ")[1])+1;
		this.duree = Integer.parseInt(not.split(" ")[2]);
	}
	public void addToTrack(Track tra, int channel) throws InvalidMidiDataException {
		ShortMessage on = new ShortMessage();
		ShortMessage off = new ShortMessage();
		on.setMessage(ShortMessage.NOTE_ON, channel, this.ton, this.volume);
		off.setMessage(ShortMessage.NOTE_OFF, channel, this.ton, this.volume);
		MidiEvent mon = new MidiEvent(on, this.quand);
		MidiEvent moff = new MidiEvent(off, this.quand + this.duree);
		tra.add(mon);
		tra.add(moff);
	}
	
	@Override
	public String toStringRep() {
		String notes = "C D EF G A B";
		// model"A 7 20 20 2"
		String rep = "";
		String noteName = "" + notes.charAt(this.ton%12);
		if (noteName.contentEquals(" ")) {
			noteName = "" + notes.charAt(this.ton%12 - 1) + "#";
		}
		else 
			noteName += " ";
		noteName += "" + this.ton/12;
		rep = noteName + " " + this.volume + " " + (this.quand-1) + " " + this.duree; 
		return rep;
	}

	@Override
	public Note fromStringRep(String rep) {
		// TODO Auto-generated method stub
		return new Note(rep);
	}
	@Override
	public char getTrackID() {
		// TODO Auto-generated method stub
		return 'N';// N for Note
	}

}
