package util;

import controller.impl.EmployeeOld;

import java.util.List;

public class Validator {


    public static boolean isNumeric(String args) {
        boolean result = false;
        try{
            Integer.parseInt(args);
            result = true;
        }catch(NumberFormatException e){
            System.out.println(e.getMessage());
            result = false;
        }
        return result;
    }

    public static boolean validEmpl(EmployeeOld empl, List<EmployeeOld> list){
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
