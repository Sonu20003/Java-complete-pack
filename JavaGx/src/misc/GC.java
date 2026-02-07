package misc;

import utility.MyUtility;

public class GC {
    public static void main(String[] args) {
        Person p1 = new Person("Sonu", 22);
        MyUtility.print(p1);
        p1 = null;
        MyUtility.print(p1);
    }

}

record Person(String name, int age) {

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}