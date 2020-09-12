package com.wcc.blog;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest
public class BlogApplicationTests {

    @Test
    void contextLoads() {
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            System.out.println(random.nextInt(15)+1);
        }

    }

}
