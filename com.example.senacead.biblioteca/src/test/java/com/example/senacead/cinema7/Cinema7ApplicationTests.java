package com.example.senacead.cinema7;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class Cinema7ApplicationTests {

    @Autowired
    private ApplicationContext context;

    @Test
    void contextLoads() {

        assertNotNull(context);
        // Listar todos os beans registrados para verificar falhas
        String[] beans = context.getBeanDefinitionNames();
        for (String bean : beans) {
            System.out.println(bean);
        }
    }

}
