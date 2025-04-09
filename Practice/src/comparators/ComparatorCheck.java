package comparators;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorCheck {
    public static void main(String[] args) {
        User u1 = new User("12","Venkat" ,"Venkat@gmail");
        User u2 = new User("23" ,"Sai", "Sai@gmail");
        User u3 = new User("12", "kotla" , "kotla@gmail");
        List<User> userList = new ArrayList<>();
        userList.add(u1);
        userList.add(u2);
        userList.add(u3);
        userList.sort(new SortUser());

        userList.forEach(System.out::println);
    }
}

class SortUser implements Comparator<User>{

    @Override
    public int compare(User u1, User u2) {
        int value = u1.getId().compareTo(u2.getId());

        if(value == 0){
            return u1.getEmail().compareTo(u2.getEmail());
        }
        return value;
    }
}
