package Utils;

/***
 * classes which implements this class has to implement
 * toStringRep() and fromStringRep() such as
 * all the fields of this.fromStringRep(this.toStringRep()) and this are 
 * equal
 * @author rubik
 *
 */
public interface StringRep{

	public abstract String toStringRep();
	public abstract StringRep fromStringRep(String rep);
}
