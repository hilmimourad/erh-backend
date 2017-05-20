package mourad.hilmi.controls

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by moura on 5/20/2017.
 */
@RestController
class HelloController {

    @RequestMapping('hello')
    public String hello(){
        return "hello spring boot";
    }
}
