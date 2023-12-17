public class Contact implements Comparable<Contact> {
    private String firstName, lastName, phone;

    public Contact(String first, String last, String telephone) {
        firstName = first;
        lastName = last;
        phone = telephone;
    }

    public String toString() {
        return lastName + ", " + firstName + "\t" + phone;
    }

    public int compareTo(Contact other) {
        int result = lastName.compareTo(other.lastName);
        if (result == 0) {
            result = firstName.compareTo(other.firstName);
        }
        return result;
    }
}