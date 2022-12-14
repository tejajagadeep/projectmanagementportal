package com.cts.projectmanagementportalbackend.security;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import com.cts.projectmanagementportalbackend.model.User;
import com.cts.projectmanagementportalbackend.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Date;


@SpringBootTest
class UserDetailsServiceImplTest {

    @InjectMocks
    UserDetailsServiceImpl userDetailsServiceImpl;

    @Mock
    private UserRepository userRoleRepository;

    @Test
    void testLoadUserByUsername() {
        String dateString = "1999/07/28";
        Date date = new Date(dateString);
        User user =  new User("thunder","user1","user1@gmail.com",78945612310L,date,"ADMIN","{bcrypt}$2a$10$CrYQ4MZGyFKcsRVdHzF.iu1lcFWHBcQx3i9faJj2I/KEwZ3ZNsflm");



        when(userRoleRepository.findByUserName("thunder")).thenReturn(user);
        UserDetailsImpl userDetails = new UserDetailsImpl(user);
        assertEquals(userDetails.getUsername(), userDetailsServiceImpl.loadUserByUsername("thunder").getUsername());
        assertEquals(userDetails.getPassword(), userDetailsServiceImpl.loadUserByUsername("thunder").getPassword());
        assertEquals(userDetails.getAuthorities(), userDetailsServiceImpl.loadUserByUsername("thunder").getAuthorities());
        assertEquals(userDetails.isAccountNonExpired(), userDetailsServiceImpl.loadUserByUsername("thunder").isAccountNonExpired());
        assertEquals(userDetails.isAccountNonLocked(), userDetailsServiceImpl.loadUserByUsername("thunder").isAccountNonLocked());
        assertEquals(userDetails.isCredentialsNonExpired(), userDetailsServiceImpl.loadUserByUsername("thunder").isCredentialsNonExpired());
        assertEquals(userDetails.isEnabled(), userDetailsServiceImpl.loadUserByUsername("thunder").isEnabled());
        assertEquals(userDetails.getUserDetails().getPassword(), userDetailsServiceImpl.loadUserByUsername("thunder").getPassword());
    }

    @Test
    void testLoadUserByUsernameException() {

        when(userRoleRepository.findByUserName("thunder")).thenReturn(null);
        assertThrows(UsernameNotFoundException.class, ()->userDetailsServiceImpl.loadUserByUsername("thunder"));
    }

}