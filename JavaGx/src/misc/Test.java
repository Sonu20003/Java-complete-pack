package misc;

import utility.MyUtility;

import java.util.*;

public class Test {
    public static void main(String[] args) {

        List<Student> list = List.of(
                new Student(101, "Sonu"),
                new Student(102, "Greece"),
                new Student(105, "Aron")
        );

        // some comments here

        Set<Integer> set =  new HashSet<>();

        list.stream().filter(
                x -> {
                    boolean isPresent = !set.contains(x.id());
                    set.add(x.id());
                    return isPresent;
                }
        ).forEach(MyUtility::print);

        // method 2:
        MyUtility.print("---Method 2---");
        list.stream()
                .map(Student::id)
                .distinct()
                .map(x -> list.get(getFirstIndexById(x, list)))
                .forEach(MyUtility::print);

        // sort by name
        MyUtility.print("sort by name: ");
        list.stream().sorted().forEach(MyUtility::print);

    }
    public static int getFirstIndexById(Integer id, List<Student> li) {
        for(int i=0; i<li.size(); i++) {
            if(li.get(i).id().equals(id)) return i;
        }
        return -1;
    }

}

record Student(Integer id, String name) implements Comparable<Student>{

    @Override
    public int compareTo(Student that) {
        return this.name.compareTo(that.name());
    }
}