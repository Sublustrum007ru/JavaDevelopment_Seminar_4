package controller;

import controller.impl.Employee;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public interface Operation{
    void readFile(String path);
    void writeFile(String path) throws IOException;
} 
