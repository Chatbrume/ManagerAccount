package eu.ensup.manageraccount.service;

import eu.ensup.manageraccount.entity.Roles;
import eu.ensup.manageraccount.entity.User;
import eu.ensup.manageraccount.repository.UserRepository;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest
{
    @Mock
    private UserRepository userRepository;
    
    @InjectMocks
    private UserService userService;

    @Test
    public void findAll()
    {
        List<User> users = Arrays.asList(
                new User(1, "Admin", "pwd", Roles.ADMIN),
                new User(2, "User", "userpwd", Roles.USER)
        );

        // given
        when(userRepository.findAll()).thenReturn(users);

        // when
        List<User> founds = userService.findAll();
        MatcherAssert.assertThat(founds.size(), Matchers.equalTo(users.size()));

        // then
        verify(userRepository).findAll();
    }

    @Test
    public void findByUsername()
    {
        User user = new User(2, "User", "userpwd", Roles.USER);

        // given
        when(userRepository.findByUsername("User")).thenReturn(Optional.of(user));

        // when
        User founds = userService.findByUsername("User");
        MatcherAssert.assertThat(founds.toString(), Matchers.equalTo(user.toString()));

        // then
        verify(userRepository).findByUsername("User");
    }

    @Test
    public void findById()
    {
        User user = new User(2, "User", "userpwd", Roles.USER);

        // given
        when(userRepository.findById(2)).thenReturn(Optional.of(user));

        // when
        User found = userService.findById(2);
        MatcherAssert.assertThat(found.getRole(), Matchers.equalTo(user.getRole()));

        // then
        verify(userRepository).findById(2);
    }

    @Test
    public void save()
    {
        User user = new User(2, "User", "userpwd", Roles.USER);

        // given
        when(userRepository.save(user)).thenReturn(user);

        // when
        User found = userService.save(user);
        MatcherAssert.assertThat(found.getRole(), Matchers.equalTo(user.getRole()));

        // then
        verify(userRepository).save(user);
    }

    @Test
    public void deleteById()
    {
        // given
        when(userRepository.findById(2)).thenReturn(Optional.empty());

        // when
        boolean found = userService.deleteById(2);
        MatcherAssert.assertThat(found, Matchers.equalTo(true));

        // then
        verify(userRepository).deleteById(2);
    }

    @Test
    public void delete()
    {
        User user = new User(2, "User", "userpwd", Roles.USER);

        // given
        when(userRepository.findById(2)).thenReturn(Optional.empty());

        // when
        boolean found = userService.delete(user);
        MatcherAssert.assertThat(found, Matchers.equalTo(true));

        // then
        verify(userRepository).delete(user);
    }
}
