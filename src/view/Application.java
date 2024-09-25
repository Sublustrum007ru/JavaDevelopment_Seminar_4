package view;


import controller.impl.Employee;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class Application {
    public static void app() throws IOException {
        promtMSG("Hello world!!!\nMy name is Sublustrum007\n");
        run();
    }

    private static void run() throws IOException {
//        EmployeeOld empl = new EmployeeOld();
//        empl.addNewEmployee();

//        System.out.println("Вывод всего списка сотрудников List");
//        List<EmployeeOld> test = empl.readFile("Employee.txt");
//        for (EmployeeOld o : test) {
//            System.out.println(o);
//        }


        System.out.println("Вывод всего списка сотрудников HashMap");
        Employee empl = new Employee();
        empl.addNewEmployee();
        HashMap<Integer, Employee> temp = empl.readFile("Employee.txt");
        for (Map.Entry<Integer, Employee> entry : temp.entrySet()) {
            String str = entry.getKey() + "," + entry.getValue();
            System.out.println(str.replace("=",","));
        }
    }

    public static void promtMSG(String message) {
        System.out.println(message);
    }
} 
