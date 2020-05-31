package guı_version_3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Services {

	private HashMap<String, Integer> Services;

	public Services() {
		super();
		Services = new HashMap<String, Integer>();
		addAutoServices();
	}

	public HashMap<String, Integer> getServices() {
		return Services;
	}

	public void setServices(HashMap<String, Integer> services) {
		Services = services;
	}

	@Override
	public String toString() {
		String temp = "";
		for (String key : Services.keySet()) {
			temp += "Service : " + key + " Price : " + Services.get(key) + "\n";
		}
		return temp;
	}

	public void addService(String ServiceName, int price) {
		Services.put(ServiceName, price);
		System.out.println("Successfully added ");
	}

	public void removeService(String ServiceName) {
		Services.remove(ServiceName);
		System.out.println("Successfully removed");

	}
	public void UpdateServicePrice(String ServiceName,int price) {
		Services.put(ServiceName,price);
		System.out.println("Succesfully update");

	}
	
	public void SearchService(String ServiceName) {
		if(Services.keySet().contains(ServiceName)) {
			System.out.println("Service is found !!!");
		}
		else {
			System.out.println("There is not this service ");
		}
	}
	
	public void addAutoServices() {
		Services.put("Spa", 150);
		Services.put("Massage",125);
		Services.put("Open Buffet",50);
		Services.put("Gym",30);
		Services.put("Mini Bar",175);
		Services.put("Laundry Service",25);
		Services.put("Safety Deposit Box",50);
		Services.put("Meeting Room",100);
		Services.put("Room Service",125);
		Services.put("Hypoallergenic Rooms",200);
	}
	
	public ArrayList<Object> displayServices() {
		ArrayList<Object> servisDisp =new ArrayList<Object>();
		for (String key : Services.keySet()) {
			String[] servis =new String[2];
			servis[0]=key;
			servis[1]=String.valueOf(Services.get(key));
			servisDisp.add(servis);
		}
		return servisDisp;
	}

}
