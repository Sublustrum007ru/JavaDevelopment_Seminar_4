package controller;

import controller.impl.EmployeeOld;

import java.io.IOException;
import java.util.List;

public interface OperationOld {
    List<EmployeeOld> readFile(String path);
    void writeFile(String path) throws IOException;
} 
