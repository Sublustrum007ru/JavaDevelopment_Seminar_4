package view;


import controller.impl.Employee;

import java.io.IOException;


public class Application {
    public static void app() throws IOException {
        System.out.println("Hello world!!!\nMy name is Sublustrum007\n");
        run();
    }

    private static void run() throws IOException {
        System.out.println("Runnig");
        Employee empl = new Employee();
        empl.addNewEmployee();
    }
} 
