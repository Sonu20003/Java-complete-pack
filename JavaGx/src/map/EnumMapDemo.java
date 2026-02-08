package map;

import utility.MyUtility;
import java.util.EnumMap;

public class EnumMapDemo {

    // You need an Enum to use as the key
    enum Days {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    public static void main(String[] args) {

        // You MUST pass the class type in the constructor
        // This is so the Map knows the size of the array to create internally
        EnumMap<Days, String> schedule = new EnumMap<>(Days.class);

        schedule.put(Days.MONDAY, "Work");
        schedule.put(Days.FRIDAY, "Party");
        schedule.put(Days.SUNDAY, "Rest");

        // It always maintains the NATURAL order of the Enum (declaration order)
        // No matter what order you put them in.
        MyUtility.print("Weekly Schedule: " + schedule);

        // Very fast check
        if (schedule.containsKey(Days.MONDAY)) {
            MyUtility.print("Monday is booked: " + schedule.get(Days.MONDAY));
        }

        // It doesn't allow null keys (obviously, since it's an enum)
        // But it DOES allow null values.
        schedule.put(Days.SATURDAY, null);
        MyUtility.print("Saturday status: " + schedule.get(Days.SATURDAY));
    }
}
