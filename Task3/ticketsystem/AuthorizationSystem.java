package ticketsystem;

import java.util.*;
public class AuthorizationSystem
{
    private static ArrayList<User> allUsers = new ArrayList<>();

    static
    {
        allUsers.add(new AdminUser("admin", "admin"));
    }

    public static User TryToLogin(String login, String password)
    {
        for(User user : allUsers)
        {
            if(user.TryToLogin(login, password))
                return user;
        }
        return null;
    }
}