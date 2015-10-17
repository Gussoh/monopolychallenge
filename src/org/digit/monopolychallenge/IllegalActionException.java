package org.digit.monopolychallenge;

/**
 * Created by gussoh on 17/10/15.
 */
public class IllegalActionException extends Exception {

    public IllegalActionException() {
        super();
    }

    public IllegalActionException(String message) {
        super(message);
    }

    public IllegalActionException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalActionException(Throwable cause) {
        super(cause);
    }

    protected IllegalActionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
