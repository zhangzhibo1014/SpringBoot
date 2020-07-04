package com.example.prop.profile;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("dev")
@Configuration
public class DevTest implements TestInterface {

    @Override
    public void test() {
        System.out.println("dev config");
    }

}
