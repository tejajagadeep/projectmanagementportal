package com.cts.projectmanagementportalbackend.jwt;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class JwtRequestTest {

    @InjectMocks
    JwtRequest jwtRequest;



    JwtRequest jet = new JwtRequest("","");

    @Test
    void testJwtRequest() {
    }

    @Test
    void testGetUsername() {
        jwtRequest.setUsername("thunder");
        assertEquals("thunder", jwtRequest.getUsername());
    }

    @Test
    void testGetPassword() {
        jwtRequest.setPassword("thunder");
        assertEquals("thunder", jwtRequest.getPassword());
    }

    @Test
    void testGetSerialversionuid() {

    }

    @Test
    void testJwtRequestStringStringLogger() {
    }
}
