package Comparables;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CustomerComparable {

    public static void main(String[] args) {
        Customer c1 = new Customer("11" ,"Venkat" ,"Venkat@gmail");
        Customer c2 = new Customer("12","Sai", "Sai@gamil");
        Customer c3 = new Customer("13","Kotla", "Kotla@gmail");

        List<Customer> customerList = new ArrayList<>();
        customerList.add(c1);
        customerList.add(c2);
        customerList.add(c3);
        Collections.sort(customerList);


        customerList.forEach(System.out::println);
    }
}
