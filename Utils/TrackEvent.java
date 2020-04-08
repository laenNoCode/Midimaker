package Utils;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.Track;

public interface TrackEvent {
	public void addToTrack(Track tra, int channel) throws InvalidMidiDataException;
	public char getTrackID();
}
