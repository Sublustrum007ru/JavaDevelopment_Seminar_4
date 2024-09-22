package util;

import controller.impl.Employee;

import java.util.List;

public class Validator {


    public static boolean isNumeric(String args) {
        boolean result = false;
        return result;
    }

    public static boolean validEmpl(Employee empl, List<Employee> list){
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if(empl.getPersannelNumber() == list.get(i).getPersannelNumber()){
                count++;
            }
        }
        if (count != 0) {
            return true;
        }
        return false;
    }

} 
