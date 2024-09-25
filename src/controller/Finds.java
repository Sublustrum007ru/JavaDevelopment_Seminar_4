package controller;

import controller.impl.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Finds {
    private final String PREFIX_PATH = "src/List/";

    public List<String> finByName(String path, String name) {
        HashMap<Integer, Employee> map = new HashMap<>();
        Employee empl = new Employee();
        map = empl.readFile(path);
        List<String> temp = new ArrayList<>();
        for (Map.Entry<Integer, Employee> entry : map.entrySet()) {
            if (entry.getValue().getName().equals(name)) {
                String line = "Phone: " + entry.getValue().getPhone();
                temp.add(line);
            }
        }
        return temp;
    }

    public List<String> finByLenOfService(String path, int len) {
        HashMap<Integer, Employee> map = new HashMap<>();
        Employee empl = new Employee();
        map = empl.readFile(path);
        List<String> temp = new ArrayList<>();
        for (Map.Entry<Integer, Employee> entry : map.entrySet()) {
            if (entry.getValue().getLenOfService() == len) {
                String line = entry.getKey() + "," + entry.getValue();
                temp.add(line);
            }
        }
        return temp;
    }

    public List<String> finByPersannelNumber(String path, int persannelNumber) {
        HashMap<Integer, Employee> map = new HashMap<>();
        Employee empl = new Employee();
        map = empl.readFile(path);
        List<String> temp = new ArrayList<>();
        if (persannelNumber <= map.size()) {
            for (Map.Entry<Integer, Employee> entry : map.entrySet()) {
                if (entry.getKey() == persannelNumber) {
                    String line = entry.getKey() + "," + entry.getValue();
                    temp.add(line);
                }
            }
        }else{
            System.out.println("Нет такого табельного номера");
        }
        return temp;
    }
}
