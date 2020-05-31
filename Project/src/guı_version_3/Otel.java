package guı_version_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Otel extends Backend {

    static int customerID = 0;
    static int roomID = 1;
    static int employeeID = 0;
    Address address;
    Phone phone;
    private int capacity;
    String otelName;
    ArrayList<Customer> customers;
    HashMap<Integer, String> room; /// Integer = roomNumaras� String = Reserve tarihi default = reservation avaible
    ArrayList<Employee> employee;
    ArrayList<Room> rooms;
    ArrayList<User> users;
    Services services;

    public Otel(Address address, Phone phone, int capacity, String otelName) {

        this.address = address;
        this.phone = phone;
        this.capacity = capacity;
        this.otelName = otelName;
        customers = new ArrayList<Customer>();
        room = new HashMap<Integer, String>();
        employee = new ArrayList<Employee>();
        rooms = new ArrayList<Room>();
        services = new Services();
        users = new ArrayList<User>();
        autoAddRoom();
        autoAddCustomer();
        autoAddEmployee();
    }

    public boolean addRoom(int bed, int area, int price, int Capacity, int roomNumber) {
        try {
            Room r = new Room(bed, area, price, Capacity, roomNumber);
            r.setRoomNumber(roomID);
            room.put(roomID, "Reservation Avaible");
            rooms.add(r);
            roomID++;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void autoAddCustomer() {
        try {
            File myObj = new File("Customer.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String[] data = myReader.nextLine().split(" ");
                addCustomer(data[0], data[1], data[2], data[3], data[4], Integer.valueOf(data[5]),
                        Integer.valueOf(data[6]), Integer.valueOf(data[7]), Integer.valueOf(data[8]),
                        Integer.valueOf(data[9]), Integer.valueOf(data[10]), Integer.valueOf(data[11]), data[12]);

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error Read File Customer");
        }
    }

    public boolean addCustomer(String customerName, String customerSurname, String country, String city, String street,
            int zipCode, int countryCode, int operatorCode, int number, int identityNumber, int employeeId, int roomId,
            String rezervationdate) {
        // rezervationdate format ->10.07.2020-10.08.2020
        try {
            Scanner scanner = new Scanner(System.in);
            Customer c = new Customer(customerName, customerSurname, new Address(country, city, street, zipCode),
                    new Phone(countryCode, operatorCode, number), identityNumber, customerID, roomId);
            customers.add(c);
            Date date = new Date(System.currentTimeMillis());
            String[] dateCurrent = date.toString().split(("-"));
            String[] rezDate = rezervationdate.split("-");
            String[] startDate = rezDate[0].split(".");
            String[] finishDate = rezDate[1].split(".");
            String[] finishD = new String[3];
            finishD[0] = finishDate[2];
            finishD[1] = finishDate[1];
            finishD[2] = finishDate[0];
            if (checker(dateCurrent, startDate) && checker(startDate, finishD)) {
                room.put(roomId, rezervationdate);
            } else {
                System.out.println("Please enter correct rezervation date!");
                String newRezervationDate = scanner.nextLine();
                addCustomer(customerName, customerSurname, country, city, street, zipCode, countryCode, operatorCode,
                        number, identityNumber, employeeId, roomId, newRezervationDate);

            }

            customerID++;
            for (int i = 0; i < employee.size(); i++) {
                if (employeeId == employee.get(i).getEmployee_id()) {
                    employee.get(i).customers.add(c);
                }
            }
            for (int i = 0; i < room.size(); i++) {
                if (roomId == rooms.get(i).getRoomNumber()) {
                    rooms.get(i).setStatus(false);
                    rooms.get(i).setCustomerID(customerID);
                }
            }

            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public void autoAddRoom() {
        try {
            File myObj = new File("Room.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String[] data = myReader.nextLine().split(" ");
                addRoom(Integer.valueOf(data[0]), Integer.valueOf(data[1]), Integer.valueOf(data[2]),
                        Integer.valueOf(data[3]), Integer.valueOf(data[4]));
            }
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error Read File Room");
        }
    }

    public boolean addEmployee(String employeeName, String employeSurname, String country, String city, String street,
            int zipCode, int countryCode, int operatorCode, int number, String department) {

        try {
            Employee e = new Employee(employeeName, employeSurname, new Address(country, city, street, zipCode),
                    new Phone(countryCode, operatorCode, number), department, employeeID);
            employee.add(e);
            employeeID++;
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public static boolean checker(String[] startDate, String[] finishDate) {
        //day month year
        if (Integer.valueOf(startDate[2]) < Integer.valueOf(finishDate[2])) {
            return true; //Year is bigger than return true
        } else if (startDate[2].equals(finishDate[2])) { //Equal year

            if (Integer.valueOf(startDate[1]) < Integer.valueOf(finishDate[1])) {   // check month
                return true;
            } else if (Integer.valueOf(startDate[1]) == Integer.valueOf(finishDate[1])) { // equal month
                if (Integer.valueOf(startDate[0]) < Integer.valueOf(finishDate[0])) { /// check date
                    return true;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
        return false;

    }

    public void autoAddEmployee() {
        try {
            File myObj = new File("Employee.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String[] data = myReader.nextLine().split(" ");
                addEmployee(data[0], data[1], data[2], data[3], data[4], Integer.valueOf(data[5]),
                        Integer.valueOf(data[6]), Integer.valueOf(data[7]), Integer.valueOf(data[8]), data[9]);
            }
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error Read File Room");
        }
    }

    public void buyService() {
        services.displayServices();
        Scanner scan = new Scanner(System.in);
        Stack listBuy = new Stack();
        int servicePrice = 0;
        while (true) {
            String service = scan.nextLine();
            if (service.equals("q")) {
                break;
            } else if (service.equals("remove")) {
                listBuy.pop();
            } else if (services.getServices().get(service) != null) {
                listBuy.push(service);
                servicePrice += services.getServices().get(service);
            } else {
                System.out.println("Wrong choose");
            }
            System.out.println("Your Services :");
            listBuy.display();
        }
        // Customet Id si ile paralar� yaz�lmas� laz�m pricaye
    }

    public ArrayList<Integer> Filter(int choose, int start, int finish) {
        // 1- artan azalan
        // 2- azalan artan
        // 3- fiyat aral���na g�re
        // 4- kapasite

        Tree tree = new Tree(0, 0);
        for (Room r : rooms) {
            tree.insert(tree.node, r.getRoomNumber(), r.getPrice());
        }
        if (choose == 1) {
            return tree.inOrderDesc(tree.node);
        } else if (choose == 2) {
            return tree.inOrder(tree.node);
        } else if (choose == 3) {
            return tree.betweenOrder(tree.node, start, finish);
        } else {
            tree = new Tree(0, 0);
            for (Room r : rooms) {
                tree.insert(tree.node, r.getRoomNumber(), r.getCapacity());
            }
            return tree.inOrderDesc(tree.node);
        }
    }

    public void deleteEmployee(int id) {
        for (int i = 0; i < employee.size(); i++) {
            if (employee.get(i).getEmployee_id() == id) {
                employee.remove(i);
                break;
            }
        }
    }

    public void deleteCustomer(int id) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getID() == id) {
                customers.remove(i);
                break;
            }
        }
    }

    public static int getCustomerID() {
        return customerID;
    }

    public static void setCustomerID(int customerID) {
        Otel.customerID = customerID;
    }

    public static int getRoomID() {
        return roomID;
    }

    public static void setRoomID(int roomID) {
        Otel.roomID = roomID;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getOtelName() {
        return otelName;
    }

    public void setOtelName(String otelName) {
        this.otelName = otelName;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public HashMap<Integer, String> getRoom() {
        return room;
    }

    public void setRoom(HashMap<Integer, String> room) {
        this.room = room;
    }

    public ArrayList<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(ArrayList<Employee> employee) {
        this.employee = employee;
    }

}
