//to save user data
public class Userdata {
    private String userName;
    private String userId;
    private String userPas;

    public Userdata(String userName, String userId, String userPas) {
        this.userName = userName;
        this.userId = userId;
        this.userPas = userPas;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserPas() {
        return userPas;
    }
}
