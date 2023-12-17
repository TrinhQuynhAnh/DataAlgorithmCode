package Sets_and_Maps;
import java.util.HashMap;
import java.util.Set;

public class Users {
    private HashMap<String, User> userMap;
    public Users() {
        userMap = new HashMap<String, User>();
    }
    public void addUser(User user) {
        userMap.put(user.getUserID(), user);
    }
    public User getUser(String userID) {
        return userMap.get(userID);
    }
    public Set<String> getUserIDs() {
        return userMap.keySet();
    }
}
