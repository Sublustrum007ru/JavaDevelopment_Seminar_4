package view;


import controller.Finds;
import controller.impl.Employee;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.List;
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
//        empl.addNewEmployee();
        HashMap<Integer, Employee> temp = empl.readFile("Employee.txt");
        for (Map.Entry<Integer, Employee> entry : temp.entrySet()) {
            String str = entry.getKey() + "," + entry.getValue();
            System.out.println(str.replace("=",","));
        }

        Finds finds = new Finds();
        System.out.println("Find by Name");
        List<String> listByName = finds.finByName("Employee.txt", "Anton");
        for(String o : listByName){
            System.out.println(o);
        }
        System.out.println("Find by Lenght of Service");
        List<String> listByLen = finds.finByLenOfService("Employee.txt", 12);
        for(String o : listByLen){
            System.out.println(o);
        }
        System.out.println("Find by Persannel number");
        List<String> listByPersannelNumber = finds.finByPersannelNumber("Employee.txt", 12);
        for(String o : listByPersannelNumber){
            System.out.println(o);
        }

    }

    public static void promtMSG(String message) {
        System.out.println(message);
    }
} 
