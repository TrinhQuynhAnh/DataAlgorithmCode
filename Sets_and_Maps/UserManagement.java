package Sets_and_Maps;

import java.io.IOException;
import java.util.Scanner;

public class UserManagement {
    public static void main(String[] args) throws IOException {
        Users users = new Users();
        users.addUser(new User("fziffle", "Fred", "Ziffle"));
        users.addUser(new User("geoman57", "Marco", "Kane"));
        users.addUser(new User("rover322", "Kathy", "Shear"));
        users.addUser(new User("appleseed", "Sam", "Geary"));
        users.addUser(new User("mon2016", "Monica", "Blankenship"));
        Scanner sc = new Scanner(System.in);
        String uid;
        User user;
        do {
            System.out.println("Enter User ID (DONE to quit): ");
            uid = sc.nextLine();
            if (!uid.equalsIgnoreCase("DONE")) {
                user = users.getUser(uid);
                if (user == null) {
                    System.out.println("User not found.");
                } else {
                    System.out.println(user);
                }

            }
        } while (!uid.equalsIgnoreCase("DONE"));
        System.out.println("\nAll Users:\n");
        for (String userId : users.getUserIDs())
            System.out.println(users.getUser(userId));
    }
}
