package mourad.hilmi.commons.exceptions

import org.springframework.stereotype.Component

/**
 * Created by moura on 5/20/2017.
 */
@Component
class PrinterExceptionsHandler implements ExceptionsHandler{
    @Override
    void handle(Exception e) {
        handle(e.getMessage(),e)
    }

    @Override
    void handle(String message, Exception e) {
        println "*********************************************"
        println "============== Message:"+message
        e.printStackTrace()
        println "*********************************************"
    }
}
