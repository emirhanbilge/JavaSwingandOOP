package guı_version_3;

import java.util.ArrayList;

public class Room {

    private int bed;
    private int area;
    private int price;
    private int capacity;
    private int roomNumber;
    private boolean status;
    private int customerID;
    ArrayList<String> services;

    public Room(int bed, int area, int price, int capacity, int roomNumber) {
        super();
        this.bed = bed;
        this.area = area;
        this.price = price;
        this.capacity = capacity;
        this.roomNumber = roomNumber;
        this.status = true;
        services = new ArrayList<String>();
        setDefaultServices();
    }

    public int getBed() {
        return bed;
    }

    public void setBed(int bed) {
        this.bed = bed;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public ArrayList<String> getServices() {
        return services;
    }

    public void setServices(ArrayList<String> services) {
        this.services = services;
    }

    public void setDefaultServices() {
        services.add("Wifi");
        services.add("TV");
        services.add("7/24 Hot Water");
        services.add("Breakfast");
        services.add("Car Park");
        services.add("Park Valet");
        services.add("Room Phone");
    }

    public ArrayList<Object> displayRoom() {
        ArrayList<Object> roomList = new ArrayList<Object>();
        String stt = "";
        if (status == true) {
            stt = "Room is empty";
        } else {
            stt = "Booked room";
        }
        roomList.add(roomNumber);
        roomList.add(bed);
        roomList.add(price);
        roomList.add(stt);
        roomList.add(services.toString());

        return roomList;

    }
    @Override 
    public String toString(){
        String list = "";
        for(String s : services){
            list += s +" ";
        }
        return  list;
    }
}
