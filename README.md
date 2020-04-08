# Midimaker
A simple midi maker project made by laenNoCode  
how to use (pre-alpha version)  
write some data in a text file  
to set the channel use  
C channelNumber;(not supported yet, only one at the start of the file to choos a channel, not important yet)  
ex:  
C 1;  
To change the instrument use:  
I instrumentID timeInTicks;  
where instrumentID is between 0 and 127 is the id of the instrument used  
exemple  
I 0 20;  
sets the instument to piano at 20 ticks  
N engNote(#|| )Octave Volume Date Duration;  
all lines mus end by ;\r\n  
excepte the last.  
A working exemple is in test1.txt  
