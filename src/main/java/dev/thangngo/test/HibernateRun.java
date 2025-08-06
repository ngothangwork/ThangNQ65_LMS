package dev.thangngo.test;

import dev.thangngo.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HibernateRun {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.close();
    }
}

