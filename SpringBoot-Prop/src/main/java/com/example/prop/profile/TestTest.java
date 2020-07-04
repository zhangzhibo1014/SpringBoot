package com.example.prop.profile;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestTest implements TestInterface {
    @Override
    public void test() {
        System.out.println("test config");
    }
}
