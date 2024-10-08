package controller;


public class Employees {
    private String phone;
    private String name;
    private int lenOfService;

    public Employees(String name, String phone, int lenOfService) {
        this.phone = phone;
        this.name = name;
        this.lenOfService = lenOfService;
    }
    public Employees(){
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public int getLenOfService() {
        return lenOfService;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLenOfService(int lenOfService) {
        this.lenOfService = lenOfService;
    }

    @Override
    public String toString(){
        return String.format("%s,%s,%d", name, phone, lenOfService);
    }

}
