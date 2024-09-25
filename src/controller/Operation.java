package controller;

import controller.impl.Employee;

import java.io.IOException;
import java.util.HashMap;

public interface Operation {
    HashMap<Integer, Employee> readFile(String path);
    void writeFile(String path) throws IOException;
} 
