package controller.impl;

import controller.Employees;
import controller.Operation;

import java.io.*;
import java.util.*;

public class Employee extends Employees implements Operation {

    private String PREFIX_PATH = "src/List/";
    private String PATH = "Employee.txt";
    public HashMap<Integer, Employee> map = new HashMap<>();

    public Employee(String name, String phone, int lenOfService) {
        super(name, phone, lenOfService);
    }

    public Employee() {
    }

    /**
     * Метод добавления нового сотрудника. Данные берутся из строки введенной пользователем.
     *
     * @throws IOException
     */
    public void addNewEmployee() throws IOException {
        map = readFile(PATH);
        System.out.print("Введите данные о работнике(Имя, номер телефона, стаж работы) через пробел.\nВвод: ");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int index = createPersannelNumber();
        if (map.get(index) == null && index < map.size()) {
            map.replace(index, map.get(index), createEmployeeInput(line));
        } else {
            map.put(index, createEmployeeInput(line));
        }
        writeFile(PATH);
    }

    @Override
    public HashMap<Integer, Employee> readFile(String path) {
        File file = new File(PREFIX_PATH + path);
        BufferedReader br = null;
        HashMap<Integer, Employee> result = new HashMap<>();
        try {
            br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            while ((line) != null) {
                result.put(createPersannelNumber(line), createEmployeeFile(line));
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return result;
    }

    @Override
    public void writeFile(String path) throws IOException {
        File file = new File(PREFIX_PATH + path);
        BufferedWriter bw = null;
        try {
            checkFile(file);
            bw = new BufferedWriter(new FileWriter(file));
            for (Map.Entry<Integer, Employee> entry : map.entrySet()) {
                bw.write(entry.getKey() + "," + entry.getValue());
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (Exception e) {
            }
        }
    }

    /**
     * Метод генерации табельного номера с читанного из файла.
     *
     * @param line - строка считанная из файла.
     * @return - возвращаем табельный номер.
     */
    private int createPersannelNumber(String line) {
        int result = 0;
        String[] str = line.split(",");
        result = Integer.parseInt(str[0]);
        return result;
    }

    /**
     * Метод генерации табельного номера при вводе данных о новом сотруднике в терминал
     *
     * @return - возвращаем табельный номер.
     */
    private int createPersannelNumber() {
        int result = 0;
        if (getKey(map, "null") != map.size()) {
            result = getKey(map, "null");
        }else {
            result = map.size() + 1;
        }
        return result;
    }

    /**
     * Метод получения свободного табельного номера на основе уже существующего списка сотрудников.
     *
     * @param maping - список всех сотрудников.
     * @param value  - искомое значение. По не проверяем если в списке табельный номер содержит запись равную value.
     * @return - возвращаем табельный номер.
     */
    private int getKey(HashMap<Integer, Employee> maping, String value) {
        Set<Integer> keys = maping.keySet();
        int result = 0;
        for (Integer key : keys) {
            if (maping.get(key) == null) {
                result = key;
            }else{
                result = keys.size() + 1;
            }
        }
        return result;
    }

    /**
     * Этот метод создает сотрудника из строки считанной из файла.
     *
     * @param line - переданная строка, считанная из файла.
     * @return - возвращаем созданного сотрудника.
     */
    private Employee createEmployeeFile(String line) {
        String[] str = line.split(",");
        Employee result = null;
        if (!str[1].equals("null")) {
            result = new Employee(str[1], str[2], Integer.parseInt(str[3]));
        }
        return result;
    }

    /**
     * Этот етод создаент сотрудника из строки введенной пользователем в терминал.
     *
     * @param line - строка введенная пользователем.
     * @return - возвращаем созданного пользователя.
     */
    private Employee createEmployeeInput(String line) throws IOException {
        String[] str = line.split(" ");
        Employee result = null;
        if (str.length != 3) {
            System.out.println("ОШИБКА!!! Не верное колличество аргументов\nПовторите ввод");
            addNewEmployee();
        } else {
            result = new Employee(str[0], str[1], Integer.parseInt(str[2]));
        }
        return result;
    }

    private void checkFile(File file) {
        if (!file.isFile()) {
            createFile(file);
        }
    }

    private void createFile(File file) {
        try {
            checkFolfer();
            if (!file.createNewFile()) {
                System.out.println("Create file");
                createFile(file);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    private void checkFolfer() {
        File theDir = new File(PREFIX_PATH);
        if (!theDir.exists()) {
            theDir.mkdir();
        }
    }
}

