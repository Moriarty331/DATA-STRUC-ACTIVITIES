public class User 
{
    int userID;
    String username, email;

    User (int userID, String username, String email)
    {
        this.userID = userID;
        this.username = username;
        this.email = email;
    }

    void logIn()
    {
        System.out.println("\n" + username + " successfully logged in!\n");
    }

    void logOut()
    {
        System.out.println("\nYou successfully logged out.");
    }
}

