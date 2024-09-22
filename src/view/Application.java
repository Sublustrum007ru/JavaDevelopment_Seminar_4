package view;


import controller.impl.Employee;

import java.io.IOException;
import java.util.List;


public class Application {
    public static void app() throws IOException {
        promtMSG("Hello world!!!\nMy name is Sublustrum007\n");
        run();
    }

    private static void run() throws IOException {
        Employee empl = new Employee();
        empl.addNewEmployee();
        List<Employee> test = empl.readFile("Employee.txt");
        for(Employee o : test){
            System.out.println(o);
        }
    }

    public static void promtMSG(String message){
        System.out.println(message);
    }
} 
