package com.example.prop.profile;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
public class ProdTest implements TestInterface {
    @Override
    public void test() {
        System.out.println("prod test");
    }
}
