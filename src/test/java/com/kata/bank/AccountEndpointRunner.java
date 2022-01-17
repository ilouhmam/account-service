package com.kata.bank;


import com.intuit.karate.junit5.Karate;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = AccountServiceApplication.class,webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)

public class AccountEndpointRunner {
    @Karate.Test
    Karate testAll() {
        return Karate.run().relativeTo(getClass());
    }

}