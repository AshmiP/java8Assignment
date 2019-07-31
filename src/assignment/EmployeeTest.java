package assignment;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class EmployeeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Employee employee1 = new Employee(
                "Yash",
                20,
                new Address("1234"),
                Arrays.asList(new MobileNumber("1233"), new MobileNumber("1234")));
     
            Employee employee2 = new Employee(
                "Ram",
                30,
                new Address("1235"),
                Arrays.asList(new MobileNumber("1111"), new MobileNumber("3333"), new MobileNumber("1233")));
     
            Employee employee3 = new Employee(
                "Sita",
                50,
                new Address("1236"),
                Arrays.asList(new MobileNumber("3333"), new MobileNumber("4444")));
            
            List<Employee> employees = Arrays.asList(employee1, employee2, employee3);
            
            // Get employee with exact match name "Yash", if not found print "Not found".
            System.out.println("************************************************");
            System.out.println("Get employee with exact match name Yash, if not found print Not found\n");
            List<Employee> exactMatch = employees.stream().filter(emp->emp.getName().equals("Yash")).collect(Collectors.toList());
            System.out.println(exactMatch.isEmpty()?"not found":"found"+exactMatch.toString());
            
            
            // Get employee with matching address "1235"
            System.out.println("************************************************");
            System.out.println("Get employee with matching address 1235\n");
            List<Employee> addressMatch = employees.stream().filter(emp->emp.getAddress().getZipcode().equals("1235")).collect(Collectors.toList());
            System.out.println(addressMatch);
            
            
            // Get all employee having mobile numbers 3333.
          
           System.out.println("************************************************");
           System.out.println("Get all employee having mobile numbers 3333\n");
           
           //List<Employee> empnums= (List<Employee>) employees.stream().peek(  emp->emp.getMobileNumbers().forEach(  e1->e1.getNumber().contains("3333"))).collect(Collectors.toList());
          List<Employee> empnums= employees.stream().filter(emp->emp.getMobileNumbers()
        		                  .stream().map(MobileNumber::getNumber)
        		                  .anyMatch(num->num.equals("3333"))).collect(Collectors.toList());           
           empnums.forEach(System.out::println);
           System.out.println("***********************************************");
            
           
           // Convert List<Employee> to List<String> of employee name
           System.out.println("************************************************");
           System.out.println("Convert List<Employee> to List<String> of employee name\n");
           List<String> empList = employees.stream().map(emp->emp.getName()).collect(Collectors.toList());
            empList.forEach(System.out::println);
                       
            // Collect all the names of employees in a string separated by ||
            System.out.println("************************************************");
            System.out.println("Collect all the names of employees in a string separated by ||\n");
            
            String strEmp = empList.stream().map(emp->emp.toString()).collect(Collectors.joining("||"));
            System.out.println(strEmp);
            
            
            // Change the case of List<String>
            System.out.println("************************************************");
            System.out.println(" Change the case of List<String>\n");
           // List<String> empCase = empList.stream().map(emp->emp.toString().toUpperCase()).collect(Collectors.toList());
            List<String> empCase = empList.stream().map(emp->changeCase(emp.toString())).collect(Collectors.toList());
            empCase.forEach(System.out::println);
            
            
            // Sort List<String>
            System.out.println("************************************************");
            System.out.println("  Sort List<String>\n");
            List<String> empSort = empList.stream().sorted().collect(Collectors.toList());
           empSort.forEach(System.out::println);
            
            
            // sort List<Employee> based on name
           System.out.println("************************************************");
           System.out.println("  sort List<Employee> based on name\n");
           List<Employee> nameSort = employees.stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
           nameSort.forEach(System.out::println);
           
    
	}
	public static String changeCase(String text){
		char[] chars = text.toCharArray();
	    for (int i = 0; i < chars.length; i++)
	    {
	        char c = chars[i];
	        if (Character.isUpperCase(c))
	        {
	            chars[i] = Character.toLowerCase(c);
	        }
	        else if (Character.isLowerCase(c))
	        {
	            chars[i] = Character.toUpperCase(c);
	        }
	    }
	    return new String(chars);	}
	

}
