package controller.impl;

import controller.Old;
import controller.OperationOld;
import util.Validator;
import view.Application;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeOld extends Old implements OperationOld {

    private static final String PREFIX_PATH = "src/List/";
    private static final String PATH = "Employee.txt";
    private List<EmployeeOld> list = new ArrayList<>();

    public EmployeeOld(int persannelNumber, String name, String phone, int lenOfService) {
        super(persannelNumber, name, phone, lenOfService);
    }

    public EmployeeOld() {
    }

    public void addNewEmployee() throws IOException {
        System.out.print("Введите данные о работнике(Табельный номер, Имя, номер телефона, стаж работы) через пробел.\nВвод: ");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        EmployeeOld empl = createEmployee(line);
        if(Validator.validEmpl(empl, readFile(PATH))){
            Application.promtMSG("ОШИБКА!!!\nЗапись с таким табельным номероу уже существует!!!\nПовторите ввод!!!\n");
            addNewEmployee();
        }
        list.add(empl);
        writeFile(PATH);

    }

    @Override
    public List<EmployeeOld> readFile(String path) {
        File file = new File(PREFIX_PATH + path);
        BufferedReader br = null;
        List<EmployeeOld> temp = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            while ((line) != null) {
                temp.add(createEmployee(line));
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Не возможно считать файл");
        }
        return temp;
    }

    @Override
    public void writeFile(String path) throws IOException {
        File file = new File(PREFIX_PATH + path);
        BufferedWriter bw = null;
        try {
            checkFile(file);
            bw = new BufferedWriter(new FileWriter(file, true));
            bw.write(list.toString().replace("[", "").replace("]", ""));
            bw.newLine();
            bw.flush();
        } catch (Exception e) {
            System.out.println("Не возможно записать данные\nФайл или поврежден, или защищен от записи");
        }
    }

    private EmployeeOld createEmployee(String str) {
        String[] temp = str.replace(" ", ",").split(",");
        EmployeeOld newEmployee = new EmployeeOld(Integer.parseInt(temp[0]), temp[1], temp[2], Integer.parseInt(temp[3]));
        return newEmployee;
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

    private void checkFile(File file) {
        if (!file.isFile()) {
            createFile(file);
        }
    }

    private void checkFolfer() {
        File theDir = new File(PREFIX_PATH);
        if (!theDir.exists()) {
            theDir.mkdir();
        }
    }
}
