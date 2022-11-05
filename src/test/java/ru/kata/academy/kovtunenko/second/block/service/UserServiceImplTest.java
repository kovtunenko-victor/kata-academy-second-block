package ru.kata.academy.kovtunenko.second.block.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import ru.kata.academy.kovtunenko.second.block.config.TestConfig;
import ru.kata.academy.kovtunenko.second.block.model.User;
import ru.kata.academy.kovtunenko.second.block.repository.UserRepository;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class, loader = AnnotationConfigContextLoader.class)
public class UserServiceImplTest {

    @Autowired
    private UserService userService;
    @Autowired
    @Qualifier("userRepositoryMock")
    private UserRepository userRepository;

    @Test
    public void getShouldReturnListOfUserIfUsersExistsInDb() {
        when(userRepository.findAll()).thenReturn(Arrays.asList(User.getEmptyUser(), User.getEmptyUser(), User.getEmptyUser()));
        assertThat(userService.get().size(), equalTo(3));
    }

    @Test
    public void getShouldReturnEmptyListIfUsersNotExistsInDb() {
        when(userRepository.findAll()).thenReturn(Collections.emptyList());
        assertThat(userService.get(), equalTo(Collections.emptyList()));
    }

    @Test
    public void getByIdShouldReturnUserIfExistsInDb() {
        when(userRepository.findById(1L)).thenReturn(new User());
        assertThat(userService.getById(1L).getClass(), equalTo(User.class));
    }

    @Test
    public void getByIdShouldReturnEmptyUserIfNotExistsInDb() {
        when(userRepository.findById(1L)).thenReturn(User.getEmptyUser());
        assertThat(userService.getById(1L).getClass(), equalTo(User.getEmptyUser().getClass()));
    }

    @Test
    public void saveShouldNotRaiseException() {
        assertDoesNotThrow(() -> userService.save(new User()));
    }

    @Test
    public void updateShouldNotRaiseException() {
        assertDoesNotThrow(() -> userService.update(1L, new User()));
    }

    @Test
    public void deleteByIdShouldNotRaiseException() {
        assertDoesNotThrow(() -> userService.deleteById(1L));
    }


}
