package controller;


public class Old {
    private int persannelNumber;
    private String phone;
    private String name;
    private int lenOfService;

    public Old(int persannelNumber, String name, String phone, int lenOfService) {
        this.persannelNumber = persannelNumber;
        this.phone = phone;
        this.name = name;
        this.lenOfService = lenOfService;
    }
    public Old(){
    }

    public int getPersannelNumber(){
        return persannelNumber;
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

    public void setPersannelNumber(int persannelNumber){
        this.persannelNumber = persannelNumber;
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
        return String.format("%d,%s,%s,%d", persannelNumber, name, phone, lenOfService);
    }

}
