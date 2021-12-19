package exception;;

/**
 * The AimsException wraps all unchecked exceptions You can use this
 * exception to inform
 * 
 * @author nguyenlm
 */
public class EcoBikeException extends RuntimeException {

    public EcoBikeException() {

	}

	public EcoBikeException(String message) {
		super(message);
	}
}