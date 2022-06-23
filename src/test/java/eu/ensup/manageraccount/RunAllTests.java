package eu.ensup.manageraccount;

import eu.ensup.manageraccount.repository.AccountRepositoryTest;
import eu.ensup.manageraccount.repository.UserRepositoryTest;
import eu.ensup.manageraccount.service.AccountServiceTest;
import eu.ensup.manageraccount.service.UserServiceTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        AccountRepositoryTest.class,
        AccountServiceTest.class,
        UserRepositoryTest.class,
        UserServiceTest.class
})
public class RunAllTests {
}