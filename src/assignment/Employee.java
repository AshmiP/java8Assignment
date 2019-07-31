package assignment;

import java.util.List;
public class Employee {

	 private String name;
	    private int age;
	    private Address address;
	    private List<MobileNumber> mobileNumbers;
	    
	    public Employee(String name, int age, Address address, List<MobileNumber> mobileNumbers) {
	        this.name = name;
	        this.age = age;
	        this.address = address;
	        this.mobileNumbers = mobileNumbers;
	    }
	 
	    public String getName() {
	        return name;
	    }
	 
	    public int getAge() {
	        return age;
	    }
	 
	    public Address getAddress() {
	        return address;
	    }
	 
	    public List<MobileNumber> getMobileNumbers() {
	        return mobileNumbers;
	    }
	 
	    public void setName(String name) {
	        this.name = name;
	    }
	 
	    public void setAge(int age) {
	        this.age = age;
	    }
	 
	    public void setAddress(Address address) {
	        this.address = address;
	    }
	 
	    public void setMobileNumbers(List<MobileNumber> mobileNumbers) {
	        this.mobileNumbers = mobileNumbers;
	    }
	 
	    @Override
	    public String toString() {
	        return "Employee{" +
	            "name='" + name + '\'' +
	            ", age=" + age +
	            ", address=" + address +
	            ", mobileNumbers=" + mobileNumbers +
	            '}';
	    }

}

class Address{
    private String zipcode;
 
    public Address(String zipcode) {
        this.zipcode = zipcode;
    }
 
    public String getZipcode() {
        return zipcode;
    }
 
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

	@Override
	public String toString() {
		return "Address [zipcode=" + zipcode + "]";
	}
    
}
 
class MobileNumber{
    private String number;
 
    @Override
	public String toString() {
		return "MobileNumber [number=" + number + "]";
	}

	public MobileNumber(String number) {
        this.number = number;
    }
 
    public String getNumber() {
        return number;
    }
 
    public void setNumber(String number) {
        this.number = number;
    }
}
