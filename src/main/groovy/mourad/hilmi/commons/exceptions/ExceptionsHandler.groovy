package mourad.hilmi.commons.exceptions

/**
 * Created by moura on 5/20/2017.
 */
interface ExceptionsHandler {

    void handle(Exception e)
    void handle(String message, Exception e)
}
