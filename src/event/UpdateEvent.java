package event;

import java.util.EventObject;

/**
 * Događaj opisuje promenu nad modelom. Ovu klasu je moguće proširiti tako
 * da nosi informacije o tome šta je tačno u modelu promenjeno u cilju optimizacije
 * iscrtavanje.
 * @author igor
 *
 */
public class UpdateEvent extends EventObject {

	public UpdateEvent(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}


}
