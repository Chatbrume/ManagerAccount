package eu.ensup.manageraccount.repository;

import eu.ensup.manageraccount.ManagerAccountApplication;
import eu.ensup.manageraccount.entity.Account;
import eu.ensup.manageraccount.entity.Roles;
import eu.ensup.manageraccount.entity.TypeAccount;
import eu.ensup.manageraccount.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import java.sql.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@ActiveProfiles("test")
@DataJpaTest
@ContextConfiguration(classes = {ManagerAccountApplication.class})
public class UserRepositoryTest {
    /*@Autowired
    private UserRepository userRepository;

    @Test
    public void testFindAll()
    {
        int search = userRepository.findAll().size();
        assertThat(search, equalTo(2));
    }

    @Test
    public void testFindByNameExist()
    {
        User user = new User(1, "Admin", "AdminPWD", Roles.ADMIN);
        User search = userRepository.findByUsername("Admin").orElse(null);
        assertThat(search.toString(), equalTo(user.toString()));
    }

    @Test
    public void testFindByNameNotExist()
    {
        User search = userRepository.findByUsername("Editor").orElse(null);
        assertThat(search.toString(), equalTo(null));
    }*/
}