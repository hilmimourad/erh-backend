package mourad.hilmi.business.setup

import mourad.hilmi.commons.hashing.Hasher
import mourad.hilmi.data.security.RoleDAO
import mourad.hilmi.data.security.UserDAO
import mourad.hilmi.models.security.Role
import mourad.hilmi.models.security.SecurityModelsConstants
import mourad.hilmi.models.security.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * Created by moura on 5/20/2017.
 */
@Component
class SetupWizard {

    @Autowired RoleDAO roleDAO;
    @Autowired UserDAO userDAO;
    @Autowired Hasher hasher;
    @Autowired SetupConfiguration configuration

    void setup(){
        setupFirstRoles()
        setupFirstUser()
    }


    private void setupFirstRoles(){
        def role = roleDAO.findByName("admin")

        //Check if role already set
        if(role != null) return

        Map<String,Boolean> privileges = [:]
        privileges[SecurityModelsConstants.Privileges.MANAGE_USERS] = true
        role = new Role(name: 'admin',privileges: privileges)
        roleDAO.save(role)
    }

    private void setupFirstUser () {
        String email = configuration.email
        String password = configuration.password
        String fullName = configuration.fullName
        def user = userDAO.findByEmail(email)

        //Check if user is already set
        if(user != null) return

        def roles = []
        roles.add(roleDAO.findByName("admin"))

        user = new User(email:email,
                        password:hasher.hash(password),
                        fullName:fullName,
                        roles: roles)

        userDAO.save(user)
    }
}
