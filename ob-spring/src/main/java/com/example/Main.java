package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        //Opcion 1. Crear un objeto de forma normal

        //Calculadora service = new Calculadora();

        //Opcion 2. Recibir un objeto de Spring

       Calculadora calculadora = (Calculadora) context.getBean("calculadora");
       String texto = calculadora.holamundo();
        System.out.println(texto);

        //Ejemplo 2
        GestorFacturas gestor = (GestorFacturas) context.getBean("gestorFacturas");
        System.out.println(gestor.calculadora.holamundo());
    }
}
