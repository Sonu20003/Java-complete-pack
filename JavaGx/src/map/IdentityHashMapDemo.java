package map;

import utility.MyUtility;

import java.util.HashMap;
import java.util.IdentityHashMap;

public class IdentityHashMapDemo {
    public static void main(String[] args) {
        // identity hashmaps are a bit different,
        // only difference is that they use the Object class Hashcode method
        // and == operator to check weather the key is different or not,
        // well it has one advantage it checks for true difference, that is the memory address.

        HashMap<Person, String> map1 = new HashMap<>();
        IdentityHashMap<Person, String> map2 = new IdentityHashMap<>();

        Person p1 = new Person(1L, "Sonu");
        Person p2 = new Person(1L, "Sonu");

        MyUtility.print("Hashcode of p1: "+p1.hashCode());
        MyUtility.print("Hashcode of p1: "+p2.hashCode());
        MyUtility.print("Result of p1 & p2 equals methods: "+p1.equals(p2));

        map1.put(p1, "p1");
        map1.put(p2, "p2");

        map2.put(p1, "p1");
        map2.put(p2, "p2");

        MyUtility.print("Hashmap content: ");
        MyUtility.print(map1);

        MyUtility.print("IdentityHashmap content: ");
        MyUtility.print(map2);

    }

    record Person(Long id, String name) {
        @Override
        public boolean equals(Object obj) {
            if(obj == null || obj.getClass() != getClass()) return false;
            if(obj == this) return true;

            Person that = (Person) obj;
            return this.id.equals(that.id) && this.name.equals(that.name);
        }

        @Override
        public int hashCode() {
            return java.util.Objects.hash(id, name);
        }
    }
}
