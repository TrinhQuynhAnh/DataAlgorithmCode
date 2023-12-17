package Sets_and_Maps;

public class User {
    private String userID;
    private String firstName;
    private String lastName;
    public User(String userID, String firstName, String lastName) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getUserID() {
        return userID;
    }
    public String toString() {
        return userID + ":\t" + lastName + ", " + firstName;
    }
}
