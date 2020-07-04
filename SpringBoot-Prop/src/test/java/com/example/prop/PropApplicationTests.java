package com.example.prop;

import com.example.prop.bean.Person;
import com.example.prop.profile.TestInterface;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PropApplicationTests {

    @Autowired
    private TestInterface tests;

    @Test
    void contextLoads() {
        tests.test();
    }

}
