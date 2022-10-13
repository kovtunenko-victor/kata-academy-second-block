package ru.kata.academy.kovtunenko.second.block;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        HelloWorld hello = applicationContext.getBean("helloworld", HelloWorld.class);
        HelloWorld hello1 = applicationContext.getBean("helloworld", HelloWorld.class);

        Cat cat = applicationContext.getBean("cat", Cat.class);
        Cat cat1 = applicationContext.getBean("cat", Cat.class);


        System.out.println("Result for HelloWorld classes " + (hello == hello1));
        System.out.println("Result for Cat classes " + (cat == cat1));
    }
}
