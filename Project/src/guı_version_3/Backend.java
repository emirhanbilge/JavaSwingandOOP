/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guı_version_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author ebb
 */
public class Backend {
    public static boolean checkBirthDate(String birthdate) {
		Date date = new Date(System.currentTimeMillis());
		String[] date1 = date.toString().split(("-"));
		if (birthdate.contains(".")) {
			String arr[] = birthdate.split(".");
			if (arr.length == 3) {
				try {
					if ((Integer.valueOf(date1[0]) - Integer.valueOf(arr[2]) > 18)) {
						return true;
					} else if ((Integer.valueOf(date1[0]) - Integer.valueOf(arr[2]) == 18)) {
						if ((Integer.valueOf(date1[1]) - Integer.valueOf(arr[1]) > -1)) {
							return true;
						} else {
							return false;
						}
					} else {
						return false;
					}

				} catch (Exception e) {
					return false;
				}
			}
		} else if (birthdate.contains("/")) {
			String arr[] = birthdate.split("/");
			if (arr.length == 3) {
				try {
					if ((Integer.valueOf(date1[0]) - Integer.valueOf(arr[2]) > 18)) {
						return true;
					} else if ((Integer.valueOf(date1[0]) - Integer.valueOf(arr[2]) == 18)) {
						if ((Integer.valueOf(date1[1]) - Integer.valueOf(arr[1]) > -1)) {
							return true;
						} else {
							return false;
						}
					} else {
						return false;
					}

				} catch (Exception e) {
					return false;
				}
			}
		} else if (birthdate.contains("-")) {
			String arr[] = birthdate.split("-");
                    
			if (arr.length == 3) {
				try {
					if ((Integer.valueOf(date1[0]) - Integer.valueOf(arr[2]) > 18)) {
						return true;
					} else if ((Integer.valueOf(date1[0]) - Integer.valueOf(arr[2]) == 18)) {
						if ((Integer.valueOf(date1[1]) - Integer.valueOf(arr[1]) > -1)) {
							return true;
						} else {
							return false;
						}
					} else {
						return false;
					}

				} catch (Exception e) {
                                    
					return false;
				}
			} 
		} else if (birthdate.contains(" ")) {
			String arr[] = birthdate.split(" ");
			if (arr.length == 3) {
				try {
					if ((Integer.valueOf(date1[0]) - Integer.valueOf(arr[2]) > 18)) {
						return true;
					} else if ((Integer.valueOf(date1[0]) - Integer.valueOf(arr[2]) == 18)) {
						if ((Integer.valueOf(date1[1]) - Integer.valueOf(arr[1]) > -1)) {
							return true;
						} else {
							return false;
						}
					} else {
						return false;
					}

				} catch (Exception e) {
					return false;
				}
			}
		} else {
			return false;
		}
		return false;
	}
	
	public static String LogIn(String email , String password) {
		try {
		      File myObj = new File("User.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String[] data = myReader.nextLine().split(" ");       
		        if(data[2].equals(email) && data[4].equals(password)){
		        	return "Welcome "+ data[0];
		        }
		      }
		      myReader.close();
		      return "";
		    } catch (FileNotFoundException e) {
		    	return "";
		    }		
	}
	
	
	public static int Menu() {
		System.out.println("1- Display employee");
		System.out.println("2- Display room");
		System.out.println("3- Display customers");
		System.out.println("4- Display services");
		System.out.println("5- Search room");
		System.out.println("6- Rezervation");
		System.out.println("7- Delete employee");
		Scanner scanner = new Scanner(System.in);
		try {
			return scanner.nextInt();
		} catch (Exception e) {
			return -1 ;
		}
	}
	
	
}
