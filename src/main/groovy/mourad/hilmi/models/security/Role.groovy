package mourad.hilmi.models.security

import org.springframework.data.annotation.Id

/**
 * Created by moura on 5/20/2017.
 */
class Role {

    @Id
    String id;

    String name;
    Map<String,Boolean > privileges;

}
